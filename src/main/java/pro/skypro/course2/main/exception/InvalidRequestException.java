package pro.skypro.course2.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidRequestException extends IllegalArgumentException {

    public InvalidRequestException() {
        super("The required method is not allowed");
    }
}
