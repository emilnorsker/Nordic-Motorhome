package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Repository.implementations.ContactRepoImpl;
import rme.project.Repository.interfaces.IContactRepo;

import java.sql.SQLException;
@Controller
@RequestMapping("contacts")
public class ContactsController
{
    private final IContactRepo contactRepo = new ContactRepoImpl();

    @GetMapping("")
    public String contacts(Model model){
        model.addAttribute("contacts", contactRepo.readAll());
        return "contacts/contacts";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contact contact) throws SQLException {
        contactRepo.create(contact);
        return "redirect:";
    }

    @GetMapping("/update")
    public String showUpdatePage(){

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contact contact) throws SQLException {
        contactRepo.update(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        contactRepo.delete(id);
        return "redirect:/contacts";
    }
}
