package edu.prao.kafkaudemy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}")
    public void iotListenTopic(@Payload List<ModifiableRandomEvent> iotData) throws JsonProcessingException {
        logConsumedData(iotData);
        log.info("message:{}",iotData);
//        ObjectMapper mapper = new ObjectMapper();
//        ModifiableRandomEvent event = mapper.readValue(message.value(), ModifiableRandomEvent.class);
//        log.info("Message: "+message.topic());
//        log.info("MessageKey: "+message.key());
//        log.info("MessageValue: "+message.value());
    }

    private void logConsumedData(List<ModifiableRandomEvent> iotData){
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String	consumedData = ow.writeValueAsString(iotData);
            log.info(String.format("$$ -> Consumed message --> %s", consumedData));
        } catch (JsonProcessingException e) {
            log.error("Error while logging consumed data");
        }
    }
}
