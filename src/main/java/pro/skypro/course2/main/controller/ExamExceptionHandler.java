package pro.skypro.course2.main.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExamExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String argumentException(IllegalArgumentException exception) {
        return String.format("Error when process input parameters, cause: %s", exception.getMessage());
    }
}
