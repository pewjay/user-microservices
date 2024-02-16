package app.mapper;

import app.dto.UserRequest;
import app.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequest sourceToDestination(User user);
    User destinationToSource(UserRequest request);
}
