package edu.prao.workmotion.config;

import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.Arrays;
import java.util.UUID;

import static edu.prao.workmotion.entity.EmployeeState.*;
import static edu.prao.workmotion.entity.EmployeeEvent.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StateMachineConfigTest {
     @Autowired
    StateMachineFactory<EmployeeState, EmployeeEvent> factory;
    StateMachine<EmployeeState, EmployeeEvent> stateMachine;

    @BeforeEach()
    public void setUp() {
        stateMachine = factory.getStateMachine(UUID.randomUUID());
        stateMachine.start();
    }


    @Test
    public void whenForkStateEntered_thenMultipleSubStatesEntered() {
        boolean success = stateMachine.sendEvent(TO_IN_CHECK);

        assertTrue(success);
        assertTrue(Arrays.asList(IN_CHECK, WORK_PERMIT_CHECK_STARTED, SECURITY_CHECK_STARTED).containsAll(stateMachine.getState().getIds()));
    }

    @Test
    void testSequence1() {

        System.out.println("1 "+stateMachine.getState().toString());

        stateMachine.sendEvent(TO_IN_CHECK);
        System.out.println("2 "+stateMachine.getState().toString());

        stateMachine.sendEvent(TO_SECURITY_CHECK_FINISHED);
        System.out.println("3 "+stateMachine.getState().toString());

        stateMachine.sendEvent(TO_WORK_PERMIT_CHECK_FINISHED);
        System.out.println("4 "+stateMachine.getState().toString());

        stateMachine.sendEvent(TO_ACTIVE);
        System.out.println("5 "+stateMachine.getState().toString());
    }
}
