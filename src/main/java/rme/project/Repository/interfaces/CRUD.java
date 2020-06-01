/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;

import java.util.List;

public interface CRUD<T> {


    void create(T item);

    T read(int id);

    List<T> readAll();

    void update(T item);

    void delete(int id);

}
