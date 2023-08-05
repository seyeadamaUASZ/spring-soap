package com.sid.soapintegration.repositorie;

import com.sid.soapintegration.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
