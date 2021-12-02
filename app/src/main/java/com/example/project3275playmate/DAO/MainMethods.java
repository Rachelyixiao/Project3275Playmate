package com.example.project3275playmate.DAO;

import android.os.Build;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import com.example.project3275playmate.Classes.*;
import com.example.project3275playmate.DataBase;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainMethods {
    private DAO obj;

    public void searchingUser(String name) throws SQLException, ClassNotFoundException{
        User user1;
        user1 = obj.searchUser(name);
        if(!(user1==null)){
            System.out.println(user1.getName() + ", " + user1.getEmail());
        }
        else{
            System.out.print("There is no such names" + name);
        }
    }

    public String register(String name, String email, String password) throws SQLException, ClassNotFoundException{

        String display;
        User user;
        if(!(obj.searchUser(name)==null)){
            display =  "The name is already occupied, please choose another one.";
            return display;
        }
        if(password.length()<8){
            display = "The password is too short, please retry";
            return display;
        }
        if (!email.contains("@") || !email.contains(".com")){
            display = "The format of email is incorrect.";
            return display;
        }
        else{
            user = new User(name, email, password);
            display = "Register Successful!";
        }

        obj.addUser(user);
        return display;
    }

    public void login(String name, String password) throws SQLException, ClassNotFoundException{
        User user = obj.searchUser(name);
        if (user==null){
            System.out.println("The user doesn't exist");
        }
        else if (!password.equals(user.getPassword())){
            System.out.println("Password incorrect");
        }

    }

    public void expertAddingInfo(String name, String gender) throws SQLException, ClassNotFoundException{
        Expert expert;
        expert = (Expert) obj.searchUser(name);

        if(expert==null){
            System.out.println("The user does not exist");
            return;
        }
        obj.addExpertAdditionalInfo(expert, gender);

        System.out.println("Transaction successful!");
    }

    public void editInfo(String name, String password, String newPassword, String newEmail)
            throws SQLException, ClassNotFoundException{
        User user = obj.searchUser(name);

        if((user==null)){
            System.out.println("The user does not exist");
            return;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }

        user = new User(name, newEmail, newPassword);
        obj.edit(user, name);
        System.out.println("Info change successful!");
    }

    public void displaying() throws SQLException, ClassNotFoundException{
        obj.display();
    }

    public void deletingUser(String name, String password) throws SQLException, ClassNotFoundException{
        User user;

        user = obj.searchUser(name);
        if((user==null)){
            System.out.println("The name does not exist");
            return;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }
        obj.delete(name);
        System.out.println("Delete successful!");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void customerTopUp(String cusName, String adminName, String password, String transactionType, double topUpAmount)
            throws SQLException, ClassNotFoundException{
        Customer customer;
        Admin admin;
        TopUp topUp = new TopUp();
        LocalDate date = LocalDate.now();

        customer = (Customer) obj.searchUser(cusName);
        admin = (Admin) obj.searchUser(adminName);

        if((customer==null || admin==null)){
            System.out.println("The user does not exist");
            return;
        }
        if (!customer.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }

        obj.topUp(customer, admin, topUp, date, transactionType, topUpAmount);
        System.out.println("TopUp successful!");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void transaction(String CusName, String expertName, String adminName, double hours, double amount)
            throws SQLException, ClassNotFoundException{
        LocalDate date = LocalDate.now();
        Transaction tran = new Transaction(date, hours, amount);

        Customer customer; Expert expert; Admin admin;

        customer = (Customer) obj.searchUser(CusName);
        expert = (Expert) obj.searchUser(expertName);
        admin = (Admin) obj.searchUser(adminName);

        if((customer==null || expert==null || admin==null)){
            System.out.println("The user does not exist");
            return;
        }
        obj.transaction(customer, expert, admin, tran, date, hours, amount);

        System.out.println("Transaction successful!");
    }

    public void creatingGameProfile(String expertName, String gameName, String password, String gameLevel, String description)
            throws SQLException, ClassNotFoundException{
        Expert expert; Game game;
        expert = (Expert) obj.searchUser(expertName);
        game = obj.searchGame(gameName);
        if((expert==null || game==null)){
            System.out.println("The expert or game does not exist");
            return;
        }
        if (!password.equals(expert.getPassword())){
            System.out.println("Password incorrect");
            return;
        }
        obj.createGameProfile(game, expert, gameLevel, description);
        System.out.println("Game Profile uploaded successful!");
    }
}


