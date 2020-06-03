
package rme.project.Repository.interfaces;

import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Emil Norsker
 */
public interface IReservationRepo extends CRUD<Reservation> {


    /**
     * @Author Emil Norsker
     * @param start
     * @param end
     * @return
     */
    List<Motorhome> findAllAvailableMotorhomes(LocalDate start, LocalDate end);

    /**
     * @Author Mikkel Åxman
     * @return
     */
    int getLastInsertId();
}
