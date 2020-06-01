package rme.project.Repository.implementations;

/**
 * @Responsibility Emil Norsker
 * @version 3.0 added type to model @author mikkel
 */

import rme.project.Models.Motorhome;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotorhomeRepoImpl implements IMotorhomeRepo {

    Connection conn = DBConnection.getDatabaseConnection();

    @Override
    public void create(Motorhome motorhome) {

        try {
            PreparedStatement createMotorhome = conn.prepareStatement("INSERT INTO motorhomes (motorhome_id,model, brand, price, licensePLate, type) VALUES (?,?,?,?,?,?)");


            createMotorhome.setInt(1, motorhome.getMotorhome_id());
            createMotorhome.setString(2, motorhome.getModel());
            createMotorhome.setString(3, motorhome.getBrand());
            createMotorhome.setFloat(4, motorhome.getPrice());
            createMotorhome.setString(5, motorhome.getLicensePlate());
            createMotorhome.setString(6, motorhome.getType());
            createMotorhome.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Motorhome read(int id) {
        Motorhome mh = null;
        try {
            mh = new Motorhome();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM motorhomes WHERE motorhome_id=?");

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                mh.setMotorhome_id(rs.getInt(1));
                mh.setModel(rs.getString(2));
                mh.setBrand(rs.getString(3));
                //mh.setImageURL(rs.getString(4));
                mh.setPrice(rs.getFloat(4));
                mh.setLicensePlate(rs.getString(5));
                mh.setType(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        } finally {
            return mh;
        }
    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> motorhomes = null;
        try {
            motorhomes = new ArrayList<Motorhome>();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM motorhomes");


            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Motorhome mh = new Motorhome();

                mh.setMotorhome_id(rs.getInt(1));
                mh.setModel(rs.getString(2));
                mh.setBrand(rs.getString(3));
                //mh.setImageURL(rs.getString(4));
                mh.setPrice(rs.getFloat(4));
                mh.setLicensePlate(rs.getString(5));
                mh.setType(rs.getString(6));

                motorhomes.add(mh);
            }
        } catch (Exception e) {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        } finally {
            return motorhomes;
        }
    }

    @Override
    public void update(Motorhome motorhome) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE motorhomes SET model = ?, brand = ?, price =?, licensePlate = ?, type = ? WHERE motorhome_id = ?");

            statement.setString(1, motorhome.getModel());
            statement.setString(2, motorhome.getBrand());
            statement.setFloat(3, motorhome.getPrice());
            statement.setString(4, motorhome.getLicensePlate());
            statement.setString(5, motorhome.getType());
            statement.setInt(6, motorhome.getMotorhome_id());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM motorhomes WHERE motorhome_id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public int Search(int id) {
        return 0;
    }
}