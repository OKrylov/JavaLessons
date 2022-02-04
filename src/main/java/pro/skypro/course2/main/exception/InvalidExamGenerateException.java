package pro.skypro.course2.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExamGenerateException extends IllegalArgumentException {

    public InvalidExamGenerateException(int amount, int currentSize) {
        super(String.format("Failed to generate %d questions, the current size is %d", amount, currentSize));
    }

    public InvalidExamGenerateException(String s) {
        super(s);
    }
}
