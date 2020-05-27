package rme.project.Models;

import java.time.LocalDate;

//sale is a junction table with contact and reservation ids
public class Sale {
    int contact_id;
    int reservation_id;
    LocalDate date;
    float amount;


    public Sale(int reservation_id, LocalDate date, float amount, int contact_id) {

        this.reservation_id = reservation_id;
        this.date = date;
        this.amount = amount;
        this.contact_id = contact_id;
    }

    /**************************************
     GETTERS AND SETTERS BELOW
     **************************************/


    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
}
