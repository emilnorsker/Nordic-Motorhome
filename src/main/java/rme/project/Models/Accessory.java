package rme.project.Models;

import java.util.List;

public class Accessory {
    int accessory_id;
    String name;
    float price;
    List<Motorhome> motorhomesList; //TODO make Junction table?
    String imagePath;

    //TODO Skal accessories have startDate og endDate så de ikke bliver double booket? ja. Eller foreign key Reservation?


    public Accessory(int accessory_id, String name, float price, List<Motorhome> motorhomesList, String imagePath) {
        this.accessory_id = accessory_id;
        this.name = name;
        this.price = price;
        this.motorhomesList = motorhomesList;
        this.imagePath = imagePath;
    }

    /**************************************
     * GETTERS AND SETTERS BELOW
     **************************************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Motorhome> getMotorhomesList() {
        return motorhomesList;
    }

    public void setMotorhomesList(List<Motorhome> motorhomesList) {
        this.motorhomesList = motorhomesList;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getAccessory_id() {
        return accessory_id;
    }

    public void setAccessory_id(int accessory_id) {
        this.accessory_id = accessory_id;
    }
}
