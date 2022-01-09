package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import edu.prao.workmotion.model.EmployeeModel;
import edu.prao.workmotion.model.EmployeeModelBuilder;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static edu.prao.workmotion.entity.EmployeeState.*;
import static edu.prao.workmotion.util.EmployeeUtil.getEvent;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeModelBuilder employeeModelBuilder;
    private final EmployeeRepo employeeRepo;
    private final StateMachineFactory<EmployeeState, EmployeeEvent> factory;

    @Override
    public EmployeeModel addEmployee(Employee employee) {
        employee.setState(EmployeeState.ADDED);
        employee.setCreateAt(LocalDateTime.now());
        Employee employeeAdded = employeeRepo.save(employee);

        return employeeModelBuilder.forAddEmployee(employeeAdded);
    }

    @Override
    public EmployeeModel getEmployeeDetails(Long employeeId) {
        Employee employee = employeeRepo.getById(employeeId);
        final StateMachine<EmployeeState, EmployeeEvent> stateMachine = build(employee);
        return employeeModelBuilder.forGetEmployeeDetails(employee, stateMachine);
    }

    @Override
    public EmployeeModel updateEmployeeState(Long employeeId, EmployeeEvent event) {

        Employee employee = employeeRepo.getById(employeeId);
        final StateMachine<EmployeeState, EmployeeEvent> stateMachine = build(employee);

        if (isStateChanged(employee, event, stateMachine)) {
            stateMachine.sendEvent(getEvent(event)).subscribe();
            employee.setLastUpdatedState(employee.getState());
            employee.setLastUpdatedAt(LocalDateTime.now());
            employee.setState(getEmployeeState(employee, stateMachine));
            employee = employeeRepo.save(employee);
        }

        return employeeModelBuilder.forGetEmployeeDetails(employee, stateMachine);
    }

    private boolean isStateChanged(Employee employee, EmployeeEvent event, StateMachine<EmployeeState, EmployeeEvent> stateMachine) {
        final Map<String, String> currentNextStateMapping = new HashMap() {{
            put("ADDED", "IN_CHECK");
            put("IN_CHECK", "APPROVED");
            put("SECURITY_CHECK_STARTED", "SECURITY_CHECK_FINISHED");
            put("WORK_PERMIT_CHECK_STARTED", "WORK_PERMIT_CHECK_FINISHED");
            put("WORK_PERMIT_CHECK_FINISHED", "SECURITY_CHECK_FINISHED");
            put("SECURITY_CHECK_FINISHED", "WORK_PERMIT_CHECK_FINISHED");
            put("APPROVED", "ACTIVE");
        }};

        final String currentState = stateMachine.getState().getId().name();
        final String currentSavedState = employee.getState().name();
        final String requestedState = event.name().replace("TO_", "");
        final String nextState = currentNextStateMapping.get(currentState);
        final String nextSavedState = currentNextStateMapping.get(currentSavedState);

        if (currentState.equals(currentSavedState) && nextState != null && nextState.equals(requestedState)) {
            return true;
        } else if (nextSavedState != null && nextSavedState.equals(requestedState)) {
            return true;
        }else {
            return false;
        }

    }


    private EmployeeState getEmployeeState(Employee employee, StateMachine<EmployeeState, EmployeeEvent> stateMachine) {

        if (stateMachine.getState().getIds().containsAll(Arrays.asList(IN_CHECK, SECURITY_CHECK_FINISHED, WORK_PERMIT_CHECK_FINISHED)))
            return APPROVED;

        if (stateMachine.getState().getIds().containsAll(Arrays.asList(IN_CHECK, SECURITY_CHECK_FINISHED, WORK_PERMIT_CHECK_STARTED)))
            return SECURITY_CHECK_FINISHED;

        if (stateMachine.getState().getIds().containsAll(Arrays.asList(IN_CHECK, SECURITY_CHECK_STARTED, WORK_PERMIT_CHECK_FINISHED)))
            return WORK_PERMIT_CHECK_FINISHED;

        if (stateMachine.getState().getId().equals(ACTIVE))
            return ACTIVE;

        if (stateMachine.getState().getIds().contains(SECURITY_CHECK_STARTED))
            return SECURITY_CHECK_STARTED;

        if (stateMachine.getState().getIds().contains(WORK_PERMIT_CHECK_STARTED))
            return WORK_PERMIT_CHECK_STARTED;

        return employee.getState();
    }


    private StateMachine<EmployeeState, EmployeeEvent> build(Employee employee) {
        StateMachine<EmployeeState, EmployeeEvent> stateMachine = factory.getStateMachine(Long.toString(employee.getId()));
        stateMachine.stopReactively().subscribe();

        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(sma -> sma.resetStateMachineReactively(new DefaultStateMachineContext<>(employee.getState(), null, null, null)).subscribe());

        stateMachine.startReactively().subscribe();

        return stateMachine;
    }
}
