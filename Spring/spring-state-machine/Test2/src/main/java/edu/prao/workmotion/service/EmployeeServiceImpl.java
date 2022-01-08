package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
    public static final String EMPLOYEE_ID_HEADER = "employee_id";
    
    private final EmployeeRepo repo;
    private final StateMachineFactory<EmployeeState, EmployeeEvent> factory;

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setState(EmployeeState.ADDED);
        return repo.save(employee);
    }

    @Override
    public Employee fetchEmployeeDetails(Long employeeId) {
        return repo.getById(employeeId);
    }

    @Transactional
    @Override
    public Employee updateEmployeeState(Long employeeId, EmployeeEvent event) {
        //StateMachine<EmployeeState, EmployeeEvent> stateMachine = factory.getStateMachine(Long.toString(employeeId));

        Employee employee = repo.getById(employeeId);
        StateMachine<EmployeeState, EmployeeEvent> stateMachine = build(employee);
        System.out.println(stateMachine.getState());
        //sendEvent(employeeId, stateMachine, event);
        boolean b = stateMachine.sendEvent(event);
        System.out.println(stateMachine.getState());
        System.out.println(stateMachine.getState().getIds());
        System.out.println(stateMachine.getStateMachineAccessor());
        System.out.println(stateMachine.getTransitions());
        System.out.println(stateMachine.getState().getStates());
        System.out.println(stateMachine.getState().getPseudoState());
        System.out.println(stateMachine.getState());
        employee.setState(stateMachine.getState().getId());
        return repo.save(employee);
    }

    private StateMachine<EmployeeState, EmployeeEvent> build(Employee employee){
        StateMachine<EmployeeState, EmployeeEvent> sm = factory.getStateMachine(Long.toString(employee.getId()));
        sm.stopReactively();

        sm.getStateMachineAccessor()
                .doWithAllRegions(sma -> sma.resetStateMachineReactively(new DefaultStateMachineContext<>(employee.getState(), null, null, null)));

        sm.startReactively();

        return sm;
    }

    private void sendEvent(Long paymentId, StateMachine<EmployeeState, EmployeeEvent> sm, EmployeeEvent event){
        Message msg = MessageBuilder.withPayload(event)
                .setHeader(EMPLOYEE_ID_HEADER, paymentId)
                .build();

        sm.sendEvent(msg);
    }
}
