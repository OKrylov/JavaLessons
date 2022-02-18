package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import pro.skypro.course3.ru.hogwarts.school.model.Faculty;
import pro.skypro.course3.ru.hogwarts.school.repository.FacultyRepository;

import javax.annotation.PostConstruct;

@Service
public class FacultyService extends AbstractJpaService<Faculty> {

    protected FacultyService(FacultyRepository repository) {
        super(repository);
    }

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

}
