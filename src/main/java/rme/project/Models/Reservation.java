package rme.project.Models;

import org.springframework.data.annotation.Id;


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
    int motorhomeId;
    LocalDate startDate;
    LocalDate endDate;
    Long numberOfDays;

    public Reservation() {
    }

    public Reservation(int reservation_id, String location, double kmFromOffice, LocalDate startDate, LocalDate endDate, long numberOfDays, int motorhomeId) {
        this.reservation_id = reservation_id;
        this.location = location;
        this.kmFromOffice = kmFromOffice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = ChronoUnit.DAYS.between(startDate, endDate); //Calculates days length of the reservation
        this.motorhomeId = motorhomeId;
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

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
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
