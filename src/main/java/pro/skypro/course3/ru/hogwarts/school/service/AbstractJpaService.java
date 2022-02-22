package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractJpaService<T, JR extends JpaRepository<T, Long>> implements CrudService<T> {

    protected final JR repository;

    protected AbstractJpaService(JR repository) {
        this.repository = repository;
    }

    @Override
    public T create(T instance) {
        return repository.save(instance);
    }

    @Override
    public T find(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T update(T instance) {
        Long id = getId(instance);
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Student with specified id does not exist: " + id);
        }
        return repository.save(instance);
    }

    @Override
    public T delete(Long id) {
        T deletedEntity = repository.getById(id);
        repository.deleteById(id);
        return deletedEntity;
    }

    protected abstract Long getId(T instance);
}
