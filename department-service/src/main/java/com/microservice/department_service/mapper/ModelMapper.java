package com.microservice.department_service.mapper;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.entity.Department;

public class ModelMapper {
    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                 departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        return department;


    }
    public static DepartmentDto mapToDepartmentDto(Department department){

        DepartmentDto departmentDto = new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }


}
