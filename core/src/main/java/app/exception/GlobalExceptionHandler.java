package app.exception;

import app.dto.ErrorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorInfo processException(Exception e) {
        log.error("Unexpected error", e);
        return new ErrorInfo(e.getMessage());
    }
}
