package pro.skypro.course3.ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractJpaService<T, JR extends JpaRepository<T, Long>> implements CrudService<T> {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected final JR repository;

    protected AbstractJpaService(JR repository) {
        this.repository = repository;
    }

    @Override
    public T create(T instance) {
        log.info("Was invoked method to create the entity: {}", instance);
        return repository.save(instance);
    }

    @Override
    public T find(Long id) {
        log.info("Was invoked method to find by id {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public T update(T instance) {
        log.info("Was invoked method to update the entity {}", instance);
        Long id = getId(instance);
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Student with specified id does not exist: " + id);
        }
        return repository.save(instance);
    }

    @Override
    public T delete(Long id) {
        log.info("Was invoked method to delete by id {}", id);
        T deletedEntity = repository.getById(id);
        repository.deleteById(id);
        return deletedEntity;
    }

    protected abstract Long getId(T instance);
}
