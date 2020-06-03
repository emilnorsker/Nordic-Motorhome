package rme.project.Repository.interfaces;

import java.util.List;

/**
 * @Author Emil Norsker
 * @param <T>
 */
public interface CRUD<T> {

    /**
     * @Author Emil Norsker
     * @param item is a generic object and will be assigned by the class implementing this interface.
     */
    void create(T item);

    /**
     *
     * @param id int
     * @return T is a generic object and will be assigned by the class implementing this interface.
     */
    T read(int id);

    /**
     * @Author Emil Norsker
     * @return
     */
    List<T> readAll();

    /**
     * @Author Emil Norsker
     */
    void update(T item);

    /**
     * @Author Emil Norsker
     * @param id
     */
    void delete(int id);

}
