package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rme.project.Models.Motorhome;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;

import java.sql.SQLException;

@Controller
public class MainController {
    private MotorhomeRepoIMPL motorRepo;

    {
        motorRepo = new MotorhomeRepoIMPL();
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/motorhomes")
    public String motorhomes(Model model){
        model.addAttribute("motorhomes", motorRepo.readAll());
        return "motorhomes";
    }

    @GetMapping("/home")
    public String home(){

        return "home";
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



}