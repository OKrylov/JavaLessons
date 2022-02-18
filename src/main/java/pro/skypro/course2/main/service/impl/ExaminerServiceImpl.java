package pro.skypro.course2.main.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.skypro.course2.main.exception.InvalidExamGenerateException;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.ExaminerService;
import pro.skypro.course2.main.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Logger log = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final List<QuestionService> services;
    private Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.services = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if  (amount <= 0) {
            log.error("Amount must be positive");
            throw new InvalidExamGenerateException("Failed to generate questions, amount should be more 0");
        }

        Random random = createRandom();
        Set<Question> questions = new LinkedHashSet<>();
        while (questions.size() < amount) {
            questions.add(services.get(random.nextInt(services.size())).getRandomQuestion());
        }

        log.info("The following random questions for amount {} have been found: {}", amount, questions);
        return questions;
    }

    private Random createRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
