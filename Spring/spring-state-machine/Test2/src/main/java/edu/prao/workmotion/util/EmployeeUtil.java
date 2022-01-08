package edu.prao.workmotion.util;

import edu.prao.workmotion.entity.EmployeeEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Mono;

public class EmployeeUtil {
    public static Mono<Message<EmployeeEvent>> getEvent(EmployeeEvent event){
        return Mono.just(MessageBuilder
                .withPayload(event).build());
    }
}
