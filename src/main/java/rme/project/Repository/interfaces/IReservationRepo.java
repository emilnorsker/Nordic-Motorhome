/**
 * @author Emil
 */
package rme.project.Repository.interfaces;

import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationRepo extends CRUD<Reservation> {
    List<Motorhome> findAvailableMotorhomes(LocalDate start, LocalDate end, String[] models);

    List<Motorhome> findAllAvailableMotorhomes(LocalDate start, LocalDate end);

    int getLastInsertId();
}
