package pro.skypro.course2.main.repository.impl;

import org.springframework.stereotype.Repository;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Год запуска Java?", "1995"));
        add(new Question("Изменяемы ли строки? Да/Нет", "Нет"));
        add(new Question("Является ли Map коллекцией? Да/Нет", "Нет"));
        add(new Question("Сколько байт занимает int?", "4"));
        add(new Question("Актуальная версия Java? Под неё написан наш курс.", "11"));
        add(new Question("Как называется библиотека для юнит-тестов? Ответ маленькими буквами.", "junit"));
        add(new Question("Класс, который позволяет изменять строки.", "StringBuilder"));
        add(new Question("Через какой метод нужно сравнивать объекты?", "equals"));
        add(new Question("Означает ли совпадающий хэшкод, что объекты обязательно равны? Да/Нет", "Нет"));
    }

    @Override
    public boolean add(Question question) {
        return questions.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}