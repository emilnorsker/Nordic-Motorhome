package rme.project.Repository.implementations;

import rme.project.Models.Reservation;
import rme.project.Repository.interfaces.IReservationRepo;
import rme.project.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepoImpl implements IReservationRepo
{

    Connection conn = DBConnection.getDatabaseConnection();
    @Override
    public void create(Reservation item) {
        try
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservation (reservation_id, location, kmFromOffice, start_date, end_date, numberOfDays,motorhomes_id) VALUES (?,?,?,?,?,?,?)");

            statement.setInt(1, item.getReservation_id());
            statement.setString(2, item.getLocation());
            statement.setDouble(3, item.getKmFromOffice());
            statement.setDate(4, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(5, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date
            statement.setLong(6, item.getNumberOfDays());
            statement.setInt(7, item.getMotorhomeId());

            statement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public Reservation read(int id) {
        Reservation reservation = null;
        try
        {
            reservation = new Reservation();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservation WHERE id=?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {

                reservation.setReservation_id(rs.getInt(1));
                reservation.setLocation(rs.getString(2));
                reservation.setKmFromOffice(rs.getDouble(3));
                reservation.setStartDate(LocalDate.parse(rs.getString(4)));
                reservation.setEndDate(LocalDate.parse(rs.getString(5)));
                reservation.setNumberOfDays(rs.getLong(6));
                reservation.setMotorhomeId(rs.getInt(7));

            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return reservation;
        }
    }

    @Override
    public List<Reservation> readAll() {

        List<Reservation> reservationsList = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservation");
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                Reservation reservation = new Reservation();

                reservation.setReservation_id(rs.getInt(1));
                reservation.setLocation(rs.getString(2));
                reservation.setKmFromOffice(rs.getDouble(3));
                reservation.setStartDate(LocalDate.parse(rs.getString(4)));
                reservation.setEndDate(LocalDate.parse(rs.getString(5)));
                reservation.setNumberOfDays(rs.getLong(6));
                reservation.setMotorhomeId(rs.getInt(7));

                reservationsList.add(reservation);
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return reservationsList;
        }
    }

    @Override
    public void update(Reservation item)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("UPDATE reservations SET location = ?, kmFromOffice = ?, startDate = ?, endDate = ?, numberOfDays = ?, motorhome_id =? WHERE id = ?");

            statement.setString(1, item.getLocation());
            statement.setDouble(2, item.getKmFromOffice());
            statement.setDate(3, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(4, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date
            statement.setLong(5, item.getNumberOfDays());
            statement.setInt(6, item.getMotorhomeId());

            statement.setInt(7, item.getReservation_id());

            statement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservation WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}


