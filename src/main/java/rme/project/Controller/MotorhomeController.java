package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Motorhome;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import java.sql.SQLException;

@Controller
@RequestMapping("/motorhomes")
public class MotorhomeController {

    private MotorhomeRepoIMPL motorRepo = motorRepo = new MotorhomeRepoIMPL();

    @GetMapping("")
    public String motorhomes(Model model){
        model.addAttribute("motorhomes", motorRepo.readAll());
        return "motorhomes/motorhomes";
    }

    @GetMapping("/create")
    public String showCreatePage(){

        return "motorhomes/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.create(motorhome);
        return "redirect:";
    }

    @GetMapping("update")
    public String showUpdatePage(){

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Motorhome motorhome) throws SQLException {
        motorRepo.update(motorhome);
        return "redirect:";
    }

    @GetMapping("/delete/")
    public String delete(@RequestParam("id") String id){
        motorRepo.delete(Integer.parseInt(id));

        return "redirect:/motorhomes";
    }

}
