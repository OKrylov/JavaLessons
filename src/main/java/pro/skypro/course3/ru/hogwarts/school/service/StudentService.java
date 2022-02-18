package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.repository.StudentRepository;

import javax.annotation.PostConstruct;

@Service
public class StudentService extends AbstractJpaService<Student> {

    protected StudentService(StudentRepository repository) {
        super(repository);
    }

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

}
