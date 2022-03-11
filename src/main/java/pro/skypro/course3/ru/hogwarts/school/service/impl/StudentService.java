package pro.skypro.course3.ru.hogwarts.school.service.impl;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.repository.StudentRepository;
import pro.skypro.course3.ru.hogwarts.school.service.AbstractJpaService;

import java.util.List;
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

    public int getStudentsCount() {
        return repository.getStudentsCount();
    }

    public int getStudentAverageAge() {
        return repository.getStudentAverageAge();
    }

    public List<Student> getLastStudents(int count) {
        return repository.getLastStudents(count);
    }
}
