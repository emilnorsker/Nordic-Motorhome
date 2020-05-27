package rme.project.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import rme.project.Repository.implementations.ReservationRepoImpl;

import java.sql.SQLException;

public class ReservationController {
    private ReservationRepoImpl reservationRepo;

    {
        reservationRepo = new ReservationRepoImpl();
    }

    @GetMapping("/reservations")
    public String reservations(Model model){
        model.addAttribute("reservations", reservationRepo.readAll());
        return "reservations";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Reservation reservation) throws SQLException {

        return "redirect:/booking"; //TODO Sådan man Redirecter to rent??
    }

    @GetMapping("/update")
    public String showUpdatePage(){

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation) throws SQLException {
        reservationRepo.update(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        reservationRepo.delete(id);
        return "redirect:/reservations";
    }

}
