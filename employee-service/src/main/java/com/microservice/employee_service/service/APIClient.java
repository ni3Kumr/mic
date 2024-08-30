package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/code/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String departmentCode);
}
