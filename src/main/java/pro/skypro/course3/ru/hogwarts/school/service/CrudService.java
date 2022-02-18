package pro.skypro.course3.ru.hogwarts.school.service;

public interface CrudService<T> {

    T create(T instance);
    T find(Long id);
    T delete(Long id);
    T update(T instance);

}
