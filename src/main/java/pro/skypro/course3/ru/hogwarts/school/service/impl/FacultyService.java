package pro.skypro.course3.ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;
import pro.skypro.course3.ru.hogwarts.school.repository.FacultyRepository;
import pro.skypro.course3.ru.hogwarts.school.service.AbstractJpaService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class FacultyService extends AbstractJpaService<Faculty, FacultyRepository> {

    protected FacultyService(FacultyRepository repository) {
        super(repository);
    }

    @Override
    protected Long getId(Faculty faculty) {
        return faculty.getId();
    }

    public Set<Faculty> findByColor(String color) {
        return repository.findByColor(color);
    }

    public Set<Faculty> findByColorOrNameIgnoreCase(String color, String name) {
        return repository.findByColorOrNameIgnoreCase(color, name);
    }
}
