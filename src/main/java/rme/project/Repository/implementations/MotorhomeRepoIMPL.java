package rme.project.Repository.implementations;

import rme.project.Models.Motorhome;
import rme.project.Repository.interfaces.MotorhomeRepo;

import java.sql.*;
import java.util.List;

public class MotorhomeRepoIMPL implements MotorhomeRepo
{

    Connection conn;


    public boolean create()
    {
        boolean flag = false;
        try
        {
            Motorhome motorhome = new Motorhome();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Motorhomes (model, brand, image_file, price) VALUES (?,?,?,?)");

            statement.setString(1, motorhome.getModel());
            statement.setString(2, motorhome.getBrand());
            statement.setString(3, motorhome.getImageURL().toString());
            statement.setBigDecimal(4, motorhome.getPrice());

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
    public boolean create(Motorhome item) {
        return false;
    }

    public Motorhome read(int id)
    {
        Motorhome motorhome = null;
        try
        {
            motorhome = new Motorhome();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Motorhomes WHERE motorhome_id=?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                //motorhome.setID(rs.getInt(1));
                motorhome.setModel(rs.getString(2));
                motorhome.setBrand(rs.getString(3));
                //motorhome.setImageURL(rs.getString(4));
                motorhome.setPrice(rs.getBigDecimal(5));
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
        return null;
    }

    @Override
    public boolean update(Motorhome item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public int Search(int id) {
        return 0;
    }
}
