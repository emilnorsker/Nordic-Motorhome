
package rme.project.Repository.implementations;


import org.junit.jupiter.api.Test;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //assertEquals(expected.getLocation(), actual.getLocation());
        assertEquals(expected.getStartDate(), actual.getStartDate());
        assertEquals(expected.getNumberOfDays(), actual.getNumberOfDays());

    }

    @Test
    void findAvailableMotorhomes()
    {

    }

    @Test
    void findAllAvailableMotorhomes() {
        System.out.println("finding all available motorhomes");
        //assign
        MotorhomeRepoIMPL mh_repo = new MotorhomeRepoIMPL();
        ReservationRepoImpl re_repo = new ReservationRepoImpl();

        List<Motorhome> available_mh_list;

        LocalDate now = LocalDate.now();
        LocalDate day = LocalDate.now().plusDays(1);

        Motorhome motorhome_available = mh_repo.readAll().get(0);
        System.out.println("available mh id = "+motorhome_available.getMotorhome_id());
        Motorhome motorhome_not_available = new Motorhome(1111, "brand", "model", "license", 1f);
        Reservation r = new Reservation(2222, "location", 5d, now.minusDays(1), day.plusDays(1), motorhome_not_available.getMotorhome_id());


        //act
        re_repo.delete(r.getReservation_id());
        mh_repo.delete(motorhome_not_available.getMotorhome_id());

        mh_repo.create(motorhome_not_available);
        re_repo.create(r);


        available_mh_list = re_repo.findAllAvailableMotorhomes(r.getStartDate(), r.getEndDate());




        System.out.println("motorhome in list");
        for (Motorhome M : available_mh_list) {
            System.out.println(M.getMotorhome_id());

        }

        //assert

        if (available_mh_list.contains(motorhome_not_available))
        {
            assertEquals("motorhome should not", "exist");
        }

        // end : delete artifacts
        re_repo.delete(r.getReservation_id());
        mh_repo.delete(motorhome_not_available.getMotorhome_id());
        System.out.println("end");
    }
}