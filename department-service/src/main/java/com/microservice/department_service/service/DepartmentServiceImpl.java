package com.microservice.department_service.service;

import com.microservice.department_service.exception.DepartmentNotFoundException;
import com.microservice.department_service.exception.ResourceNotFoundException;
import com.microservice.department_service.mapper.ModelMapper;
import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.entity.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;


    // create Department
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = ModelMapper.mapToDepartment(departmentDto);
       Department savedDepartment =departmentRepository.save(department);
        return  ModelMapper.mapToDepartmentDto(savedDepartment);
    }
    // Get all departments
    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department>  departmentList= departmentRepository.findAll();
        return departmentList.stream().
                map(ModelMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    // Get Department By id
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department","id", departmentId));
        return ModelMapper.mapToDepartmentDto(department);

    }
// get department By departmentCode;
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(()->new DepartmentNotFoundException(HttpStatus.BAD_REQUEST," Department Not Found with given code!"));
      return ModelMapper.mapToDepartmentDto(department);
    }
}
