package app.repository;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
//    Optional<User> findById(long id);
    List<User> findByName(String name);
}
