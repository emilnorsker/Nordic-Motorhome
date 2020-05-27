/*package rme.project.Repository.implementations;

import rme.project.Models.Motorhome;
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
    boolean flag = false;
    Connection conn = DBConnection.getDatabaseConnection();
    @Override
    public boolean create(Reservation item) {
        try
        {

            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservation (start_date, end_date, customer_id ,motorhomes_id) VALUES (?,?,?,?)");
            statement.setDate(1, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(2, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date

            //statement.setString(1, item.getStartDate().toString()); //TODO USE java.sql.Date.valueOf(dateToConvert); instead of string
            //statement.setString(2, item.getEndDate().toString());
            //statement.setString(3, item.getCustomer_id()); todo
            statement.setFloat(4,  item.getMotorhomeId());

            statement.executeUpdate();
            flag = true;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            return flag;
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

                reservation.setReservation_id(rs.getInt(1)); // todo use the autogenerated function of SQL
                reservation.setStartDate(LocalDate.parse(rs.getString(2))); //TODO burde vi ikke bruge getDate?
                reservation.setEndDate(LocalDate.parse(rs.getString(3)));
                reservation.setUserId(rs.getInt(4));
                reservation.setMotorhomeId(rs.getInt(5));
                //reservation.setAccessoryList(rs.get);
                //reservation.setKmFromOffice(rs.getDouble());
                //reservation.setLocation(rs.getString());
                //reservation.setLocation(rs.getString());
                //etc..
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
        Reservation reservation = null;
        List<Reservation> list = new ArrayList<Reservation>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservation");
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {

                reservation = new Reservation();
                //reservation.setID(rs.getInt(1)); // todo use the autogenerated function of SQL
                //reservation.setStartDate(rs.getString(2));
                //reservation.setEndDate(rs.getString(3));
                //reservation.setCustomerId(rs.getInt(4));
                //reservation.setMotorhomeId(rs.getInt(5));
                list.add(reservation);
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return list;
        }
    }

    @Override
    public boolean update(Reservation item)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("UPDATE reservation SET start_date = ?, end_date = ?, customer_id =?, motorhomes_id =? WHERE id = ?");

            statement.setDate(1, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(1, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date

            //statement.setString(1, item.getStartDate().toString());
            //statement.setString(2, item.getEndDate().toString());
            //statement.setString(3, item.getCustomer_id()); todo
            statement.setFloat(4,  item.getMotorhomeId());
            //statement.setInt(5, item.getId());


            statement.executeUpdate();
            flag = true;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            return flag;
        }
    }

    @Override
    public boolean delete(int id)
    {

        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservation WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            flag = true;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            return flag;
        }
    }
}
*/

