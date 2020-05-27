
package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Accessory;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Mikkel
 */
class ReservationRepoImplTest {
    @Test
    void create() {
        Reservation expected = new Reservation(666, "Hej Vej 77", 2.22, LocalDate.parse("1990-05-22"), LocalDate.parse("2020-05-22"), 0, 1);
        Reservation actual;

        ReservationRepoImpl repo = new ReservationRepoImpl();

        //act
        repo.create(expected);
        actual = repo.read(expected.getReservation_id());

        //assert
        assertEquals(expected.getReservation_id(), actual.getReservation_id());
        assertEquals(expected.getLocation(), actual.getLocation());
        assertEquals(expected.getStartDate(), actual.getStartDate());
        assertEquals(expected.getNumberOfDays(), actual.getNumberOfDays());

    }

    @Test
    void read() {
    }

    @Test
    void readAll() {

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}