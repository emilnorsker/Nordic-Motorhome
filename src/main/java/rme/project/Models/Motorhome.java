package rme.project.Models;

import java.util.List;

/**
 *
 * @author Mikkel Åxman
 */
public class Motorhome {

    public int motorhome_id; //Auto-incrementing
    public String model;
    public String brand;
    public String licensePlate; //UNIQUE useful for indexing, but has a small chance of being null. Chance of having spaces as well.
    public float price; //Should be BigDecimal for precision

    //String imagePath;

    List<Reservation> reservations;
    List<Accessory> accessories;

    public Motorhome(){

    }
    public Motorhome(int id, String brand, String model, String licensePlate, float price)
        {
        this.motorhome_id = id;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.licensePlate = licensePlate;

    }


    /**************************************
      GETTERS AND SETTERS BELOW
     **************************************/

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

}
