package com.microservice.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String  departmentCode;
}
