package com.ibm.academia.apirest.exceptions.exceptionhandler;

import com.ibm.academia.apirest.exceptions.exceptionresponse.ExceptionResponse;
import com.ibm.academia.apirest.exceptions.exceptiontypes.BadRequestException;
import com.ibm.academia.apirest.exceptions.exceptiontypes.ExceptionType;
import com.ibm.academia.apirest.exceptions.exceptiontypes.InternalServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> invalidFormatException(BadRequestException exception, WebRequest request)
    {
        return createExceptionResponse(exception,request);
    }

    @ExceptionHandler(value = InternalServerException.class)
    public ResponseEntity<Object> TimeOutException(InternalServerException exception, WebRequest request)
    {
        return createExceptionResponse(exception,request);
    }

    private ResponseEntity<Object>  createExceptionResponse(ExceptionType exception, WebRequest request){
        ExceptionResponse response=new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setStatus(exception.getStatus().value());
        response.setError(exception.getStatus());
        response.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return new ResponseEntity<>(response, response.getError());
    }
}
