package pro.skypro.course3.ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.service.impl.StudentService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student student = studentService.find(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }

    @GetMapping(params = {"age"})
    public Set<Student> findStudentsByAge(@RequestParam(required = false) Integer age) {
        return studentService.findByAge(age);
    }

    @GetMapping(params = {"minAge", "maxAge"})
    public Set<Student> findByAgeBetween(
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        return studentService.findByAgeBetween(minAge, maxAge);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if (student.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must be empty!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must be specified!");
        }

        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student deletedStudent = studentService.delete(id);
        if (deletedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deletedStudent);
        }
    }

    @GetMapping("/count")
    public int getStudentsCount() {
        return studentService.getStudentsCount();
    }

    @GetMapping("/averageAge")
    public int getStudentAverageAge() {
        return studentService.getStudentAverageAge();
    }

    @GetMapping("/last/{count}")
    public List<Student> getLastStudents(@PathVariable int count) {
        return studentService.getLastStudents(count);
    }

    @GetMapping("/startWithA")
    public List<String> getAllStudentNamesStartingWithA() {
        return studentService.getAllStudentNamesStartingWithA();
    }


}
