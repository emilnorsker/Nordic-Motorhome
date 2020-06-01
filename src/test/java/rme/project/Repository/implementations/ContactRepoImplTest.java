package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Contact;


import static org.junit.jupiter.api.Assertions.*;

class ContactRepoImplTest {
    ContactRepoImpl repo = new ContactRepoImpl();
    @Test
    void create() {
        //assign
        Contact expected = new Contact();
        Contact actual;
        expected.setEmail("HEj@hej.dk");
        expected.setFirstName("Test");
        expected.setLastName("testmand");
        expected.setPhone("123455");

        //act
        repo.create(expected);
        actual = repo.read(repo.getLastInsertId());

        //assert
        assertEquals(repo.getLastInsertId(), actual.getContact_id());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getEmail(), actual.getEmail());

        repo.delete(repo.getLastInsertId());    //Cleaning up DB
    }

    @Test
    void read() {
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getLastInsertId() {

    }
}