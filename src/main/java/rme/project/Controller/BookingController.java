package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Repository.implementations.BookingRepoImpl;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController
{
    private BookingRepoImpl bookingRepo;

    {
        bookingRepo = new BookingRepoImpl();
    }
    private MotorhomeRepoIMPL motorhomesRepo;

    {
        motorhomesRepo = new MotorhomeRepoIMPL();
    }

    @GetMapping("")
    public String rent( Model model)
    {
        model.addAttribute("motorhomes", getModels());

        return "booking";
    }


    @GetMapping("/contacts")
    public String contacts(Model model){
        model.addAttribute("contacts", bookingRepo.readAll());
        return "contacts";
    }


    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contact contact) throws SQLException {
        bookingRepo.create(contact);
        return "redirect:/booking";
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

    public List<Motorhome> getModels()
    {
        List<String> models = new ArrayList<String>();
        List<Motorhome> typeModels = new ArrayList<Motorhome>();
        for (Motorhome M:motorhomesRepo.readAll())
        {
            if (!models.contains(M.model))
            {
                models.add(M.model);
                typeModels.add(M);
            }
        }
        return typeModels;
    }


    @GetMapping("/search/{start}{end}")
    public String search(@PathVariable("start")LocalDate start,@PathVariable("end")LocalDate end)
    {

        //System.out.println(start);
        return "/booking";
    }

}
