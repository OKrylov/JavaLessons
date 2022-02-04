package pro.skypro.course2.main.service.impl;

import org.springframework.stereotype.Service;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionStorage = new HashSet<>();
    private final Random random = new Random();

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionStorage.add(newQuestion);
    }

    @Override
    public boolean remove(String question, String answer) {
        return questionStorage.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questionStorage);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questionStorage).get(random.nextInt(questionStorage.size()));
    }

    @Override
    public int getSize() {
        return questionStorage.size();
    }
}
