package rme.project.Models;

import java.util.List;

/**
 *
 * @author Mikkel Åxman
 */
public class Motorhome {

    int ID; //Auto-incrementing
    String brand;
    String model;
    String licensePlate;    //UNIQUE useful for indexing, but has a small chance of being null. Chance of having spaces as well.
    float price;    //Should be BigDecimal for precision

    String imagePath;

    List<Reservation> reservations;
    List<Accessory> accessories;

    public Motorhome(){

    }
    public Motorhome(int ID, String brand, String model, String licensePlate, float price, String imagePath)
        {
        this.ID = ID;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.price = price;
        this.imagePath = imagePath;
    }


    /**************************************
      GETTERS AND SETTERS BELOW
     **************************************/

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
