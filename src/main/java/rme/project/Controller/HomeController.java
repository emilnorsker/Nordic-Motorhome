package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rme.project.Models.Motorhome;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/home")
    public String home(){

        return "home";
    }
}
