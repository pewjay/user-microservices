package app.exception;

public class UserNotFoundException extends RuntimeException {
    private final long id;

    public UserNotFoundException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "User with ID " + id + " not found";
    }
}
