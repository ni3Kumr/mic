package com.microservice.employee_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorDetails {


    private Date timeStamp;
    private String message;
    private String details;
}
