package rme.project.Models;

/**
 * @author Mikkel Åxman
 * @version 2.0 Changed classname from user. removed a few unused attributes.
 */
public class Contact {
    private int contact_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    //Empty constructor
    public Contact() {
    }

    /**
     * Contact info constructor.
     *
     * @param contact_id ID auto incremented in DB
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     */
    public Contact(int contact_id, String firstName, String lastName, String email, String phone) {
        this.contact_id = contact_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    /**************************************
     GETTERS AND SETTERS BELOW
     **************************************/

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

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
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
}