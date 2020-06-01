package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mikkel
 */
class MotorhomeRepoImplTest {

    @Test
    void create() {
        //assign
        MotorhomeRepoImpl repo = new MotorhomeRepoImpl();
        repo.delete(666); //Cleaning last test up

        Motorhome expected = new Motorhome(666, "Space-Z", "Dragon", "ZZ 22 455", 1234,"3P");
        Motorhome actual;


        //act
        repo.create(expected);
        actual = repo.read(expected.getMotorhome_id());

        //assert
        assertEquals(expected.getMotorhome_id(), actual.getMotorhome_id());
        assertEquals(expected.getBrand(), actual.getBrand());
        assertEquals(expected.getLicensePlate(), actual.getLicensePlate());
        assertEquals(expected.getType(), actual.getType());

        // repo.delete(666); //Cleaning test up. Lets keep for now tho

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