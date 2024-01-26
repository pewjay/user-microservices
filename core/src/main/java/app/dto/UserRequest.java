package app.dto;

import jakarta.validation.constraints.NotNull;

public record UserRequest(@NotNull String name, @NotNull String login, @NotNull String password) {
}
