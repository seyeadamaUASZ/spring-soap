package com.sid.soapintegration.Endpoint;

import com.sid.soapintegration.service.EmployeeService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.birthday.EmployeeRequest;
import org.webservicesoap.birthday.EmployeeResponse;

@Endpoint
public class EmployeeEndpoint {
  private static final String NAMESPACE = "http://www.webservicesoap.org/birthday";

  private final EmployeeService employeeService;

  public EmployeeEndpoint(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PayloadRoot(localPart = "employeeRequest", namespace = NAMESPACE)
  @ResponsePayload
  public EmployeeResponse getBirthdayRequest(@RequestPayload EmployeeRequest request) {
    return employeeService.addEmployee(request);
  }


}
