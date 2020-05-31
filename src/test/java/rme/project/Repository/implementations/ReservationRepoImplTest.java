
package rme.project.Repository.implementations;


import org.junit.jupiter.api.Test;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationRepoImplTest {

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
        Contact contact = new Contact(1111, "firstName", "lastName", "email", "phone");
        Reservation r = new Reservation(2222, "location", 5d, now.minusDays(1), day.plusDays(1), motorhome_not_available.getMotorhome_id(),contact.getContact_id() );


        //act
        re_repo.delete(r.getReservation_id());
        mh_repo.delete(motorhome_not_available.getMotorhome_id());
        new ContactRepoImpl().delete(contact.getContact_id());

        mh_repo.create(motorhome_not_available);
        new ContactRepoImpl().create(contact);
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
        new ContactRepoImpl().delete(contact.getContact_id());
        System.out.println("end");
    }
}