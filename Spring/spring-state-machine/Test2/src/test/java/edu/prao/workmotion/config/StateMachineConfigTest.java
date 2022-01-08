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
import static edu.prao.workmotion.util.EmployeeUtil.getEvent;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StateMachineConfigTest {
     @Autowired
    StateMachineFactory<EmployeeState, EmployeeEvent> factory;
    StateMachine<EmployeeState, EmployeeEvent> stateMachine;

    @BeforeEach()
    public void setUp() {
        stateMachine = factory.getStateMachine(UUID.randomUUID());
        stateMachine.startReactively().subscribe();
    }


    @Test
    public void whenForkStateEntered_thenMultipleSubStatesEntered() {
        boolean success = stateMachine.sendEvent(getEvent(TO_IN_CHECK)).subscribe().isDisposed();

        assertTrue(success);
        assertTrue(Arrays.asList(IN_CHECK, WORK_PERMIT_CHECK_STARTED, SECURITY_CHECK_STARTED).containsAll(stateMachine.getState().getIds()));
    }


    /**
     * Accepted Flow: Sequence 1
     *  1) ADDED
     *  2) IN_CHECK
     *  3) Update substate of IN_CHECK state to SECURITY_CHECK_FINISHED
     *  4) Update substate of IN_CHECK state to WORK_PERMIT_CHECK_FINISHED
     *
     *     Check for auto-transitioned to APPROVED state
     *  5) Update state to ACTIVE
     */
    @Test
    void testSequence1() {

        System.out.println("1) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_IN_CHECK)).subscribe();
        System.out.println("2) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_SECURITY_CHECK_FINISHED)).subscribe();
        System.out.println("3) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_WORK_PERMIT_CHECK_FINISHED)).subscribe();
        System.out.println("4) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_ACTIVE)).subscribe();
        System.out.println("5) "+stateMachine.getState().getId());
    }

    /**
     * Accepted Flow: Sequence 2
     *  1) ADDED
     *  2) IN_CHECK
     *  3) Update substate of IN_CHECK state to WORK_PERMIT_CHECK_FINISHED
     *  4) Update substate of IN_CHECK state to SECURITY_CHECK_FINISHED
     *
     *     Check for auto-transitioned to APPROVED state
     *  5) Update state to ACTIVE
     */
    @Test
    void testSequence2() {

        System.out.println("1) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_IN_CHECK)).subscribe();
        System.out.println("2) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_WORK_PERMIT_CHECK_FINISHED)).subscribe();
        System.out.println("3) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_SECURITY_CHECK_FINISHED)).subscribe();
        System.out.println("4) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_ACTIVE)).subscribe();
        assertTrue(stateMachine.getState().getId().equals(ACTIVE));
        System.out.println("5) "+stateMachine.getState().getId());
    }

    /**
     * Accepted Flow: Sequence 2, to check random events effect - NA, all good
     */
    @Test
    void testSequence3() {

        System.out.println("1) "+stateMachine.getState().getId());

        stateMachine.sendEvent(getEvent(TO_IN_CHECK)).subscribe();
        System.out.println("2) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_WORK_PERMIT_CHECK_FINISHED)).subscribe();
        System.out.println("3) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_IN_CHECK)).subscribe();
        System.out.println("4) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_WORK_PERMIT_CHECK_STARTED)).subscribe();
        System.out.println("5) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_SECURITY_CHECK_FINISHED)).subscribe();
        System.out.println("6) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_WORK_PERMIT_CHECK_STARTED)).subscribe();
        System.out.println("7) "+stateMachine.getState().getIds());

        stateMachine.sendEvent(getEvent(TO_ACTIVE)).subscribe();
        System.out.println("8) "+stateMachine.getState().getIds());

    }
}
