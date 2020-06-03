package rme.project.Repository.implementations;


import rme.project.Models.Motorhome;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Emil Norsker, Mikkel Åxman
 */
public class MotorhomeRepoImpl implements IMotorhomeRepo {

    Connection conn = DBConnection.getDatabaseConnection();

    /**
     * @Author Emil Norsker
     * @param motorhome
     */
    @Override
    public void create(Motorhome motorhome) {

        try {
            PreparedStatement createMotorhome = conn.prepareStatement("INSERT INTO motorhomes (model, brand, price, licensePLate, type) VALUES (?,?,?,?,?)");


           // createMotorhome.setInt(1, motorhome.getMotorhome_id()); Is done on DB
            createMotorhome.setString(1, motorhome.getModel());
            createMotorhome.setString(2, motorhome.getBrand());
            createMotorhome.setFloat(3, motorhome.getPrice());
            createMotorhome.setString(4, motorhome.getLicensePlate());
            createMotorhome.setString(5, motorhome.getType());
            createMotorhome.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * @Author Emil Norsker
     * @param id int
     * @return
     */
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

    /**
     * @Author Emil Norsker
     * @return
     */
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

    /**
     * @Author Emil Norsker
     * @param motorhome
     */
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

    /**
     * @Author Emil Norsker
     * @param id
     */
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

    /**
     * @Author Mikkel Åxman
     * We need this to get ID from newly created entry, since DB makes it automatically
     * @return ID as int
     */
    @Override
    public int getLastInsertId() {
        int lastID = 0;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM motorhomes");
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

    /**
     * @Author Mikkel Åxman
     * @param id
     * @return
     */
    @Override
    public int Search(int id) {
        return 0;
    }
}