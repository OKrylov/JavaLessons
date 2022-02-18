package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudService<T> implements CrudService<T> {

    private final Map<Long, T> storage = new HashMap<>();
    private long currentId = 0L;

    @Override
    public T create(T instance) {
        Long id = generateNextId();
        setId(instance, id);
        storage.put(id, instance);
        return instance;
    }

    @Override
    public T find(Long id) {
        return storage.get(id);
    }

    @Override
    public T update(T instance) {
        Long id = getId(instance);
        if (!storage.containsKey(id)) {
            throw new IllegalArgumentException("Student with specified id does not exist: " + id);
        }
        storage.put(id, instance);
        return instance;
    }

    @Override
    public T delete(Long id) {
        return storage.remove(id);
    }

    private Long generateNextId() {
        return ++currentId;
    }

    protected abstract Long getId(T instance);

    protected abstract void setId(T instance, Long id);
}
