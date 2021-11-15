package com.spring.professional.service.b;

import com.spring.professional.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class AlternateEmployeeRepository {

    
    public Employee findEmployeeById(long id) {
        return null;
    }

    
    public void saveEmployee(Employee employee) {

    }

    
    public /*final*/ void deleteEmployee(Employee employee) {

    }

    
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeId = findEmployeeById(id);
        saveEmployee(employeeId);
    }
    
}
