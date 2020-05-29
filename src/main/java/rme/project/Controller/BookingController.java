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
    private IBookingRepo bookingRepo = new BookingRepoImpl();
    private IMotorhomeRepo motorhomesRepo = new MotorhomeRepoIMPL();
    private IReservationRepo reservationRepo = new ReservationRepoImpl();

    public int step = 0;
    Reservation reservation = new Reservation();


    @GetMapping(value = "") //todo step max/min
    public String ChooseDateAndModel(Model model)
    {
        model.addAttribute("reservation", reservation);



        model.addAttribute("step", step);
        model.addAttribute("motorhomes", null);
        return "booking/booking";
    }

    @GetMapping(value = "/dates")
    public String ChooseMotorhome(Model model, @RequestParam("start")String start, @RequestParam("end")String end)
    {
        reservation.setStartDate(LocalDate.parse(start));
        reservation.setEndDate(LocalDate.parse(end));

        System.out.println(start);
        System.out.println(end);

        model.addAttribute("motorhomes", reservationRepo.findAllAvailableMotorhomes(reservation.getStartDate(), reservation.getEndDate()));

        return "redirect:";
    }

    //change to modal, opened from reservations?
    //addDates
    //addMotorhome
    //addReservation
/*
    @GetMapping(value = "step0") //todo step max/min
    public String ChooseDateAndModel(Model model, @RequestParam(value="step", required = false)Integer increment, @RequestParam(value="start", required = false)String start,@RequestParam(value="end", required = false)String end, @RequestParam(value="model", required = false) String[] models)
    {


        if (!(increment==null))
        {
            if (!(step<0 || step>3))
            step+=increment;
        }
        model.addAttribute("step", step);
        model.addAttribute("motorhomes", getModels());

        return "booking/booking/"+;
    }

    public String SearchAvailable(String start, String end, String[] models)
    {
        LocalDate startDate = LocalDate.parse(start);
        System.out.println(startDate);
        LocalDate endDate = LocalDate.parse(end);
        System.out.println(endDate);
        reservationRepo.findAvailableMotorhomes(startDate, endDate, models);
        return "";
    }
*/
/*
    @GetMapping(value="")
    public String ChooseMotorhome(Model model, @RequestParam(value="step", required = false)Integer increment, @RequestParam(value="id", required = false)Integer id)
    {


        if (!(increment==null))
        {
            if (!(step<0 || step>3))
                step+=increment;
        }
        model.addAttribute("step", step);

        return "booking/booking";
    }
*/
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

    @GetMapping("/contacts")
    public String contacts(Model model){
        model.addAttribute("contacts", bookingRepo.readAll());
        return "contacts/contacts";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contact contact) throws SQLException {
        bookingRepo.create(contact);
        return "redirect:";
    }

    @GetMapping("/update")
    public String showUpdatePage(){

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contact contact) throws SQLException {
        bookingRepo.update(contact);
        return "redirect:/booking/contacts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        bookingRepo.delete(id);
        return "redirect:/booking/contacts";
    }

    // ##########################################################################################################

    // step one pick date and model

    //step two choose model


}
