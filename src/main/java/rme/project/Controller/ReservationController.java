package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.ReservationRepoImpl;

import java.sql.SQLException;

/**
 * @author Mikkel Åxman
 */
@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationRepoImpl reservationRepo;

    {
        reservationRepo = new ReservationRepoImpl();
    }

    @GetMapping()
    public String reservations(Model model){
        model.addAttribute("reservations", reservationRepo.readAll());
        return "reservations/reservations";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "redirect:booking";
    }

    @PostMapping("/create")
    public String create() {
        return "redirect:booking";  //TODO redirect to booking
    }

    @GetMapping("/update")
    public String showUpdatePage(){
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation) throws SQLException {
        reservationRepo.update(reservation);
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        reservationRepo.delete(id);
        return "redirect:";
    }

    @GetMapping("/getMotorhome/{id}")
    public String getMotorhome(@PathVariable("id") int id){
        reservationRepo.getMotorhome(id);
        return "redirect:";
    }

}
