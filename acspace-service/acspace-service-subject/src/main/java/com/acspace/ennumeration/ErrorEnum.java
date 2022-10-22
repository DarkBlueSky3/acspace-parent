package com.acspace.ennumeration;

import com.acspace.errorCode.annotations.ECGetCode;
import com.acspace.errorCode.annotations.ECGetHTTPStatus;
import com.acspace.errorCode.annotations.ECGetMessage;
import com.acspace.errorCode.annotations.ErrorCode;

@ErrorCode("SUBJECT-SERVICE")
public enum ErrorEnum {
    ERROR(10001, 400, "参数错误")
    ;

    private Integer code;
    private Integer httpCode;
    private String message;

    ErrorEnum(Integer code, Integer httpCode, String message) {
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
    }

    @ECGetCode
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @ECGetHTTPStatus
    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    @ECGetMessage
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
