package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;

@Controller
public class MainController {
    private MotorhomeRepoIMPL motorRepo;

    @GetMapping("/")
    public String index(){

        return "index";
    }
    /*
    @GetMapping("/motorhomes")
    public String index(Model model){
        model.addAttribute("motorhomes", motorRepo.readAll());

        return "motorhomes";
    }

     */
}

