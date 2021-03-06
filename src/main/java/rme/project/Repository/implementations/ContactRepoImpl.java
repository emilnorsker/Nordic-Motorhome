package rme.project.Repository.implementations;

import rme.project.Models.Contact;
import rme.project.Repository.interfaces.IContactRepo;
import rme.project.Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rasmus Wedelheim
 */
public class ContactRepoImpl implements IContactRepo {

    Connection conn = DBConnection.getDatabaseConnection();

    /**
     * @Author Rasmus Wedelheim
     * @param contact
     */
    @Override
    public void create(Contact contact) {
        try {
            PreparedStatement createContact = conn.prepareStatement("INSERT INTO contact (firstName, lastName, email, phone) VALUES (?,?,?,?)");
            //MySQL will auto increment the ID
            createContact.setString(1, contact.getFirstName());
            createContact.setString(2, contact.getLastName());
            createContact.setString(3, contact.getEmail());
            createContact.setString(4, contact.getPhone());
            createContact.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author Rasmus Wedelheim
     * @param id int
     * @return
     */
    @Override
    public Contact read(int id)
    {
        Contact contact = null;
        try
        {
            contact = new Contact();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contact WHERE contact_id=?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                contact.setContact_id(rs.getInt(1));
                contact.setFirstName(rs.getString(2));
                contact.setLastName(rs.getString(3));
                contact.setEmail(rs.getString(4));
                contact.setPhone(rs.getString(5));
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return contact;
        }
    }
    /**
     * @Author Rasmus Wedelheim
     */
    @Override
    public List<Contact> readAll() {
        List<Contact> contact = null;
        try
        {
            contact = new ArrayList<Contact>();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contact");


            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Contact ct = new Contact();
                ct.setContact_id(rs.getInt(1));
                ct.setFirstName(rs.getString(2));
                ct.setLastName(rs.getString(3));
                ct.setEmail(rs.getString(4));
                ct.setPhone(rs.getString(5));
                contact.add(ct);
            }
        }
        catch (Exception e)
        {
            System.out.println(e); // we're only printing, for the sake of not interrupting the system.
        }
        finally {
            return contact;
        }
    }

    /**
     * @Author Rasmus Wedelheim
     * @param contact
     */
    @Override
    public void update(Contact contact) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE contact SET firstName = ?, lastName = ?, email =?, phone = ? WHERE contact_id = ?");

            statement.setString(1, contact.getFirstName());
            statement.setString(2,contact.getLastName());
            statement.setString(3, contact.getEmail());
            statement.setString(4,contact.getPhone());
            statement.setInt(5, contact.getContact_id());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * @Author Rasmus Wedelheim
     * @param id
     */
    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM contact WHERE contact_id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (Exception e){
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
            List<Contact> contact = null;
            PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM contact");
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