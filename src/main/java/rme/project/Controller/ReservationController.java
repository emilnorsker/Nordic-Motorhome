package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.sql.SQLException;

/**
 * @author Mikkel Åxman
 */
@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private IReservationRepo reservationRepo = new ReservationRepoImpl();
    private IMotorhomeRepo motorhomeRepo = new MotorhomeRepoIMPL();

    @GetMapping()
    public String reservations(Model model){
        model.addAttribute("reservations", reservationRepo.readAll());
        model.addAttribute("reservations", reservationRepo.readAll());
        model.addAttribute("reservations", reservationRepo.readAll());



        return "reservations/reservations";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "redirect:booking/";
    }

    @PostMapping("/create")
    public String create() {
        return "redirect:booking/";  //TODO redirect to booking
    }

    @GetMapping("/update")
    public String showUpdatePage(){
        return "redirect:/reservations";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation) throws SQLException {
        reservationRepo.update(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/delete/")
    public String delete(@RequestParam(value = "id", required = false) String id){
        System.out.println(id);
        reservationRepo.delete(Integer.parseInt(id));
        return "redirect:/reservations";
    }

    @GetMapping("/getMotorhome/{id}")
    public String getMotorhome(@PathVariable("id") int id){
        motorhomeRepo.read(id);
        return "redirect:/reservations";
    }

}
