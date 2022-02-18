package pro.skypro.course3.ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
