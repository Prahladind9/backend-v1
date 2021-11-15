package com.spring.professional.service.a;

import com.spring.professional.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public /*final*/ class EmployeeRepositoryImpl implements EmployeeRepository{
    @Override
    public Employee findEmployeeById(long id) {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public /*final*/ void deleteEmployee(Employee employee) {

    }

    @Override
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeId = findEmployeeById(id);
        saveEmployee(employeeId);
    }

    public void deleteByEmail(String email){

    }
}
