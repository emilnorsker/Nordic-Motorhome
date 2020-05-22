package rme.project.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import rme.project.Models.Accessory;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Private class, motorhome object
 * @author Mikkel Åxman
 */
public class Motorhome {
    String brand;
    String model;
    @Id // todo nødvendigt?
    String licensePlate; //Unique ID
    BigDecimal price;

    String imageURL;
    // Only image URL should be stored in database. Should throw MalformedURLException.

    List<Reservation> reservations;
    List<Accessory> accessories;

    public Motorhome() throws MalformedURLException {

    }

    public Motorhome(String brand, String model, String licensePlate, BigDecimal price, String imageURL) throws MalformedURLException {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.price = price;
        this.imageURL = imageURL;
    }

    /**************************************
      GETTERS AND SETTERS BELOW
     **************************************/
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
