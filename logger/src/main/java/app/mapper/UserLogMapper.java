package app.mapper;

import app.dto.UserLogMessage;
import app.model.UserLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserLogMapper {
    @Mapping(target = "action", source = "message.type")
    @Mapping(target = "userId", source = "message.user.id")
    @Mapping(target = "name", source = "message.user.name")
    @Mapping(target = "login", source = "message.user.login")
    @Mapping(target = "password", source = "message.user.password")
    UserLog destinationToSource(UserLogMessage message);
}