package com.example.project3275playmate.DAO;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.project3275playmate.Classes.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private DAO_Implementation obj;
    Connection con;

    Main() throws SQLException{
        this.con = new Connection();
        this.obj = new DAO_Implementation(con);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Main obj1 = new Main();
        String ans;

    }

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

    public void customerSignUp(String name, String email, String password) throws SQLException, ClassNotFoundException{
        User user = obj.searchUser(name); //检查是否重名
        if(!(user==null)){
            System.out.println("The name is already occupied, please choose another one.");
            return;
        }
        if(password.length()<8){
            System.out.println("The password is too short.");
            return;
        }
        if (email.length()<6){
            System.out.println("The format of email is incorrect.");
            return;
        }
        else{
            System.out.print("SignUp Successful!");
        }

        user = new User(name, email, password);

        if(obj.searchUser(name)==null){
            obj.addCustomer(user);
        }
    }

    public void expertSignUp(String name, String email, String password) throws SQLException, ClassNotFoundException{
        User user = obj.searchUser(name); //检查是否重名
        if(!(user==null)){
            System.out.println("The name is already occupied, please choose another one.");
            return;
        }
        if(password.length()<8){
            System.out.println("The password is too short.");
            return;
        }
        if (email.length()<6){
            System.out.println("The format of email is incorrect.");
            return;
        }
        else{
            System.out.print("SignUp Successful!");
        }

        user = new User(name, email, password);

        if(obj.searchUser(name)==null){
            obj.addExpert(user);
        }
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

    public void expertAddingInfo(String name, String gender, double rating) throws SQLException, ClassNotFoundException{
        Expert expert;
        expert = (Expert) obj.searchUser(name);

        if(expert==null){
            System.out.println("The user does not exist");
            return;
        }
        obj.addExpertAdditionalInfo(expert, gender, rating);

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


