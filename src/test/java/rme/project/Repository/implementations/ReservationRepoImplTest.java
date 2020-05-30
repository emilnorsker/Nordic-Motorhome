
package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Accessory;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
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
        //assign
        Reservation expected = new Reservation(666, "Hej Vej 77", 2.22, LocalDate.parse("1990-05-22"), LocalDate.parse("2020-05-22"), 1);
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
    void findAvailableMotorhomes()
    {

    }

    @Test
    void findAllAvailableMotorhomes()
    {

        //assign
        MotorhomeRepoIMPL mh_repo = new MotorhomeRepoIMPL();
        ReservationRepoImpl re_repo = new ReservationRepoImpl();

        LocalDate now = LocalDate.now();
        LocalDate day = LocalDate.now().plusDays(1);

        Motorhome mh = new Motorhome(-1, "brand",  "model",  "license", 1f);
        Reservation r = new Reservation(-1, "location", 5d,  now, day, mh.getMotorhome_id());


        List<Motorhome> available_mh_list;


        //act
        available_mh_list = re_repo.findAllAvailableMotorhomes(r.getStartDate(), r.getEndDate());

        //assert

        // end

    }
}