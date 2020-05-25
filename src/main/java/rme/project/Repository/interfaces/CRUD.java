/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;
import rme.project.Models.Motorhome;

import java.util.List;
public interface CRUD <T>
{
    //TODO Vi skal lige gå det her igennem med interfaces, jeg forstår ikke helt hvad det er vi vil

        boolean create(T item);

        T read(int id);

        List<T> readAll();

        boolean update(T item);

        boolean delete(int id);

        //TODO Vi skal lige kigge på det her sammen, er ikke sikker på hvad parametre de skal tage

}
