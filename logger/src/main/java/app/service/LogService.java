package app.service;

import app.dto.UserLogMessage;
import app.mapper.UserLogMapper;
import app.model.UserLog;
import app.repository.UserLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogService {
    private final UserLogRepository userLogRepository;
    private final UserLogMapper userLogMapper;

    public void writeLog(UserLogMessage message) {
        log.info("Received message: " + message.getUser());
        UserLog userLogEntity = userLogMapper.destinationToSource(message);
        userLogRepository.save(userLogEntity);
    }
}
