/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;
import rme.project.Models.Motorhome;

import java.util.List;
public interface CRUD <T>
{
    //TODO Vi skal lige gå det her igennem med interfaces, jeg forstår ikke helt hvad det er vi vil

        boolean create(T object);

        public T read(int id);

        public List<T> readAll();

        boolean update(Motorhome motorhome);

        boolean delete(int id);
        //TODO Vi skal lige kigge på det her sammen, er ikke sikker på hvad parametre de skal tage

}
