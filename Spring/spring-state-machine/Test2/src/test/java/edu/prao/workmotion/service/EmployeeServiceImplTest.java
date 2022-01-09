package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.model.EmployeeModel;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepo repo;

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder().name("prao").build();
    }

    @Transactional
    @Test
    void preAuth() {
        EmployeeModel savedEmployee = employeeService.addEmployee(employee);

        log.info("Should be ADDED");
        log.info("SavedState", savedEmployee.getEmployee().getState());

        employeeService.updateEmployeeState(savedEmployee.getEmployee().getId(), EmployeeEvent.TO_IN_CHECK.name());

        Employee employee = repo.getById(savedEmployee.getEmployee().getId());
        log.info("employee", employee);

    }


    /*@Transactional
    @RepeatedTest(10)
    void testAuth() {
        Payment savedPayment = employeeService.newPayment(payment);

        StateMachine<EmployeeState, EmployeeEvent> preAuthSM = employeeService.preAuth(savedPayment.getId());

        if (preAuthSM.getState().getId() == EmployeeState.PRE_AUTH) {
            System.out.println("Payment is Pre Authorized");

            StateMachine<EmployeeState, EmployeeEvent> authSM = employeeService.authorizePayment(savedPayment.getId());

            System.out.println("Result of Auth: " + authSM.getState().getId());
        } else {
            System.out.println("Payment failed pre-auth...");
        }
    }*/
}