package com.example.project3275playmate.DAO;

import com.example.project3275playmate.Classes.*;

import java.sql.SQLException;
import java.time.LocalDate;

public interface DAOInterface {
    public void addUser(User user) throws ClassNotFoundException, SQLException;
    public void addCustomer(User user) throws ClassNotFoundException, SQLException;
    public void addExpert(User user) throws ClassNotFoundException, SQLException;
    public void addExpertAdditionalInfo(User user, String gender, double rating) throws ClassNotFoundException, SQLException;
    public void edit(User user, String name) throws SQLException, ClassNotFoundException;
    public void delete(String name) throws SQLException, ClassNotFoundException;
    public void display() throws ClassNotFoundException, SQLException;
    public User searchUser(String name) throws SQLException, ClassNotFoundException;
    public Game searchGame(String name) throws SQLException, ClassNotFoundException;
    public void setBalance(Customer customer, double amount) throws SQLException, ClassNotFoundException;
    public void topUp(Customer customer, Admin admin, TopUp topUp, LocalDate date, String transactionType, double amount)
            throws SQLException, ClassNotFoundException;
    public void transaction(Customer customer, Expert expert, Admin admin, Transaction transaction, LocalDate date, double hours, double amount)
            throws SQLException, ClassNotFoundException;
    public void createGameProfile(Game game, Expert expert, String gameLevel, String description) throws SQLException, ClassNotFoundException;
}
