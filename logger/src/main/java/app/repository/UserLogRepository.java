package app.repository;

import app.model.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserLogRepository extends MongoRepository<UserLog, String> {
}
