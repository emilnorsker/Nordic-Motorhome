package rme.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController
{
    IReservationRepo reservationsRepo = new ReservationRepoImpl();
    IMotorhomeRepo motorhomesRepo = new MotorhomeRepoIMPL();
    @GetMapping("")
    public String rent( Model model){

        List<String> models = new ArrayList<String>();
        List<Motorhome> typeModels = new ArrayList<Motorhome>();
        for (Motorhome M:motorhomesRepo.readAll())
        {
            if (!models.contains(M.model))
            {
                models.add(M.model);
                typeModels.add(M);
            }
        }


        model.addAttribute("motorhomes", typeModels);

        return "booking";
    }
}
