package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.ApiResponse;
import com.microservice.employee_service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    ApiResponse getEmployeeById(Long empId);

}
