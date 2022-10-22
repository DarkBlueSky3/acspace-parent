package com.acspace.response;

import com.acspace.errorCode.ErrorCodeFactory;
import com.acspace.errorCode.GeneralErrorCode;
import com.acspace.errorCode.SystemErroCode;

import java.io.Serializable;

/**
 * 描述
 *
 * @author wangchen
 * @version 1.0
 * @package com.acsapce.entity *
 * @since 1.0
 */
public class ResponseMessage<T> implements Serializable {
    private Integer errCode;

    private String errMsg;

    private String errDetail;

    private String service;
    private T data;//返回数据

    public ResponseMessage() {
    }

    public ResponseMessage(Integer errCode, String errMsg, String service, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.service = service;
        this.data = data;
    }

    public static<T> ResponseMessage<T> success(T data, String message) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(SystemErroCode.SUCCESS.getCode());
        if (message == null) {
            responseMessage.setErrMsg(SystemErroCode.SUCCESS.getMsg());
        } else {
            responseMessage.setErrMsg(message);
        }
        responseMessage.setData(data);
        responseMessage.setService("default");
        return responseMessage;
    }

    public static<T> ResponseMessage<T> success() {
        return success(null, null);
    }

    public static<T> ResponseMessage<T> success(T data) {
        return success(data, null);
    }

    public static<T> ResponseMessage<T> success(String message) {
        return success(null, message);
    }

    public static ResponseMessage<Object> error(Object errorCode, String msg) {
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        GeneralErrorCode generalErrorCode = ErrorCodeFactory.createErrorCode(errorCode, msg);
        responseMessage.setErrCode(generalErrorCode.getCode());
        responseMessage.setErrMsg(generalErrorCode.getMessage());
        responseMessage.setService(responseMessage.getService());
        return responseMessage;
    }

    public static ResponseMessage<Object> error(GeneralErrorCode generalErrorCode, String message) {
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(generalErrorCode.getCode());
        responseMessage.setErrMsg(message);
        responseMessage.setService(generalErrorCode.getService());
        return responseMessage;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
