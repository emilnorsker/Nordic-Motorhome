package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
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




    @GetMapping("")
    public String ChooseDateAndModel(Model model)
    {
        model.addAttribute("motorhomes", getModels());

        return "booking/booking";
    }


    @GetMapping("/search")
    public String ChooseMotorhome(@RequestParam(value="start")String start,@RequestParam(value="end")String end, @RequestParam(value="model") String[] models, Model model)
    {
        LocalDate startDate = LocalDate.parse(start);
        System.out.println(startDate);
        LocalDate endDate = LocalDate.parse(end);
        System.out.println(endDate);

        model.addAttribute("availableMotorhomes",reservationRepo.findAvailableMotorhomes(startDate, endDate, models));
        return "redirect:/booking";
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
