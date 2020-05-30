package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Repository.implementations.BookingRepoImpl;
import rme.project.Repository.interfaces.IBookingRepo;

import java.sql.SQLException;
@Controller
@RequestMapping("contacts")
public class Contacts
{
    private IBookingRepo bookingRepo = new BookingRepoImpl();

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
}
