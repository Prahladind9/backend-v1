package edu.prao.workmotion.service;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EmployeeStateChangeInterceptor extends StateMachineInterceptorAdapter<EmployeeState, EmployeeEvent> {

    private final EmployeeRepo employeeRepo;

    @Override
    public void preStateChange(State<EmployeeState, EmployeeEvent> state, Message<EmployeeEvent> message,
                               Transition<EmployeeState, EmployeeEvent> transition, StateMachine<EmployeeState, EmployeeEvent> stateMachine) {

        Optional.ofNullable(message).ifPresent(msg -> {
            Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault(EmployeeServiceImpl.EMPLOYEE_ID_HEADER, -1L)))
                    .ifPresent(employeeId -> {
                        Employee employee = employeeRepo.getById(employeeId);
                        employee.setState(state.getId());
                        employeeRepo.save(employee);
                    });
        });
    }

}
