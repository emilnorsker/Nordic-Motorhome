package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;

@Controller
public class MainController {
    private MotorhomeRepoIMPL motorRepo;

    {
        try {
            motorRepo = new MotorhomeRepoIMPL();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/motorhomes")
    public String motorhomes(Model model){
        model.addAttribute("motorhomes", motorRepo.readAll());
        System.out.println(motorRepo.readAll().get(0).getModel());
        return "motorhomes";
    }


}

