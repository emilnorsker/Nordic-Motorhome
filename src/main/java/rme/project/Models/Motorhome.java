package rme.project.Models;

/**
 * @author Mikkel Åxman
 * @version 2.0 cleaned up to mirror fields in DB. removed image filepath for now.
 */
public class Motorhome {

    private int motorhome_id; //Auto-incrementing, unsigned, not null, in DB
    private String model;
    private String brand;
    private float price; //Should be BigDecimal for precision
    private String licensePlate; //UNIQUE useful for indexing, but has a small chance of being null. Chance of having spaces as well.
    private String type;
    //private String imagePath;

    //Empty constructor
    public Motorhome(){
    }

    /**
     * Model for motorhome.
     * @param id    motorhome unique ID is not null, unsigned, auto-incrementing in DB
     * @param brand name of auto maker
     * @param model type/model of auto
     * @param licensePlate Like "AB 12 123". MAX 9 chars (incl. spaces), UNIQUE but can't be primary key, because employees might set as null. Thankfully SQL allows multiple nulls.
     * @param price Price per day. should be bigdecimal later.
     * @param type Type of vehicle, e.g. 2p, 4p, 6p, convertible..
     */
    public Motorhome(int id, String brand, String model, String licensePlate, float price, String type)
    {
        this.motorhome_id = id;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.licensePlate = licensePlate;
        this.type = type;
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

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
