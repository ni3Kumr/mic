package com.microservice.department_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class DepartmentNotFoundException extends RuntimeException{

    private String message;
    private HttpStatus status;

    public DepartmentNotFoundException(HttpStatus status,String message){
        this.status=status;
        this.message=message;

    }
}

