package rme.project.Models;

import java.util.List;

public class User {
    int user_id;
    String firstName;
    String lastName;
    String address;
    String email;
    String phone;
    List<Sale> saleList; //foreign keys for sales made by user
    Boolean isEmployee; //TODO mangler vi en bool for isEmployee i user?

    /**
     *
     * @param user_id
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone
     * @param saleList List of sales made by user. one to many relation.
     */
    public User(int user_id, String firstName, String lastName, String address, String email, String phone, List<Sale> saleList) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.saleList = saleList;
    }

    /**************************************
     GETTERS AND SETTERS BELOW
     **************************************/

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }
}
