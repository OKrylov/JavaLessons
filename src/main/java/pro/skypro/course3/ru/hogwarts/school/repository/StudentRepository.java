package pro.skypro.course3.ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.skypro.course3.ru.hogwarts.school.model.Student;

import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByAge(Integer age);

    Set<Student> findByAgeBetween(Integer minAge, Integer maxAge);
}
