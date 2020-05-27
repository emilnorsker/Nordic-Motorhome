package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class TestController
{
    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("motorhomeList", new String[] {"1", "2", "3", "4"});
        return "test";
    }
}
