package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import rme.project.Models.Motorhome;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class MotorhomeRepoIMPLTest {

    @Test
    void create()
    {
        //assign
        Motorhome expected = new Motorhome(1, "brand","model", "abc12345678", 1f);
        Motorhome actual;

        MotorhomeRepoIMPL repo = new MotorhomeRepoIMPL();

        //act
        repo.create(expected);
        actual = repo.read(expected.getID());

        //assert
        assertEquals(expected.getBrand(), actual.getBrand());



    }

    @Test
    void read()
    {

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