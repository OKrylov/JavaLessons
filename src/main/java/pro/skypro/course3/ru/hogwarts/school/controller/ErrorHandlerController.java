package pro.skypro.course3.ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorHandlerController {

    private static class ErrorResponse {
        public boolean isSuccessful = false;
        public String description;

        static ErrorResponse create(String description) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.description = description;
            return errorResponse;
        }
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> commonHandler(ResponseStatusException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(ErrorResponse.create(exception.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> badRequestHandler(RuntimeException exception) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.create(exception.getMessage()));
    }

}
