package pro.skypro.course3.ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.skypro.course3.ru.hogwarts.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
