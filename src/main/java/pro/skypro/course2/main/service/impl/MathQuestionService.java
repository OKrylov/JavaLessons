package pro.skypro.course2.main.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.repository.impl.QuestionRepository;
import pro.skypro.course2.main.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service("mathService")
public class MathQuestionService implements QuestionService {

    private final QuestionRepository mathQuestionRepository;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public boolean remove(String question, String answer) {
        return mathQuestionRepository.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(mathQuestionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = List.copyOf(mathQuestionRepository.getAll());
        return questions.get(random.nextInt(questions.size()));
    }

    @Override
    public int getSize() {
        return mathQuestionRepository.getAll().size();
    }
}
