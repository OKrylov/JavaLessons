package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacultyService extends AbstractCrudService<Faculty> {

    @PostConstruct
    public void init() {
        create(new Faculty("Gryffindor", "Red"));
        create(new Faculty("Slytherin", "Green"));
        create(new Faculty("Hufflepuff", "Red"));
        create(new Faculty("Ravenclaw", "Yellow"));
    }

    @Override
    protected Long getId(Faculty faculty) {
        return faculty.getId();
    }

    @Override
    protected void setId(Faculty faculty, Long id) {
        faculty.setId(id);
    }

    public Set<Faculty> filterByColor(String color) {
        return storage.values().stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toSet());
    }
}
