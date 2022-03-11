package pro.skypro.course3.ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.skypro.course3.ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByAge(Integer age);

    Set<Student> findByAgeBetween(Integer minAge, Integer maxAge);


    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    int getStudentsCount();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    int getStudentAverageAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT ?1", nativeQuery = true)
    List<Student> getLastStudents(int count);

}
