package pro.skypro.course2.main.service.impl;

import org.springframework.stereotype.Service;
import pro.skypro.course2.main.exception.InvalidRequestException;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service("mathService")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        throw new InvalidRequestException();
    }

    @Override
    public boolean remove(String question, String answer) {
        throw new InvalidRequestException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new InvalidRequestException();
    }

    @Override
    public Question getRandomQuestion() {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int mathSign = random.nextInt(4);

        switch (mathSign) {
            case 0:
                return new Question(num1 + " + " + num2, String.valueOf(num1 + num2));
            case 1:
                return new Question(num1 + " - " + num2, String.valueOf(num1 - num2));
            case 2:
                return new Question(num1 + " * " + num2, String.valueOf(num1 * num2));
            case 3:
                return new Question(num1 + " / " + num2, String.valueOf(num1 / num2));
            default:
                throw new IllegalStateException("Invalid sign");
        }
    }

    @Override
    public int getSize() {
        throw new InvalidRequestException();
    }
}
