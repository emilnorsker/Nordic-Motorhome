package rme.project.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
/**
@Controller
public class CustomErrorController implements ErrorController{

    @RequestMapping("/error")
//TODO MAKE RETURN "/error" LATER FOR NICER VIEW.
    public String handleError(HttpServletRequest request) {


        return "";
//        return "/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
**/
