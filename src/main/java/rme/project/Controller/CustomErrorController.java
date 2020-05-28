package rme.project.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    //GIVER CHECK FOR NULL FØR PRINT    Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception"); //TODO somehow print execption.getmessage() in view?

        if (status != null) {
            System.out.println("KOMMER HERTIL 1");

            Integer statusCode = Integer.valueOf(status.toString());
         //   System.out.println(statusCode + " Exception: " + exception.getMessage());
            System.out.println("KOMMER HERTIL 2");

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}

