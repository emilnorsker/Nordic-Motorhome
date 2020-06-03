package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Rasmus Wedelheim
 */
@Controller
public class HomeController {

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @GetMapping("/contactinfo")
    public String contactinfo() {
        return "contactinfo";
    }
}
