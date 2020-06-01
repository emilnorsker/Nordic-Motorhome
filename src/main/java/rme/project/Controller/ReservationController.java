package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import rme.project.Models.Contact;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.ContactRepoImpl;
import rme.project.Repository.implementations.MotorhomeRepoImpl;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IContactRepo;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

/**
 * @author Mikkel Åxman
 */
@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationRepo reservationRepo = new ReservationRepoImpl();
    private final IMotorhomeRepo motorhomeRepo = new MotorhomeRepoImpl();
    private final IContactRepo contactRepo = new ContactRepoImpl();

    @GetMapping()
    public String reservations(Model model) {
        model.addAttribute("reservations", reservationRepo.readAll());
        return "reservations/reservations";
    }

    @GetMapping("/create")
    public String showCreatePage() {
        return "redirect:booking/";
    }

    @PostMapping("/create")
    public String create() {
        return "redirect:booking/";
    }

    @GetMapping("/update")
    public String update(@RequestParam Map<String, String> params) throws SQLException {

        //###################_ contact update _##############################\\
        Contact contact = contactRepo.read(Integer.parseInt(params.get("contact_id")));
        contact.setFirstName(params.get("firstName"));
        System.out.println(params.get("firstName"));
        contact.setLastName(params.get("lastName"));
        contact.setEmail(params.get("email"));
        contact.setPhone(params.get("phone"));
        contactRepo.update(contact);

        Reservation reservation = reservationRepo.read((Integer.parseInt( params.get("reservation_id"))));
        reservation.setStartDate(LocalDate.parse(params.get("startDate")));
        reservation.setEndDate(LocalDate.parse(params.get("endDate")));
        reservation.setLocation(params.get("location"));
        reservation.setKmFromOffice(Double.parseDouble(params.get("kmFromOffice")));

        reservationRepo.update(reservation);

        return "redirect:/reservations";
    }


    @GetMapping("/delete/")
    public String delete(@RequestParam(value = "id", required = false) String id) {
        System.out.println(id);
        reservationRepo.delete(Integer.parseInt(id));
        return "redirect:/reservations";
    }

    @GetMapping("/getMotorhome/{id}")
    public String getMotorhome(@PathVariable("id") int id) {
        motorhomeRepo.read(id);
        return "redirect:/reservations";
    }

}
