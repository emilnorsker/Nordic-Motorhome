package rme.project.Repository.implementations;

import rme.project.Models.Reservation;
import rme.project.Repository.interfaces.IReservationRepo;

import java.util.List;

public class ReservationRepoImpl implements IReservationRepo
{

    @Override
    public boolean create(Reservation item) {
        return false;
    }

    @Override
    public Reservation read(int id) {
        return null;
    }

    @Override
    public List<Reservation> readAll() {
        return null;
    }

    @Override
    public boolean update(Reservation item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
