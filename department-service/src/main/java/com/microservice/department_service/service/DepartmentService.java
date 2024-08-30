package com.microservice.department_service.service;

import com.microservice.department_service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long departmentId);
    DepartmentDto getDepartmentByCode(String departmentCode);

}
