package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rme.project.Models.Motorhome;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import java.sql.SQLException;

@Controller
public class MotorhomeController {
    private MotorhomeRepoIMPL motorRepo;

    {
        motorRepo = new MotorhomeRepoIMPL();
    }
    @GetMapping("/motorhomes")
    public String motorhomes(Model model){
        model.addAttribute("motorhomes", motorRepo.readAll());
        return "motorhomes";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.create(motorhome);
        return "redirect:/motorhomes";
    }

    @GetMapping("/update")
    public String showUpdatePage(){

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.update(motorhome);
        return "redirect:/motorhomes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        motorRepo.delete(id);
        return "redirect:/motorhomes";
    }

}
