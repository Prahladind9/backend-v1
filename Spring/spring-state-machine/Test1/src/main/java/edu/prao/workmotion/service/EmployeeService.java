package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee fetchEmployeeDetails(Long employeeId);
    Employee updateEmployeeState(Long employeeId, EmployeeEvent event);
}
