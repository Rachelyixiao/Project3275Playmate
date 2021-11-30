package com.example.project3275playmate.DAO;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.project3275playmate.Classes.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAO_Implementation implements DAOInterface {
    public Connection con1;

    public DAO_Implementation(Connection con1) throws SQLException {
        this.con1 = con1;
    }

    @Override
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        PreparedStatement query1 = con1.connect().prepareStatement("insert into User values(?,?,?)");

        query1.setString(1, user.getName());
        query1.setString(2, user.getEmail());
        query1.setString(3, user.getPassword());
        query1.executeUpdate();

        PreparedStatement query2 = con1.connect().prepareStatement("insert into Customer values(?,?)");
        query2.setString(1, user.getName());
        query2.setDouble(2, 0);
    }

    @Override
    public void addCustomer(User user) throws ClassNotFoundException, SQLException {
        PreparedStatement query1 = con1.connect().prepareStatement("insert into User values(?,?,?)");

        query1.setString(1, user.getName());
        query1.setString(2, user.getEmail());
        query1.setString(3, user.getPassword());
        query1.executeUpdate();

        PreparedStatement query2 = con1.connect().prepareStatement("insert into Customer values(?,?)");
        query2.setString(1, user.getName());
        query2.setDouble(2, 0);
    }

    @Override
    public void addExpert(User user) throws ClassNotFoundException, SQLException {
        PreparedStatement query1 = con1.connect().prepareStatement("insert into User values(?,?,?)");

        query1.setString(1, user.getName());
        query1.setString(2, user.getEmail());
        query1.setString(3, user.getPassword());
        query1.executeUpdate();
    }

    @Override
    public void addExpertAdditionalInfo(User user, String gender, double rating) throws ClassNotFoundException, SQLException {

        PreparedStatement query = con1.connect().prepareStatement("insert into Expert set name=?, gender=?, rating=?");
        query.setString(1, user.getName());
        query.setString(2, gender);
        query.setDouble(3, rating);
    }

    @Override
    public void edit(User user, String name) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con1.connect().prepareStatement("Update user set email=?, password=? where name = ?");
        query.setString(1, user.getEmail());
        query.setString(2, user.getPassword());

        query.executeUpdate();
    }

    @Override
    public void delete(String name) throws SQLException, ClassNotFoundException {
        String query1 = "delete from category where name = ?";
        PreparedStatement query = con1.connect().prepareStatement(query1);
        query.setString(1, name);
        query.executeUpdate();
        System.out.println("One record Deleted");
    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {
        String query1 = "Select * from user";
        PreparedStatement query = con1.connect().prepareStatement(query1);
        ResultSet rs = query.executeQuery();
        User obj1;

        while(rs.next()){
            obj1 = new User(rs.getString("name"), rs.getString("email"), rs.getString("password"));
            System.out.println();
            System.out.println("User Name: " + obj1.getName() + "  ");
            System.out.println("User Email: " + obj1.getEmail());
        }
    }

    @Override
    public User searchUser(String name) throws SQLException, ClassNotFoundException {
        String query1 = "Select * from User where name = ?";
        PreparedStatement query = con1.connect().prepareStatement(query1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        query.setString(1, name);

        ResultSet rs = query.executeQuery();

        if (!rs.first()){
            System.out.print("Record not existing");
            return null;
        }

        User obj1 = new User(rs.getString("name"),rs.getString("email"),rs.getString("password"));
        return obj1;
    }

    @Override
    public Game searchGame(String name) throws SQLException, ClassNotFoundException {
        String query1 = "Select * from Game where GName = ?";
        PreparedStatement query = con1.connect().prepareStatement(query1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        query.setString(1, name);

        ResultSet rs = query.executeQuery();

        if (!rs.first()){
            System.out.print("Record not existing");
            return null;
        }

        Game obj1 = new Game(rs.getString("GName"),rs.getString("GType"));
        return obj1;
    }

    public void setBalance(Customer customer, double amount) throws SQLException, ClassNotFoundException{
        PreparedStatement query;
        query = con1.connect().prepareStatement("Update customer set balance=? where name=?");
        query.setDouble(1, customer.getBalance() + amount);
        query.setString(2, customer.getName());
        query.executeUpdate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void topUp(Customer customer, Admin admin, TopUp topUp, LocalDate date, String transactionType, double amount)
            throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        setBalance(customer, amount);

        query = con1.connect().prepareStatement("insert into TopUp values(?,?,?,?,?,?)");
        query.setInt(1, topUp.getTTID());
        query.setString(2, customer.getName());
        query.setString(3, admin.getName());
        query.setDate(4, Date.valueOf(String.valueOf(date)));
        query.setDouble(5, amount);
        query.setString(6, transactionType);
        query.executeUpdate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void transaction(Customer customer, Expert expert, Admin admin, Transaction transaction, LocalDate date, double hours, double amount)
            throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        setBalance(customer, -amount);//customer花钱
        query = con1.connect().prepareStatement("insert into Transaction values(?,?,?,?,?,?,?)");
        query.setInt(1, transaction.getTID());
        query.setString(2, admin.getName());
        query.setString(3, expert.getName());
        query.setString(4, customer.getName());
        query.setDate(5, Date.valueOf(String.valueOf(date)));
        query.setDouble(6, hours);
        query.setDouble(7, amount);
        query.executeUpdate();
    }

    @Override
    public void createGameProfile(Game game, Expert expert, String gameLevel, String description) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con1.connect().prepareStatement("insert into GameProfile values(?,?,?,?)");
        query.setString(1, game.getGName());
        query.setString(2, expert.getName());
        query.setString(3, gameLevel);
        query.setString(4, description);
    }
}
