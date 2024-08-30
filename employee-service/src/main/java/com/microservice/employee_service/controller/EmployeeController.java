package com.microservice.employee_service.controller;

import com.microservice.employee_service.dto.ApiResponse;
import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    // get employee By Id;

    @GetMapping("/id/{empId}")
    ResponseEntity<ApiResponse> getEmployeeById(@PathVariable ("empId") Long empId){

        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

}
