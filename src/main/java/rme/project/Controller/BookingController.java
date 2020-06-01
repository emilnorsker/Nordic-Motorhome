package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.ContactRepoImpl;
import rme.project.Repository.implementations.MotorhomeRepoImpl;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final IMotorhomeRepo motorhomesRepo = new MotorhomeRepoImpl();
    private final IReservationRepo reservationRepo = new ReservationRepoImpl();

    public int step = 0;
    Reservation reservation = new Reservation();
    List<Motorhome> motorhomes = null;


    @GetMapping(value = "") //todo step max/min
    public String ChooseDateAndModel(Model model, @RequestParam(value = "reset", required = false) String reset) {
        if (reset != null && reset.equalsIgnoreCase("true")) {
            reservation = new Reservation();
        }

        model.addAttribute("reservation", reservation);
        model.addAttribute("motorhomes", motorhomes);
        return "booking/booking";
    }

    @GetMapping(value = "/dates")
    public String ChooseMotorhome(Model model, @RequestParam("start") String start, @RequestParam("end") String end) {
        reservation.setStartDate(LocalDate.parse(start));
        reservation.setEndDate(LocalDate.parse(end));

        // todo calculate number of days

        motorhomes = reservationRepo.findAllAvailableMotorhomes(reservation.getStartDate(), reservation.getEndDate());
        model.addAttribute("motorhomes", motorhomes);

        return "redirect:";
    }

    @GetMapping("/create")
    public String create(@RequestParam("motorhome_id") String motorhome_id, @RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("email") String email, @RequestParam("phone") String number, @RequestParam("location") String location) {
        Contact contact = new Contact();
        contact.setFirstName(fName);
        contact.setLastName(lName);
        contact.setEmail(email);
        contact.setPhone(number);
        new ContactRepoImpl().create(contact); //

        reservation.setContact_id(contact.getContact_id());
        reservation.setMotorhome_id(Integer.parseInt(motorhome_id));
        reservation.setKmFromOffice(10d); // todo better calculation
        reservation.setLocation(location);

        reservationRepo.create(reservation);


        return "redirect:/reservations";
    }

    public List<Motorhome> getModels() {
        List<String> models = new ArrayList<String>();
        List<Motorhome> typeModels = new ArrayList<Motorhome>();
        for (Motorhome M : motorhomesRepo.readAll()) {
            if (!models.contains(M.getModel())) {
                models.add(M.getModel());
                typeModels.add(M);
            }
        }
        return typeModels;
    }
    // ##########################################################################################################
}
