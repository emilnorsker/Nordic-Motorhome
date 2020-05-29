package rme.project.Models;

/**
 * @author Mikkel Åxman
 * @version 2.0 cleaned up to mirror fields in DB. removed image filepath for now.
 */
public class Motorhome {

    private int motorhome_id; //Auto-incrementing, unsigned, not null, in DB
    private String model;
    private String brand;
    private String licensePlate; //UNIQUE useful for indexing, but has a small chance of being null. Chance of having spaces as well.
    private float price; //Should be BigDecimal for precision
    //private String imagePath;

    //Empty constructor
    public Motorhome(){
    }

    /**
     * Model for motorhome.
     * @param id    motorhome unique ID is not null, unsigned, auto-incrementing in DB
     * @param brand name of auto maker
     * @param model type/model of auto
     * @param licensePlate technically UNIQUE and possible primary key, but employees might set as null.
     * @param price Price per day. should be bigdecimal later.
     */
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

}
