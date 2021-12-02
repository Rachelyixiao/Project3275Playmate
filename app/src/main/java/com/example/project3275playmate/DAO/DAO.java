package com.example.project3275playmate.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.example.project3275playmate.Classes.*;
import com.example.project3275playmate.DataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAO{
    private static final String TAG = "DAO";
    private final DataBase dbHelper;

    public DAO(Context context) {
        dbHelper = new DataBase(context);
    }

    public void addUser(User user) throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into User(UName, email, password) values(?,?,?)";

        db.execSQL(query, new Object[]{user.getName(), user.getEmail(), user.getPassword()});
        db.close();
    }

    public void addCustomer(User user) throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into Customer(UName, balance) values(?,?)";

        db.execSQL(query, new Object[]{user.getName(), 0});
        db.close();
    }

    public void addExpertAdditionalInfo(User user, String gender, double rating) throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into Expert(UName, gender, rating) values(?,?,?)";
        db.execSQL(query, new Object[]{user.getName(), gender, rating});
        db.close();
    }

    public void edit(User user, String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update user set email=?, password=? where UName = ?";

        db.execSQL(query, new Object[]{user.getEmail(), user.getPassword(), user.getName()});
        db.close();
    }

    public void delete(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "delete from user where UName = ?";
        db.execSQL(query, new Object[]{name});
        db.close();
    }

    public void display() throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from User";
        Cursor cursor = db.rawQuery(query, null);
        User obj1;

        while(cursor.moveToNext()){
            int index = cursor.getColumnIndex("UName");
            String name = cursor.getString(index);
            Log.d(TAG, name);
        }
    }

    public User searchUser(String name) throws SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from User where UName = " + name;

        Cursor c = db.rawQuery(query,null);
        return new User(c.getString(0), c.getString(1), c.getString(2));

    }

    public Game searchGame(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Game where GName = " + name;
        Cursor c = db.rawQuery(query,null);

        if (c.getCount()==0){
            System.out.print("Record not existing");
            c.close();
            return null;
        }
        return new Game(c.getString(0), c.getString(1));
    }

    public void setBalance(Customer customer, double amount) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update customer set balance=? where UName=?";

        db.execSQL(query, new Object[]{customer.getBalance() + amount, customer.getName()});
        db.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)

    public void topUp(Customer customer, Admin admin, TopUp topUp, LocalDate date, String transactionType, double amount)
            throws SQLException, ClassNotFoundException {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into TopUp values(?,?,?,?,?,?)";

        db.execSQL(query, new Object[]{topUp.getTTID(), customer.getName(), admin.getName(),
                    Date.valueOf(String.valueOf(date)), amount, transactionType});
        db.close();
        setBalance(customer, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)

    public void transaction(Customer customer, Expert expert, Admin admin, Transaction transaction, LocalDate date, double hours, double amount)
            throws SQLException, ClassNotFoundException {
        setBalance(customer, -amount);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into transcation values(?,?,?,?,?,?,?)";

        db.execSQL(query, new Object[]{transaction.getTID(), admin.getName(), expert.getName(),customer.getName(),
                Date.valueOf(String.valueOf(date)), hours, amount});
        db.close();
    }


    public void createGameProfile(Game game, Expert expert, String gameLevel, String description) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into GameProfile values(?,?,?,?)";
        db.execSQL(query, new Object[]{game.getGName(), expert.getName(), gameLevel, description});
        db.close();
    }



// Main Methods

    public void searchingUser(String name) throws SQLException, ClassNotFoundException{
        User user1;
        user1 = searchUser(name);
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
        if(name.equals("")){
            display = "Please enter your name.";
            return display;
        }
        if(password.length()<8){
            display = "The password is too short, please retry";
            return display;
        }
        if (!email.contains("@") || !email.contains(".com")){
            display = "The format of email is incorrect, please retry";
            return display;
        }
        try{
            searchUser(name);
            display =  "The name is already occupied, please choose another one.";
            return display;
        }catch (Exception e){
            user = new User(name, email, password);
            display = "Register Successful!";
        }
        addUser(user);
        return display;
    }

    public void login(String name, String password) throws SQLException, ClassNotFoundException{
        User user = searchUser(name);
        if (user==null){
            System.out.println("The user doesn't exist");
        }
        else if (!password.equals(user.getPassword())){
            System.out.println("Password incorrect");
        }

    }

    public void expertAddingInfo(String name, String gender, double rating) throws SQLException, ClassNotFoundException{
        Expert expert;
        expert = (Expert) searchUser(name);

        if(expert==null){
            System.out.println("The user does not exist");
            return;
        }
        addExpertAdditionalInfo(expert, gender, rating);

        System.out.println("Transaction successful!");
    }

    public void editInfo(String name, String password, String newPassword, String newEmail)
            throws SQLException, ClassNotFoundException{
        User user = searchUser(name);

        if((user==null)){
            System.out.println("The user does not exist");
            return;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }

        user = new User(name, newEmail, newPassword);
        edit(user, name);
        System.out.println("Info change successful!");
    }

    public void displaying() throws SQLException, ClassNotFoundException{
        display();
    }

    public void deletingUser(String name, String password) throws SQLException, ClassNotFoundException{
        User user;

        user = searchUser(name);
        if((user==null)){
            System.out.println("The name does not exist");
            return;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }
        delete(name);
        System.out.println("Delete successful!");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void customerTopUp(String cusName, String adminName, String password, String transactionType, double topUpAmount)
            throws SQLException, ClassNotFoundException{
        Customer customer;
        Admin admin;
        TopUp topUp = new TopUp();
        LocalDate date = LocalDate.now();

        customer = (Customer) searchUser(cusName);
        admin = (Admin) searchUser(adminName);

        if((customer==null || admin==null)){
            System.out.println("The user does not exist");
            return;
        }
        if (!customer.getPassword().equals(password)){
            System.out.println("Password incorrect");
            return;
        }

        topUp(customer, admin, topUp, date, transactionType, topUpAmount);
        System.out.println("TopUp successful!");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void transaction(String CusName, String expertName, String adminName, double hours, double amount)
            throws SQLException, ClassNotFoundException{
        LocalDate date = LocalDate.now();
        Transaction tran = new Transaction(date, hours, amount);

        Customer customer; Expert expert; Admin admin;

        customer = (Customer) searchUser(CusName);
        expert = (Expert) searchUser(expertName);
        admin = (Admin) searchUser(adminName);

        if((customer==null || expert==null || admin==null)){
            System.out.println("The user does not exist");
            return;
        }
        transaction(customer, expert, admin, tran, date, hours, amount);

        System.out.println("Transaction successful!");
    }

    public void creatingGameProfile(String expertName, String gameName, String password, String gameLevel, String description)
            throws SQLException, ClassNotFoundException{
        Expert expert; Game game;
        expert = (Expert) searchUser(expertName);
        game = searchGame(gameName);
        if((expert==null || game==null)){
            System.out.println("The expert or game does not exist");
            return;
        }
        if (!password.equals(expert.getPassword())){
            System.out.println("Password incorrect");
            return;
        }
        createGameProfile(game, expert, gameLevel, description);
        System.out.println("Game Profile uploaded successful!");
    }
}
