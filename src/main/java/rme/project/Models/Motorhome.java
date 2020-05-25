package rme.project.Models;

import org.springframework.data.annotation.Id;
import java.util.List;

/**
 * Private class, motorhome object
 * @author Mikkel Åxman
 */
public class Motorhome {

    int ID;
    String brand;
    String model;
    String licensePlate;
    float price;

    String imageURL;
    // Only image URL should be stored in database. Should throw MalformedURLException.

    List<Reservation> reservations;
    List<Accessory> accessories;

    public Motorhome(){

    }
    public Motorhome(int ID, String brand, String model, String licensePlate, float price)
        {
        this.ID = ID;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.price = price;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
