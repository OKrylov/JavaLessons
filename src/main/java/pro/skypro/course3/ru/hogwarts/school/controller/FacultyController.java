package pro.skypro.course3.ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;
import pro.skypro.course3.ru.hogwarts.school.service.FacultyService;

import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.find(id);
        if (faculty == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return faculty;
    }

    @GetMapping(params = {"color"})
    public Set<Faculty> findFacultiesByColor(@RequestParam(required = false) String color) {
        return facultyService.findByColor(color);
    }

    @GetMapping(params = {"name"})
    public Set<Faculty> findFacultiesByColorOrNameIgnoreCase(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name) {
        return facultyService.findByColorOrNameIgnoreCase(color, name);
    }

    @PostMapping
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        if (faculty.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must be empty!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.create(faculty));
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        if (faculty.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must be specified!");
        }

        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        Faculty deletedFaculty = facultyService.delete(id);
        if (deletedFaculty == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deletedFaculty);
        }
    }


}
