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
 * @version 4.0 added contact_id to reservation
 */
public class ReservationRepoImpl implements IReservationRepo {

    //todo contact information
    Connection conn = DBConnection.getDatabaseConnection();

    @Override
    public void create(Reservation item) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservations (reservation_id, location, kmFromOffice, startDate, endDate, numberOfDays,motorhome_id, contact_id) VALUES (?,?,?,?,?,?,?,?)");

            //todo  contact id

            statement.setInt(1, item.getReservation_id());
            statement.setString(2, item.getLocation());
            statement.setDouble(3, item.getKmFromOffice());
            statement.setDate(4, java.sql.Date.valueOf(item.getStartDate())); //Converting LocalDate to sql.Date
            statement.setDate(5, java.sql.Date.valueOf(item.getEndDate())); //Converting LocalDate to sql.Date
            item.setNumberOfDays(); //Calculate new number of days
            statement.setLong(6, item.getNumberOfDays());
            statement.setInt(7, item.getMotorhome_id());
            statement.setInt(8, item.getContact_id());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

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

                // todo use propperly, a.k.a. with interface
                reservation.setMotorhome(new MotorhomeRepoImpl().read(rs.getInt(7)));
                reservation.setContact(new ContactRepoImpl().read(rs.getInt(8)));


            }
        } catch (Exception e) {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        } finally {
            return reservation;
        }
    }

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

                //todo use propperly format, a.k.a. with interface IMotorhomeRepo...
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

    @Override
    public List<Motorhome> findAvailableMotorhomes(LocalDate start, LocalDate end, String[] models) {


        //generate evaluation data
        List<Integer> availableMotorhomes_id = new ArrayList<Integer>();
        IMotorhomeRepo motorhomes = new MotorhomeRepoImpl();
        List<Motorhome> result = new ArrayList<Motorhome>();

        try {
            // for each model type in model
            for (int i = 0; i < models.length; i++) {
                System.out.println("#######################################");
                System.out.println(models[i]);
                //find all motorhomes where model == model
                PreparedStatement findModelId = conn.prepareStatement("SELECT motorhome_id FROM motorhomes where model = ?");
                findModelId.setString(1, models[i]);
                ResultSet rs = findModelId.executeQuery();
                //check if the motorhome is available
                while (rs.next()) {
                    availableMotorhomes_id.add(rs.getInt(1));
                    System.out.println("from sql" + rs.getInt(1));
                }
                //subtract all motorhomes that are occupied in time period
                for (int j : availableMotorhomes_id) {
                    if (available(start, end, j)) ;
                    {
                        System.out.println("before passing fina;  " + j);
                        result.add(motorhomes.read(j)); //todo fix error here
                    }
                }
            }
        } catch (Exception e) {
        }

        return result;
    }

    @Override
    public List<Motorhome> findAllAvailableMotorhomes(LocalDate start, LocalDate end) {
        List<Motorhome> result = new ArrayList<Motorhome>();
        IMotorhomeRepo motorhomes = new MotorhomeRepoImpl();
        try {
            //gets all available motorhomes
            System.out.println("read all size" + motorhomes.readAll().size());
            for (int i = 0; i < motorhomes.readAll().size(); i++) {
                int motorhome_id = motorhomes.readAll().get(i).getMotorhome_id();
                if (available(start, end, motorhome_id)) {
                    result.add(motorhomes.read(motorhome_id));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    private boolean available(LocalDate start, LocalDate end, int id) // todo make test
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
                //TODO YO kan du ikke bare bruge ChronoUnit.DAYS.between(startDate, endDate) og se om den returner minus?
                flag1 = R.getStartDate().isAfter(start) == R.getEndDate().isAfter(start);
                flag2 = R.getEndDate().isAfter(end) == R.getEndDate().isAfter(end);
                if (flag1 == flag2)
                    return true; // magic (made with a karnaugh map)
            }
        } else
            return true;
        return false;
    }

    public void getMotorhome(int id) {

    }
}


