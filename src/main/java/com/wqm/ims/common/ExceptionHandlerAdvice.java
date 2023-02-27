package com.wqm.ims.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.wqm.ims.common.Constant.*;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     * 系统异常处理
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception(Throwable throwable) {
        return new Response(commonErrorNo,commonErrorMsg,null);
    }
}
