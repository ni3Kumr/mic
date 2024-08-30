package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.ApiResponse;
import com.microservice.employee_service.dto.DepartmentDto;
import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.entity.Employee;
import com.microservice.employee_service.exception.ResourceNotFoundException;
import com.microservice.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
  //  private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto,Employee.class);
       Employee savedEmployee =  employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDto.class);

    }
    // get all employee list
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> employeesList = employeeRepository.findAll();
        return employeesList.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public ApiResponse getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",empId));
        EmployeeDto   employeeDto= modelMapper.map(employee,EmployeeDto.class);

        // calling Department Service using restTemplate;
//        ResponseEntity<DepartmentDto> departmentDto = restTemplate
//                .getForEntity("http://localhost:8081/departments/code/"+employeeDto.getDepartmentCode(),DepartmentDto.class);

        // Calling Department Api using WebClient
//       DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8081/departments/code/"+employeeDto.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        // calling using feign client
         DepartmentDto departmentDto  = apiClient.getDepartmentByCode(employeeDto.getDepartmentCode());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setEmployee(employeeDto);
        apiResponse.setDepartment(departmentDto);
        return  apiResponse;
    }
}
