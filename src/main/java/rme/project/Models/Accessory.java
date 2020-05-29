package rme.project.Models;

/**
 * @author Mikkel Åxman
 * @version 2.0 removed list of motorhomes to mirror junction table setup in DB.
 */
public class Accessory {
    private int accessory_id;
    private String name;
    private float price;  //TODO Should be BigDecimal in later iteration
    private String imagePath;

    /**
     * Accessory is related to motorhome and reservation thru junction tables in DB
     * @param accessory_id ID is not-null, unsigned and auto-incremented in DB
     * @param name Item name
     * @param price Price pr. day
     * @param imagePath Filepath for image if any. leave null if none.
     */
    public Accessory(int accessory_id, String name, float price, String imagePath) {
        this.accessory_id = accessory_id;
        this.name = name;
        this.price = price;
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
