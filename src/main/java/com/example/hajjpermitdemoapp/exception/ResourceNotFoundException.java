package com.example.hajjpermitdemoapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String massage){
        super(massage);
    }
    public ResourceNotFoundException(String massage, Throwable cause){
        super(massage,cause);
    }
}
