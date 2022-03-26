package pro.skypro.course3.ru.hogwarts.school.service.impl;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.repository.StudentRepository;
import pro.skypro.course3.ru.hogwarts.school.service.AbstractJpaService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        log.info("Was invoked method to find by age: {}", age);
        return repository.findByAge(age);
    }

    public Set<Student> findByAgeBetween(Integer minAge, Integer maxAge) {
        log.info("Was invoked method to find by between {} and {}", minAge, maxAge);
        return repository.findByAgeBetween(minAge, maxAge);
    }

    public int getStudentsCount() {
        log.info("Was invoked method to get students count");
        return repository.getStudentsCount();
    }

    public int getStudentAverageAge() {
        log.info("Was invoked method to find the average student age");
//        return repository.getStudentAverageAge();
        return (int) repository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    public List<Student> getLastStudents(int count) {
        log.info("Was invoked method to find last {} students", count);
        return repository.getLastStudents(count);
    }

    public List<String> getAllStudentNamesStartingWithA() {
        log.info("Was invoked method to find all students starting with A");
        return repository.findAll().stream()
//                .parallel()
//                .filter(it -> it.getName().startsWith("A"))
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(it -> it.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());


    }
}
