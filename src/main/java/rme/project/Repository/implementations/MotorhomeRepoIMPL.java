package rme.project.Repository.implementations;

import rme.project.Models.Motorhome;
import rme.project.Repository.interfaces.MotorhomeRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepoIMPL implements MotorhomeRepo
{

    Connection conn;



    @Override
    public boolean create(Motorhome item) {
        boolean flag = false;
        try
        {
            Motorhome motorhome = new Motorhome();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO motorhomes (model, brand, image_file, price) VALUES (?,?,?,?)");

            statement.setString(1, motorhome.getModel());
            statement.setString(2, motorhome.getBrand());
            statement.setString(3, motorhome.getImageURL());
            statement.setFloat(4, motorhome.getPrice());

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
                //motorhome.setID(rs.getInt(1));
                motorhome.setModel(rs.getString(2));
                motorhome.setBrand(rs.getString(3));
                motorhome.setImageURL(rs.getString(4));
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
                //mh.setID(rs.getInt(1));
                mh.setModel(rs.getString(2));
                mh.setBrand(rs.getString(3));
                mh.setImageURL(rs.getString(4));
                mh.setPrice(rs.getFloat(5));
                motorhomes.add( mh);
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
    public boolean update(Motorhome item) {
        boolean flag = false;
        try
        {
            PreparedStatement statement = conn.prepareStatement("UPDATE motorhomes SET model = ?, brand = ?, image_file =?, price =? WHERE id = ?");

            statement.setString(1, item.getModel());
            statement.setString(2, item.getBrand());
            statement.setString(3, item.getImageURL());
            statement.setFloat(4, item.getPrice());
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
    public boolean delete(int id) {
        boolean flag = false;
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM motorhome WHERE id=?");
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


    @Override
    public int Search(int id) {
        return 0;
    }
}
