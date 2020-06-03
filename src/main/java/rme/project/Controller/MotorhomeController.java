package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoImpl;

import java.sql.SQLException;

/**
 * @Author Rasmus Wedelheim
 */
@Controller
@RequestMapping("/motorhomes")
public class MotorhomeController {

    private final MotorhomeRepoImpl motorRepo = new MotorhomeRepoImpl();

    /**
     * @Author Rasmus Wedelheim
     * @param model
     * @return
     */
    @GetMapping("")
    public String motorhomes(Model model) {
        model.addAttribute("motorhomes", motorRepo.readAll());
        return "motorhomes/motorhomes";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/create")
    public String showCreatePage() {

        return "motorhomes/create";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param motorhome
     * @return
     * @throws SQLException
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.create(motorhome);
        return "redirect:";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("update")
    public String showUpdatePage() {

        return "update";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param motorhome
     * @return
     * @throws SQLException
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.update(motorhome);
        return "redirect:";
    }

    /**
     * @Author Rasmus Wedelheim
     * @param id
     * @return
     */
    @GetMapping("/delete/")
    public String delete(@RequestParam("id") String id) {
        motorRepo.delete(Integer.parseInt(id));

        return "redirect:/motorhomes";
    }

}
