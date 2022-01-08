package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static edu.prao.workmotion.entity.EmployeeState.*;
import static edu.prao.workmotion.util.EmployeeUtil.getEvent;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

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

    @Override
    public Employee updateEmployeeState(Long employeeId, EmployeeEvent event) {

        Employee employee = repo.getById(employeeId);
        StateMachine<EmployeeState, EmployeeEvent> stateMachine = build(employee);

        stateMachine.sendEvent(getEvent(event)).subscribe();
        System.out.println("CurrentState "+ stateMachine.getState().getIds());

        setEmployeeState(employee, stateMachine);
        return repo.save(employee);
    }

    private StateMachine<EmployeeState, EmployeeEvent> build(Employee employee){
        StateMachine<EmployeeState, EmployeeEvent> sm = factory.getStateMachine(Long.toString(employee.getId()));
        sm.stopReactively().subscribe();

        sm.getStateMachineAccessor()
                .doWithAllRegions(sma -> sma.resetStateMachineReactively(new DefaultStateMachineContext<>(employee.getState(), null, null, null)).subscribe());

        sm.startReactively().subscribe();

        return sm;
    }

    private void setEmployeeState(Employee employee, StateMachine<EmployeeState, EmployeeEvent> stateMachine) {
        if(stateMachine.getState().getIds().contains(SECURITY_CHECK_STARTED))
            employee.setState(SECURITY_CHECK_STARTED);

        if(stateMachine.getState().getIds().contains(WORK_PERMIT_CHECK_STARTED))
            employee.setState(WORK_PERMIT_CHECK_STARTED);

        if(stateMachine.getState().getIds().contains(SECURITY_CHECK_FINISHED))
            employee.setState(SECURITY_CHECK_FINISHED);

        if(stateMachine.getState().getIds().contains(WORK_PERMIT_CHECK_FINISHED))
            employee.setState(WORK_PERMIT_CHECK_FINISHED);

        if(stateMachine.getState().getIds().containsAll(Arrays.asList(IN_CHECK, SECURITY_CHECK_FINISHED, WORK_PERMIT_CHECK_FINISHED)))
            employee.setState(APPROVED);

        if(stateMachine.getState().getId().equals(ACTIVE))
            employee.setState(ACTIVE);
    }
}
