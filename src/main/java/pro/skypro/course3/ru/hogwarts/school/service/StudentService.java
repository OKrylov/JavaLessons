package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Student;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService extends AbstractCrudService<Student> {

    @PostConstruct
    public void init() {
        create(new Student("Oleg", 29));
        create(new Student("Harry", 32));
        create(new Student("Peter", 29));
    }

    @Override
    protected Long getId(Student student) {
        return student.getId();
    }

    @Override
    protected void setId(Student student, Long id) {
        student.setId(id);
    }

    public Set<Student> filterByAge(int age) {
        return storage.values().stream()
                .filter(it -> it.getAge() == age)
                .collect(Collectors.toSet());
    }
}
