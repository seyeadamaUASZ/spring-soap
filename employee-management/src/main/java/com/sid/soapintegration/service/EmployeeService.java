package com.sid.soapintegration.service;

import com.sid.soapintegration.model.Employee;
import com.sid.soapintegration.repositorie.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.webservicesoap.birthday.EmployeeRequest;
import org.webservicesoap.birthday.EmployeeResponse;

@Service
public class EmployeeService {
  private final EmployeeRepository repository;

  public EmployeeService(EmployeeRepository repository) {
    this.repository = repository;
  }

  public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
     return convertToEmployeeResponse(repository.save(convertToEmployee(employeeRequest)));
  }

  public List<EmployeeResponse> listEmployees(){
    return repository.findAll()
        .stream()
        .map(this::convertToEmployeeResponse)
        .collect(Collectors.toList());
  }

  public EmployeeResponse getEmployee(Long id){
    Employee employee= repository.findById(id)
        .orElseThrow(()->new RuntimeException("employee not found"));
    return convertToEmployeeResponse(employee);
  }

  private Employee convertToEmployee(EmployeeRequest request){
    Employee employee = new Employee();
    employee.setFirstname(request.getFirstname());
    employee.setLastname(request.getLastname());
    employee.setPoste(request.getPoste());
    return employee;
  }

  private EmployeeResponse convertToEmployeeResponse(Employee employee){
    EmployeeResponse employeeResp = new EmployeeResponse();
    employeeResp.setFirstname(employee.getFirstname());
    employeeResp.setLastname(employee.getLastname());
    employeeResp.setPoste(employee.getPoste());
    return employeeResp;
  }


}
