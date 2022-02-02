package edu.prao.kafkaudemy;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "iotKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<Long, Object> message){
        log.info("Message: "+message.topic());
        log.info("MessageKey: "+message.key());
        log.info("MessageValue: "+message.value());
    }
}
