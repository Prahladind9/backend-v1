package com.spring.professional.service.a;

import com.spring.professional.ds.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(long id);
    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void findAndUpdateEmployeeById(long id, Employee employeeToMerge);
}
