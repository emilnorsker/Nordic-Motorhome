package rme.project.Repository.implementations;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.ast.Assign;
import rme.project.Models.Accessory;
import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepoImplTest {

    @Test
    void create() {
        //assign
        List<Accessory> accessoriesList = new List<Accessory>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Accessory> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Accessory accessory) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Accessory> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends Accessory> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Accessory get(int i) {
                return null;
            }

            @Override
            public Accessory set(int i, Accessory accessory) {
                return null;
            }

            @Override
            public void add(int i, Accessory accessory) {

            }

            @Override
            public Accessory remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Accessory> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Accessory> listIterator(int i) {
                return null;
            }

            @Override
            public List<Accessory> subList(int i, int i1) {
                return null;
            }
        };
        Reservation expected = new Reservation("Randomvej 777", 22.2, 2, 0, accessoriesList, LocalDate.parse("1990-05-22"), LocalDate.parse("2020-05-22")
        );
        Reservation actual;

        ReservationRepoImpl repo = new ReservationRepoImpl();

        //act
        repo.create(expected);
        actual = repo.read(expected.getId());

        //assert
        assertEquals(expected.getStartDate(), actual.getStartDate());
        assertEquals(expected.getNumberOfDays(), actual.getNumberOfDays());
    }
}