package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.beans.beancontext.BeanContext;
import java.util.Set;

@Service
@DependsOn({"facultyService"})
public class StudentService extends AbstractJpaService<Student, StudentRepository> {

    protected StudentService(StudentRepository repository) {
        super(repository);
    }

    @Override
    protected Long getId(Student student) {
        return student.getId();
    }

    public Set<Student> findByAge(Integer age) {
        return repository.findByAge(age);
    }

    public Set<Student> findByAgeBetween(Integer minAge, Integer maxAge) {
        return repository.findByAgeBetween(minAge, maxAge);
    }
}
