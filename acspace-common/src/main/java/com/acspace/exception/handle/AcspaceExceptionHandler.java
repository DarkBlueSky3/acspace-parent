package com.acspace.exception.handle;

import com.acspace.errorCode.SystemErroCode;
import com.acspace.exception.GeneralException;
import com.acspace.response.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@ControllerAdvice
public class AcspaceExceptionHandler {

    Logger logger = LoggerFactory.getLogger(AcspaceExceptionHandler.class);

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseMessage<Object> handle(Exception e) {
        ResponseMessage<Object> responseMessage;
        if (e instanceof GeneralException) {
            responseMessage = handleGeneralException((GeneralException) e);
        } else  {
            responseMessage = handleSystemErrorCode(SystemErroCode.SYSTEM_ERROR, e.getMessage());
        }
        return responseMessage;
    }

    private ResponseMessage<Object> handleSystemErrorCode(SystemErroCode systemErroCode, String errDetail) {
        response.setStatus(systemErroCode.getHttpCode());
        String messageKey = "default_" + systemErroCode.name();
        String message = getLocaleMessage(messageKey, null);
        if (message == null) {
            message = systemErroCode.getMsg();
        }
        ResponseMessage<Object>  responseMessage = ResponseMessage.error(systemErroCode, message);
        responseMessage.setErrDetail(errDetail);
        return responseMessage;
    }

    private ResponseMessage<Object> handleGeneralException(GeneralException e) {
        response.setStatus(e.getGeneralErrorCode().getHttpCode());
        String errMessage = getLocaleMessage(e);
        ResponseMessage<Object> responseMessage = ResponseMessage.error(e.getGeneralErrorCode(), errMessage);
        responseMessage.setData(e.getData());
        responseMessage.setErrDetail(e.getMessage());
        return responseMessage;
    }

    private String getLocaleMessage(GeneralException e) {
        String messageKey = e.getGeneralErrorCode().getService().toUpperCase() + "_"
                + e.getGeneralErrorCode().getStrCode().toUpperCase();
        String msg = getLocaleMessage(messageKey, e.getArgs());
        if (msg == null) {
            return e.getMessage();
        }
        return msg;
    }

    private String getLocaleMessage(String messageKey, Object[] args) {
        String localMessage = null;
        try {
            logger.info("messageKey:{}", messageKey);
            Locale locale = LocaleContextHolder.getLocale();
            localMessage = messageSource.getMessage(messageKey, args, null, locale);
            logger.info("localMessage: {}", localMessage);
        } catch (Exception e) {
            logger.error("get local message error! {}", e);
        }
        return localMessage;
    }
}
