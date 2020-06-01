package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Contact;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mikkel
 */
class MotorhomeRepoImplTest {
    MotorhomeRepoImpl repo = new MotorhomeRepoImpl();
    @Test
    void create() {
        //assign
        Motorhome expected = new Motorhome(666, "TestBrand", "TestModel", "AB 3456", 1000, "TestType");
        Motorhome actual;

        //act
        repo.create(expected);
        actual = repo.read(repo.getLastInsertId());

        //assert
        assertEquals(repo.getLastInsertId(), actual.getMotorhome_id());
        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getLicensePlate(), actual.getLicensePlate());
        assertEquals(expected.getPrice(), actual.getPrice());

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
    void search() {
    }
}