package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoImpl;
import rme.project.Repository.implementations.ContactRepoImpl;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IContactRepo;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController
{

    private IMotorhomeRepo motorhomesRepo = new MotorhomeRepoImpl();
    private IReservationRepo reservationRepo = new ReservationRepoImpl();
    private IContactRepo contactRepo = new ContactRepoImpl();

    public int step = 0;
    Reservation reservation = new Reservation();
    List<Motorhome> motorhomes = null;


    @GetMapping(value = "") //todo step max/min
    public String ChooseDateAndModel(Model model, @RequestParam(value = "reset", required = false) String reset)
    {
        if (reset!= null && reset.equalsIgnoreCase("true"))
        {
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
/**
    @GetMapping("/create")
    public String showCreatePage(){
        return "booking/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Contact contact, Reservation reservation){
        contactRepo.create(contact);

        reservation.setContact_id(contactRepo.getLastInsertId());
        reservationRepo.create(reservation);
        return "redirect:/reservations";
    }
**/
    @GetMapping("/create")
    public String create(@RequestParam("motorhome_id") String motorhome_id, @RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("email") String email, @RequestParam("phone") String number, @RequestParam("location") String location, @RequestParam("kmFromOffice") Float kmFromOffice) {
        Contact contact = new Contact();
        contact.setFirstName(fName);
        contact.setLastName(lName);
        contact.setEmail(email);
        contact.setPhone(number);
        new ContactRepoImpl().create(contact); // todo !!! not proper way to do it... !!! plz change

        reservation.setContact_id(contactRepo.getLastInsertId());
        reservation.setMotorhome_id(Integer.parseInt(motorhome_id));
        reservation.setKmFromOffice(kmFromOffice);
        reservation.setLocation(location);

        System.out.println("create");
        reservationRepo.create(reservation);
        System.out.println("done");


        return "redirect:/reservations";
    }

    public List<Motorhome> getModels()
    {
        List<String> models = new ArrayList<String>();
        List<Motorhome> typeModels = new ArrayList<Motorhome>();
        for (Motorhome M:motorhomesRepo.readAll())
        {
            if (!models.contains(M.getModel()))
            {
                models.add(M.getModel());
                typeModels.add(M);
            }
        }
        return typeModels;
    }
    // ##########################################################################################################
}
