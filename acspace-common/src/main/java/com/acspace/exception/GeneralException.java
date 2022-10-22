package com.acspace.exception;

import com.acspace.errorCode.ErrorCodeFactory;
import com.acspace.errorCode.GeneralErrorCode;

public class GeneralException extends RuntimeException {
    private GeneralErrorCode generalErrorCode;
    private String detailMessage;
    private transient Object data;
    private transient Object[] args;

    public GeneralException(Object errorCode) {
        super();
        this.generalErrorCode = ErrorCodeFactory.createErroCode(errorCode);
        this.detailMessage = this.generalErrorCode.getMessage();
    }

    public GeneralErrorCode getGeneralErrorCode() {
        return generalErrorCode;
    }

    public void setGeneralErrorCode(GeneralErrorCode generalErrorCode) {
        this.generalErrorCode = generalErrorCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMessage() {
        return detailMessage;
    }
}
