package pro.skypro.course2.main.service;

import pro.skypro.course2.main.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
