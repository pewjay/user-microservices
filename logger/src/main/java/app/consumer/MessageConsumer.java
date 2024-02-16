package app.consumer;

import app.dto.UserLogMessage;
import app.mapper.UserLogMapper;
import app.model.UserLog;
import app.repository.UserLogRepository;
import app.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private final LogService logService;
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(UserLogMessage message) {
       logService.writeLog(message);
    }

}