package rme.project.Models;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class Accessory {
    int id;
    String name;
    BigDecimal price;
    List<Motorhome> motorhomesList; //TODO make Junction table?
    URL imageURL;

    //TODO Skal accessories have startDate og endDate så de ikke bliver double booket? ja
    //TODO Er det nødvendigt at lave throws MalformedURLException på constructor? nej, som udgangspunkt håndtere vi alle fejl i metoden, ingen grund til at sende lorten videre :D
    //TODO Er tom constructor nødvendig? nej, kun hvis vi bruger JPA og dens entity metoder

    public Accessory(String name, BigDecimal price, List<Motorhome> motorhomesList, URL imageURL) {
        this.name = name;
        this.price = price;
        this.motorhomesList = motorhomesList;
        this.imageURL = imageURL;
        //TODO Hvad gør vi med ID
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Motorhome> getMotorhomesList() {
        return motorhomesList;
    }

    public void setMotorhomesList(List<Motorhome> motorhomesList) {
        this.motorhomesList = motorhomesList;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }
}
