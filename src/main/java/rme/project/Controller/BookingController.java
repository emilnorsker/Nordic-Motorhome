package rme.project.Controller;

import org.apache.tomcat.jni.Error;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.implementations.MotorhomeRepoIMPL;
import rme.project.Repository.implementations.ReservationRepoImpl;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController
{
    IReservationRepo reservationsRepo = new ReservationRepoImpl();
    IMotorhomeRepo motorhomesRepo = new MotorhomeRepoIMPL();
    @GetMapping("")
    public String rent( Model model)
    {
        model.addAttribute("motorhomes", getModels());



        return "booking";
    }

    public List<Motorhome> getModels()
    {
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

        return typeModels;

    }


    @PostMapping("/search/{model}/{start}/{end}")
    public String search(@PathVariable("model") String model, @PathVariable("start")LocalDate start,@PathVariable("end")LocalDate end)
    {

        return "redirect:booking";
    }

}
