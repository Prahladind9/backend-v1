package edu.prao.workmotion.config;

import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.entity.EmployeeState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.region.RegionExecutionPolicy;
import org.springframework.statemachine.state.State;

import static edu.prao.workmotion.entity.EmployeeState.*;
import static edu.prao.workmotion.entity.EmployeeEvent.*;

@Slf4j
@EnableStateMachineFactory
@Configuration
public class StateMachineConfig extends StateMachineConfigurerAdapter<EmployeeState, EmployeeEvent> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<EmployeeState, EmployeeEvent> config) throws Exception {
        StateMachineListenerAdapter<EmployeeState, EmployeeEvent> adapter = new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<EmployeeState, EmployeeEvent> from, State<EmployeeState, EmployeeEvent> to) {
                System.out.println(String.format("stateChanged(from: %s, to: %s)", from, to));
            }
        };

        config.withConfiguration()
                .listener(adapter);
    }

    @Override
    public void configure(StateMachineStateConfigurer<EmployeeState, EmployeeEvent> states) throws Exception {
        states.withStates()
                .initial(ADDED)
                .fork(FORK)
                .state(IN_CHECK)
                .join(JOIN)
                .state(APPROVED)
                .end(ACTIVE)
                .and()
                .withStates()
                    .parent(IN_CHECK)
                    .initial(SECURITY_CHECK_STARTED)
                    .end(SECURITY_CHECK_FINISHED)
                .and()
                .withStates()
                    .parent(IN_CHECK)
                    .initial(WORK_PERMIT_CHECK_STARTED)
                    .end(WORK_PERMIT_CHECK_FINISHED)
        ;
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<EmployeeState, EmployeeEvent> transitions) throws Exception {
        transitions
                .withExternal()
                    .source(ADDED).target(FORK)
                    .event(TO_IN_CHECK)
                    .and()
                .withFork()
                    .source(FORK).target(IN_CHECK)
                    .and()
                .withExternal()
                    .source(SECURITY_CHECK_STARTED)
                    .target(SECURITY_CHECK_FINISHED)
                    .event(TO_SECURITY_CHECK_FINISHED)
                    .and()
                .withExternal()
                    .source(WORK_PERMIT_CHECK_STARTED)
                    .target(WORK_PERMIT_CHECK_FINISHED)
                    .event(TO_WORK_PERMIT_CHECK_FINISHED)
                    .and()
                .withJoin()
                    .source(IN_CHECK).target(JOIN)
                    .and()
                .withExternal()
                    .source(JOIN)
                    .target(APPROVED)
                    .and()
                .withExternal()
                    .source(APPROVED)
                    .target(ACTIVE)
                    .event(TO_ACTIVE)
                ;

    }
}