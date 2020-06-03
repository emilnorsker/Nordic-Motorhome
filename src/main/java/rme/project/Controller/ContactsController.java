package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Contact;
import rme.project.Repository.implementations.ContactRepoImpl;
import rme.project.Repository.interfaces.IContactRepo;

import java.sql.SQLException;


/**
 * @Author Emil Norsker, Rasmus Wedelheim
 */
@Controller
@RequestMapping("contacts")
public class ContactsController
{
    private final IContactRepo contactRepo = new ContactRepoImpl();


    /**
     * @Author Rasmus Wedelheim
     * @param model
     * @return
     */
    @GetMapping("")
    public String contacts(Model model){
        model.addAttribute("contacts", contactRepo.readAll());
        return "contacts/contacts";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/create")
    public String showCreatePage(){

        return "/create";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param contact
     * @return
     * @throws SQLException
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Contact contact) throws SQLException {
        contactRepo.create(contact);
        return "redirect:";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/update")
    public String showUpdatePage(){

        return "update";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param contact
     * @return
     * @throws SQLException
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Contact contact) throws SQLException {
        contactRepo.update(contact);
        return "redirect:/contacts";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        contactRepo.delete(id);
        return "redirect:/contacts";
    }
}
