package rme.project.Repository.implementations;

/**
 * @Responsibility Emil Norsker
 */
import rme.project.Models.Motorhome;
import rme.project.Repository.interfaces.IMotorhomeRepo;
import rme.project.Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class MotorhomeRepoIMPL implements IMotorhomeRepo
{

    Connection conn = DBConnection.getDatabaseConnection();

    @Override
    public Motorhome create(Motorhome motorhome) {
        Motorhome motorhomeToCreate = new Motorhome();
        try {
            PreparedStatement createMotorhome = conn.prepareStatement("INSERT INTO motorhomes (motorhome_id,model, brand, price, licensePLate) VALUES (?,?,?,?,?)");


            createMotorhome.setInt(1, motorhome.getMotorhome_id());
            createMotorhome.setString(2, motorhome.getModel());
            createMotorhome.setString(3, motorhome.getBrand());
            createMotorhome.setFloat(4, motorhome.getPrice());
            createMotorhome.setString(5, motorhome.getLicensePlate());

            createMotorhome.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motorhomeToCreate;
    }


    @Override
    public Motorhome read(int id)
    {
        Motorhome motorhome = null;
        try
        {
            motorhome = new Motorhome();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM motorhomes WHERE motorhome_id=?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                //motorhome.setID(rs.getInt(1)); // todo use the autogenerated function of SQL
                motorhome.setModel(rs.getString(2));
                motorhome.setBrand(rs.getString(3));
                //motorhome.setImageURL(rs.getString(4));
                motorhome.setPrice(rs.getFloat(5));
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return motorhome;
        }
    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> motorhomes = null;
        try
        {
            motorhomes = new ArrayList<Motorhome>();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM motorhomes");


            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Motorhome mh = new Motorhome();
                // todo assign ID:
                mh.setMotorhome_id(rs.getInt(1));
                mh.setModel(rs.getString(2));
                mh.setBrand(rs.getString(3));
                //mh.setImageURL(rs.getString(4));
                mh.setPrice(rs.getFloat(4));
                mh.setLicensePlate(rs.getString(5));
                motorhomes.add(mh);
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return motorhomes;
        }
    }
    @Override
    public Motorhome update(Motorhome motorhome) {
        Motorhome motorhomeToUpdate = new Motorhome();
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE motorhomes SET model = ?, brand = ?, price =?, licensePlate = ? WHERE motorhome_id = ?");

            statement.setString(1, motorhome.getModel());
            statement.setString(2, motorhome.getBrand());
            statement.setFloat(3, motorhome.getPrice());
            statement.setString(4, motorhome.getLicensePlate());
            statement.setInt(5, motorhome.getMotorhome_id());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return motorhomeToUpdate;
    }

    @Override
    public Motorhome delete(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM motorhomes WHERE motorhome_id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return new Motorhome();
    }

    @Override
    public int Search(int id) {
        return 0;
    }
}