package app.service;

import app.dto.UserLogMessage;
import app.dto.UserRequest;
import app.exception.UserNotFoundException;
import app.mapper.UserMapper;
import app.model.User;
import app.producer.MessageProducer;
import app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final MessageProducer messageProducer;

    public void addUser(UserRequest request) {
        User userEntity = userMapper.destinationToSource(request);


        userRepository.save(userEntity);

        UserLogMessage userLogMessageEntity = new UserLogMessage();
        userLogMessageEntity.setType("create");
        userLogMessageEntity.setUser(userEntity);

        messageProducer.sendMessage("my-topic", userLogMessageEntity);

        log.info("Message sent");
    }

    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }

    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
