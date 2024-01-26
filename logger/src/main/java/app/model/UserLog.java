package app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userLogs")
public class UserLog {
    @Id
    private String id;

    private String action;
    private Long userId;
    private String name;
    private String login;
    private String password;
}
