package com.microservice.department_service.controller;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }
    // Get All Department Api.
    @GetMapping
    ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    //Get Department by id api
    @GetMapping("/{departmentId}")
    ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable ("departmentId") Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));

    }
    // Api for get department by departmentCode;
    @GetMapping("/code/{departmentCode}")
    ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable ("departmentCode") String departmentCode){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }
}
