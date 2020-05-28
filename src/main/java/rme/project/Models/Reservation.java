package rme.project.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * @author Mikkel Åxman
 */
public class Reservation {
    @Id
    int reservation_id;
    String location;
    double kmFromOffice;
    int motorhome_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;
    Long numberOfDays;

    public Reservation() {
    }

    public Reservation(int reservation_id, String location, double kmFromOffice, LocalDate startDate, LocalDate endDate, int motorhome_id) {
        this.reservation_id = reservation_id;
        this.location = location;
        this.kmFromOffice = kmFromOffice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = ChronoUnit.DAYS.between(startDate, endDate); //Calculates days length of the reservation
        this.motorhome_id = motorhome_id;
    }

    /**************************************
     * GETTERS AND SETTERS BELOW
     **************************************/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getKmFromOffice() {
        return kmFromOffice;
    }

    public void setKmFromOffice(double kmFromOffice) {
        this.kmFromOffice = kmFromOffice;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Long numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
