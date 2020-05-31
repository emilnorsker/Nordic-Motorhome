package rme.project.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * @author Mikkel Åxman
 */
public class Reservation {

    private int reservation_id;
    private String location;
    private double kmFromOffice;
    private int motorhome_id; // too change type  to motorhome
    private Motorhome motorhome; // too change type  to motorhome
    @DateTimeFormat(pattern = "yyyy-MM-dd") //For when date is returned in another format and needs parsing
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Long numberOfDays;
    private Contact contact;

    //Empty constructor.
    public Reservation() {
    }

    /**
     *
     * @param reservation_id ID
     * @param location String address for drop-off
     * @param kmFromOffice manually entered distance to dropoff, used to calculate price. Will be made automatic later.
     * @param startDate Reservation starts at this date
     * @param endDate   Reservation ends at this date
     * @param motorhome_id  ID for motorhome used in this reservation
     */
    public Reservation(int reservation_id, String location, double kmFromOffice, LocalDate startDate, LocalDate endDate, int motorhome_id) {
        this.reservation_id = reservation_id;
        this.location = location;
        this.kmFromOffice = kmFromOffice;
        this.startDate = startDate;
        this.endDate = endDate;
        setNumberOfDays(); //Calculates days length of the reservation and sets field.
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

    public void setKmFromOffice(double kmFromOffice) { this.kmFromOffice = kmFromOffice; }

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

    public void setNumberOfDays() {
        this.numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
    }
}
