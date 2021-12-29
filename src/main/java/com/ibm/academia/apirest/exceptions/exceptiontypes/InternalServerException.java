package com.ibm.academia.apirest.exceptions.exceptiontypes;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ExceptionType {
    public InternalServerException(HttpStatus status, String message) {
        super(status,message);
    }
}
