package app.producer;

import app.dto.UserLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, UserLogMessage> kafkaTemplate;

    public void sendMessage(String topic, UserLogMessage userLogMessage) {
        kafkaTemplate.send(topic, userLogMessage);
    }
}
