package edu.prao.workmotion.model;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static edu.prao.workmotion.entity.EmployeeEvent.*;
import static edu.prao.workmotion.entity.EmployeeState.*;

@Component
public class EmployeeModelBuilder {

    private final String CHOOSE_NEXT_POSSIBLE_EVENT = "Choose nextPossibleEvent";
    private final String NOTHING_EMPLOYEE_REACHED_ACTIVE_STATE = "Nothing, Employee reached ACTIVE State";

    public EmployeeModel forAddEmployee(Employee employee) {

        employee.setSubState("NA");
        String targetState = IN_CHECK.name();
        List<String> nextPossibleEvent = Arrays.asList(TO_IN_CHECK.name());

        return EmployeeModel.builder()
                .employee(employee)
                .nextPossibleEvent(nextPossibleEvent)
                .nextActionToTake(CHOOSE_NEXT_POSSIBLE_EVENT)
                .targetState(targetState)
                .build();

    }

    public EmployeeModel forGetEmployeeDetails(Employee employee, StateMachine<EmployeeState, EmployeeEvent> stateMachine) {

        String targetState = null;
        String nextActionToTake = null;
        List<String> nextPossibleEvent = null;

        switch (employee.getState()) {
            case ADDED:
                employee.setSubState("NA");
                targetState = IN_CHECK.name();
                nextActionToTake = CHOOSE_NEXT_POSSIBLE_EVENT;
                nextPossibleEvent = Arrays.asList(TO_IN_CHECK.name());
                break;
            case APPROVED:
                employee.setSubState("NA");
                targetState = ACTIVE.name();
                nextActionToTake = CHOOSE_NEXT_POSSIBLE_EVENT;
                nextPossibleEvent = Arrays.asList(TO_ACTIVE.name());
                break;
            case ACTIVE:
                employee.setSubState("NA");
                targetState = "NA";
                nextActionToTake = NOTHING_EMPLOYEE_REACHED_ACTIVE_STATE;
                nextPossibleEvent = null;
                break;
            case IN_CHECK:
            case SECURITY_CHECK_STARTED:
            case SECURITY_CHECK_FINISHED:
            case WORK_PERMIT_CHECK_STARTED:
            case WORK_PERMIT_CHECK_FINISHED:

                nextActionToTake = CHOOSE_NEXT_POSSIBLE_EVENT;
                if (employee.getState().equals(SECURITY_CHECK_FINISHED)) {
                    nextPossibleEvent = Arrays.asList(TO_WORK_PERMIT_CHECK_FINISHED.name());
                } else if (employee.getState().equals(WORK_PERMIT_CHECK_FINISHED)) {
                    nextPossibleEvent = Arrays.asList(TO_SECURITY_CHECK_FINISHED.name());
                } else if (employee.getState().equals(IN_CHECK) ||
                        employee.getState().equals(SECURITY_CHECK_STARTED) ||
                        employee.getState().equals(WORK_PERMIT_CHECK_STARTED)) {
                    nextPossibleEvent = Arrays.asList(TO_SECURITY_CHECK_FINISHED.name(), TO_WORK_PERMIT_CHECK_FINISHED.name());
                }

                employee.setState(IN_CHECK);
                employee.setSubState(Arrays.toString(stateMachine.getState().getIds().toArray()).replace("IN_CHECK, ", ""));
                targetState = APPROVED.name();
                break;
            default:
                break;
        }

        return EmployeeModel.builder()
                .employee(employee)
                .targetState(targetState)
                .nextPossibleEvent(nextPossibleEvent)
                .nextActionToTake(nextActionToTake)
                .build();

    }
}
