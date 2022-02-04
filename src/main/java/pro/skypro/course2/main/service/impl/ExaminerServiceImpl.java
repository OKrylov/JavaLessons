package pro.skypro.course2.main.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.skypro.course2.main.exception.InvalidExamGenerateException;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.ExaminerService;
import pro.skypro.course2.main.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Logger log = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final QuestionService javaService;
    private final QuestionService mathService;

    public ExaminerServiceImpl(
            @Qualifier("javaService") QuestionService javaService,
            @Qualifier("mathService") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> services = List.of(javaService, mathService);
        int size = services.stream().mapToInt(QuestionService::getSize).sum();
        if  (amount <= 0 || size < amount) {
            log.error("Amount must be positive and no more than " + size);
            throw new InvalidExamGenerateException(amount, size);
        }

        Random random = new Random();
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(services.get(random.nextInt(services.size())).getRandomQuestion());
        }

        log.info("The following random questions for amount {} have been found: {}", amount, questions);
        return questions;
    }
}
