/**
 * @author Rasmus Wedelheim
 */
package rme.project.Repository.interfaces;


import rme.project.Models.Contact;

public interface IContactRepo extends CRUD<Contact> {


    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    int getLastInsertId();
}
