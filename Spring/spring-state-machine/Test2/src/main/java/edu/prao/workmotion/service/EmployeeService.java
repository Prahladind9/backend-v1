package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.model.EmployeeModel;

public interface EmployeeService {
    EmployeeModel addEmployee(Employee employee);
    EmployeeModel getEmployeeDetails(Long employeeId);
    EmployeeModel updateEmployeeState(Long employeeId, String event);
}
