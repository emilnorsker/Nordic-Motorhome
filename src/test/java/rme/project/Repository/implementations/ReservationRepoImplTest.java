
package rme.project.Repository.implementations;


import org.junit.jupiter.api.Test;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationRepoImplTest {

    @Test
    void create() {
        //assign
        ReservationRepoImpl repo = new ReservationRepoImpl();

        //Doesnt use reservation ID since .create method sends empty to DB. DB auto increments therefore we use getLastID() instead.
        Reservation expected = new Reservation(666,"Narnia",123,LocalDate.parse("2020-05-30"),LocalDate.parse("2020-05-29"),1,1);
        Reservation actual;

        //act
        repo.create(expected);
        int lastId = repo.getLastInsertId();
        actual = repo.read(lastId);

        //assert
        assertEquals(lastId, actual.getReservation_id());
        assertEquals(expected.getLocation(), actual.getLocation());
        assertEquals(expected.getStartDate(), actual.getStartDate());
        assertEquals(expected.getNumberOfDays(), actual.getNumberOfDays());
        assertEquals(expected.getContact_id(), actual.getContact_id());

        repo.delete(lastId); //Cleanup
    }

    @Test
    void findAllAvailableMotorhomes() {
        System.out.println("finding all available motorhomes");
        //assign
        MotorhomeRepoImpl mh_repo = new MotorhomeRepoImpl();
        ReservationRepoImpl re_repo = new ReservationRepoImpl();

        List<Motorhome> available_mh_list;

        LocalDate now = LocalDate.now();
        LocalDate day = LocalDate.now().plusDays(1);

        Motorhome motorhome_available = mh_repo.readAll().get(0);
        System.out.println("available mh id = "+motorhome_available.getMotorhome_id());
        Motorhome motorhome_not_available = new Motorhome(1111, "brand", "model", "license", 2, "2p");
        Reservation r = new Reservation(2222, "location", 5d, now.minusDays(1), day.plusDays(1), motorhome_not_available.getMotorhome_id(), 1);


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