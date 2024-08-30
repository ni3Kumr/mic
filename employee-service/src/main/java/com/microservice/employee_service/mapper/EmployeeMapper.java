//package com.microservice.employee_service.mapper;
//
//import com.microservice.employee_service.dto.EmployeeDto;
//import com.microservice.employee_service.entity.Employee;
//
//public class EmployeeMapper {
//
//    public static Employee mapToEmployee(EmployeeDto employeeDto){
//
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );
//        return employee;
//    }
//    public static EmployeeDto mapToEmployeeDto (Employee employee){
//
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//        return employeeDto;
//    }
//}
