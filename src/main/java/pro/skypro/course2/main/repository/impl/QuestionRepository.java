package pro.skypro.course2.main.repository.impl;

import pro.skypro.course2.main.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
