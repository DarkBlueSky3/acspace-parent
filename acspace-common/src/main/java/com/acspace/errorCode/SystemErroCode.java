package com.acspace.errorCode;

import com.acspace.errorCode.annotations.ECGetCode;
import com.acspace.errorCode.annotations.ECGetHTTPStatus;
import com.acspace.errorCode.annotations.ECGetMessage;
import com.acspace.errorCode.annotations.ErrorCode;

@ErrorCode("default")
public enum SystemErroCode {
    SUCCESS(0, 200, "Sucess"),
    SYSTEM_ERROR(1, 500, "Internal Server Error"),
    FORBIDDEN(2, 403, "Forbidden"),
    UNAUTHORIZED(3, 401, "Unauthorized"),
    NOT_FOUND(4, 404, "Not Found"),
    ;

    private Integer code;
    private Integer httpCode;
    private String msg;

    SystemErroCode(Integer code, Integer httpCode, String msg) {
        this.code = code;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    @ECGetCode
    public Integer getCode() {
        return code;
    }

    @ECGetHTTPStatus
    public Integer getHttpCode() {
        return httpCode;
    }

    @ECGetMessage
    public String getMsg() {
        return msg;
    }
}
