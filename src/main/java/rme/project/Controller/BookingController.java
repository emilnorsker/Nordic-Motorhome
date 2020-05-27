package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IReservationRepo;

@Controller
@RequestMapping("/booking")
public class BookingController
{
    IReservationRepo repo = new ReservationRepoImpl();
    @GetMapping("/rent")
    public String rent( Model model){

        model.addAttribute("motorhomes", new Motorhome[]
                {   new Motorhome(),
                        new Motorhome(),
                        new Motorhome()});

        return "booking";
    }
}
