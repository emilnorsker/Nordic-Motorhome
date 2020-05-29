package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.ReservationRepoImpl;

import java.sql.SQLException;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationRepoImpl reservationRepo;

    {
        reservationRepo = new ReservationRepoImpl();
    }

    @GetMapping("")
    public String reservations(Model model){
        model.addAttribute("reservations", reservationRepo.readAll());
        return "reservations/reservations";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute Reservation reservation) throws SQLException {

        return "booking"; //TODO Sådan man Redirecter to rent??
    }

    @GetMapping("/update") //todo what view is update
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

}
