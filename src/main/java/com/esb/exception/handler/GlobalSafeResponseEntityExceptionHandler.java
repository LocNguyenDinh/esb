package com.esb.exception.handler;

import com.esb.exception.ErrorCode;
import com.esb.exception.ErrorHelper;
import com.esb.exception.GlobalSafeException;
import com.esb.exception.Response;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class GlobalSafeResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Throwable.class})
    protected ResponseEntity<Response> handlerEx(Throwable ex, WebRequest request){
        HttpHeaders headers = new HttpHeaders();
        if(ex instanceof GlobalSafeException){
            GlobalSafeException exception = (GlobalSafeException) ex;
            String message = exception.getMessage() == null
                    ? exception.getResponse().toString()
                    : exception.getMessage();
            return  new ResponseEntity<>(((GlobalSafeException) ex).getResponse(), headers, HttpStatus.BAD_REQUEST);
        }
        Response errorObject = ErrorHelper.buildResponse(ErrorCode.INTERNAL_SERVER_ERROR);
        return  new ResponseEntity<>(errorObject, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
