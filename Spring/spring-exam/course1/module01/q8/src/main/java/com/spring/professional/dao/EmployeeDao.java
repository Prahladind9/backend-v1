package com.spring.professional.dao;

import com.spring.professional.ds.Employee;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeDao {
    public List<Employee> findAll() {
        System.out.println("Finding all employees");
        return Collections.emptyList();
    }
}
