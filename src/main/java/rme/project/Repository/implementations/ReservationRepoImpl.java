package rme.project.Repository.implementations;


import rme.project.Models.Motorhome;
import rme.project.Models.Reservation;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Repository.interfaces.IReservationRepo;
import rme.project.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author All
 */
public class ReservationRepoImpl implements IReservationRepo {

    //todo contact information
    Connection conn = DBConnection.getDatabaseConnection();

    /**
     * @Author Rasmus Wedelheim, Mikkel Åxman
     * @param item is a generic object and will be assigned by the class implementing this interface.
     */
    @Override
    public void create(Reservation item) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservations (location, kmFromOffice, startDate, endDate, numberOfDays,motorhome_id, contact_id) VALUES (?,?,?,?,?,?,?)");

           // statement.setInt(1, item.getReservation_id()); Is done on DB
            statement.setString(1, item.getLocation());
            statement.setDouble(2, item.getKmFromOffice());
            statement.setDate(3, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(4, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date
            item.setNumberOfDays(); //Calculate new number of days before setting
            statement.setLong(5, item.getNumberOfDays());
            statement.setInt(6, item.getMotorhome_id());
            statement.setInt(7, item.getContact_id());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * @Author Rasmus Wedelheim
     * @param id int
     * @return
     */
    @Override
    public Reservation read(int id) {
        Reservation reservation = null;
        try {
            reservation = new Reservation();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservations WHERE reservation_id=?");

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                reservation.setReservation_id(rs.getInt(1));
                reservation.setLocation(rs.getString(2));
                reservation.setKmFromOffice(rs.getDouble(3));
                reservation.setStartDate(LocalDate.parse(rs.getString(4)));
                reservation.setEndDate(LocalDate.parse(rs.getString(5)));
                reservation.setNumberOfDays();
                reservation.setMotorhome_id(rs.getInt(7));
                reservation.setContact_id(rs.getInt(8));

                reservation.setMotorhome(new MotorhomeRepoImpl().read(rs.getInt(7)));
                reservation.setContact(new ContactRepoImpl().read(rs.getInt(8)));


            }
        } catch (Exception e) {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        } finally {
            return reservation;
        }
    }

    /**
     * @Author Rasmus Wedelheim
     * @return
     */
    @Override
    public List<Reservation> readAll() {

        List<Reservation> reservationsList = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservations");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation();

                reservation.setReservation_id(rs.getInt(1));
                reservation.setLocation(rs.getString(2));
                reservation.setKmFromOffice(rs.getDouble(3));
                reservation.setStartDate(LocalDate.parse(rs.getString(4)));
                reservation.setEndDate(LocalDate.parse(rs.getString(5)));
                reservation.setNumberOfDays();
                reservation.setMotorhome_id(rs.getInt(7));
                reservation.setContact_id(rs.getInt(8));

                reservation.setMotorhome(new MotorhomeRepoImpl().read(rs.getInt(7)));
                reservation.setContact(new ContactRepoImpl().read(rs.getInt(8)));

                reservationsList.add(reservation);
            }
        } catch (Exception e) {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        } finally {
            return reservationsList;
        }
    }

    /**
     * @Author  Emil Norsker
     * @param item is a generic object and will be assigned by the class implementing this interface.
     */
    @Override
    public void update(Reservation item) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE reservations SET location = ?, kmFromOffice = ?, startDate = ?, endDate = ?, numberOfDays = ?, motorhome_id =?, contact_id =? WHERE reservation_id = ?");

            statement.setString(1, item.getLocation());
            statement.setDouble(2, item.getKmFromOffice());
            statement.setDate(3, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(4, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date
            item.setNumberOfDays();
            statement.setLong(5, item.getNumberOfDays());
            statement.setInt(6, item.getMotorhome_id());
            statement.setInt(7, item.getContact_id());
            statement.setInt(8, item.getReservation_id());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservations WHERE reservation_id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @Author  Emil Norsker
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<Motorhome> findAllAvailableMotorhomes(LocalDate start, LocalDate end) {
        List<Motorhome> result = new ArrayList<Motorhome>();
        IMotorhomeRepo motorhomes = new MotorhomeRepoImpl();
        try {
            //gets all available motorhomes
            System.out.println("read all size" + motorhomes.readAll().size());
            for (int i = 0; i < motorhomes.readAll().size(); i++) {
                int motorhome_id = motorhomes.readAll().get(i).getMotorhome_id();
                if (Available(start, end, motorhome_id)) {
                    result.add(motorhomes.read(motorhome_id));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    /**
     * @Author  Emil Norsker
     * @param start
     * @param end
     * @param id
     * @return
     */
    private boolean Available(LocalDate start, LocalDate end, int id) // todo make test
    {
        List<Reservation> reservationsList = new ArrayList<Reservation>();
        // reservations with that motorhome id
        try {

            //finding all reservation with the motorhome id
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservations WHERE motorhome_id = ?");

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();

                reservation.setReservation_id(rs.getInt(1));
                reservation.setLocation(rs.getString(2));
                reservation.setKmFromOffice(rs.getDouble(3));
                reservation.setStartDate(LocalDate.parse(rs.getString(4)));
                reservation.setEndDate(LocalDate.parse(rs.getString(5)));
                reservation.setNumberOfDays();
                reservation.setMotorhome_id(rs.getInt(7));
                reservation.setContact_id(rs.getInt(8));

                reservationsList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean flag1;
        boolean flag2;

        if (reservationsList.size() > 0) {
            for (Reservation R : reservationsList) {
                flag1 = R.getStartDate().isAfter(start) == R.getEndDate().isAfter(start);
                flag2 = R.getEndDate().isAfter(end) == R.getEndDate().isAfter(end);
                if (flag1 == flag2)
                    return true; // magic (made with a karnaugh map)
            }
        } else
            return true;
        return false;
    }

    /**
     * @Author Mikkel Åxman
     * We need this to get ID from newly created entry, since DB makes it automatically
     * @return ID as int
     */
    @Override
    public int getLastInsertId() {
        int lastID = 0;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM reservations");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lastID = resultSet.getInt(1);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return lastID;

    }
}


