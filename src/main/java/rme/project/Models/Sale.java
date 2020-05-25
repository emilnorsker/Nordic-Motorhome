package rme.project.Models;

import java.time.LocalDate;

public class Sale {
    int sale_id;
    int reservation_id;
    LocalDate date;
    float amount;

    public Sale(int sale_id, int reservation_id, LocalDate date, float amount) {
        this.sale_id = sale_id;
        this.reservation_id = reservation_id;
        this.date = date;
        this.amount = amount;
    }

    /**************************************
     GETTERS AND SETTERS BELOW
     **************************************/

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

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
}
