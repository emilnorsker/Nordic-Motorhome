package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.BookingRepoImpl;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IBookingRepo;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController
{

    private IMotorhomeRepo motorhomesRepo = new MotorhomeRepoIMPL();
    private IReservationRepo reservationRepo = new ReservationRepoImpl();

    public int step = 0;
    Reservation reservation = new Reservation();
    List<Motorhome> motorhomes = null;



    @GetMapping(value = "") //todo step max/min
    public String ChooseDateAndModel(Model model, @RequestParam(value = "reset", required = false) String reset)
    {

        System.out.println(reset);
        if (reset!= null && reset.equalsIgnoreCase("true"))
        {
            reservation = new Reservation();
        }

        model.addAttribute("reservation", reservation);
        model.addAttribute("motorhomes", motorhomes);
        return "booking/booking";
    }

    @GetMapping(value = "/dates")
    public String ChooseMotorhome(Model model, @RequestParam("start")String start, @RequestParam("end")String end)
    {
        reservation.setStartDate(LocalDate.parse(start));
        reservation.setEndDate(LocalDate.parse(end));

        // todo calculate number of days

        motorhomes =  reservationRepo.findAllAvailableMotorhomes(reservation.getStartDate(), reservation.getEndDate());
        model.addAttribute("motorhomes", motorhomes );

        return "redirect:";
    }

    @GetMapping("/create")
    public String create(@RequestParam("motorhome_id")int motorhome_id, @RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("email") String email, @RequestParam("phone") String number)
    {
        Contact contact = new Contact();
        contact.setFirstName(fName);
        contact.setLastName(lName);
        contact.setEmail(email);
        contact.setPhone(number); //todo change phone to int

        BookingRepoImpl bookingRepo = new BookingRepoImpl();
        bookingRepo.create(contact); // todo get contact id

        //todo set contact_id
        reservation.setMotorhome_id(motorhome_id);
        reservation.setKmFromOffice(10d); // todo better calculation

        System.out.println("create");
        reservationRepo.create(reservation);
        System.out.println("done");


        return "redirect:";
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
