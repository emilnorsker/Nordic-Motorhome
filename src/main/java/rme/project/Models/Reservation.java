package rme.project.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author Mikkel Åxman
 */
public class Reservation {
    @Id
    int id;
    String location;
    double kmFromOffice;
    int userId;
    int motorhomeId;
    List<Accessory> accessoryList;
    @DateTimeFormat
    LocalDate startDate;
    LocalDate endDate;
    Long numberOfDays;

    public Reservation() {
    }

    /**
     *  TODO Skal vi checke her om motorhome og accessory ikke allerede er booket i den periode?
     * @param location String Address for pickup/delivery point
     * @param kmFromOffice Pickup kilometers away from office. (It's 0,70€ per kilometer.)
     * @param userId ID of user making reservation
     * @param motorhomeId
     * @param accessoryList
     * @param startDate Should be added as LocalDate.parse("YYYY-MM-DD")
     * @param endDate Should be added as LocalDate.parse("YYYY-MM-DD")
     */
    public Reservation(String location, double kmFromOffice, int userId, int motorhomeId, List<Accessory> accessoryList, LocalDate startDate, LocalDate endDate) {

        this.location = location;
        this.kmFromOffice = kmFromOffice;
        this.userId = userId;
        this.motorhomeId = motorhomeId;
        this.accessoryList = accessoryList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = userId + motorhomeId + startDate.getMonthValue(); //TODO hvad siger i til sådan en unique composite ID?
        this.numberOfDays = ChronoUnit.DAYS.between(startDate, endDate); //Calculates days length of the reservation
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public List<Accessory> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<Accessory> accessoryList) {
        this.accessoryList = accessoryList;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Long numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
