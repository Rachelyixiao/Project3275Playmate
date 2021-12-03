package com.example.project3275playmate.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.project3275playmate.Classes.*;
import com.example.project3275playmate.DataBase;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAO{
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
        String query = "insert into Customer(CName, balance) values(?,?)";

        db.execSQL(query, new Object[]{user.getName(), 0});
        db.close();
    }

    public void addExpertAdditionalInfo(User user, String gender) throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into Expert(EName, gender, rate, wage, balance) values(?,?,?,?,?)";
        db.execSQL(query, new Object[]{user.getName(), gender, 0, 0, 0});
        db.close();
    }

    public void addGameProfile(String expertName, String gameName, String description) throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into GameProfile(GName, EName, description) values(?,?,?)";
        db.execSQL(query, new Object[]{gameName, expertName, description});
        db.close();
    }

    public void edit(User user, String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update user set email=?, password=? where UName = ?";
        db.execSQL(query, new Object[]{user.getEmail(), user.getPassword(), name});
        db.close();
    }

    public void updateRate(String name, double rate) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update expert set rate=? where EName = ?";

        db.execSQL(query, new Object[]{rate, name});
        db.close();
    }

    public void delete(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "delete from user where UName = ?";
        db.execSQL(query, new Object[]{name});
        db.close();
    }

    public String display() throws ClassNotFoundException, SQLException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from User";
        Cursor cursor = db.rawQuery(query, null);
        String display = "";

        while(cursor.moveToNext()){
            int index = cursor.getColumnIndex("UName");
            String name = cursor.getString(index);
            display += name + "\n";
        }
        return display;
    }

    public  Cursor viewExpertDataByGender(String gender) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM Expert where gender = "+gender;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public boolean checkAdmin(String name)throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Admin where AName = ?";
        Cursor c = db.rawQuery(query,new String[] {name});
        boolean check = false;
        if(c.moveToFirst()){
            @SuppressLint("Range")String AName = c.getString(c.getColumnIndex("AName"));
            check = true;
        }
        return check;
    }

    public User searchUser(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from User where UName = ?";
        Cursor c = db.rawQuery(query,new String[] {name});
        User user = null;
        if(c.moveToFirst()){;
            @SuppressLint("Range")String email = c.getString(c.getColumnIndex("email"));
            @SuppressLint("Range")String password = c.getString(c.getColumnIndex("password"));
            user = new User(name, email, password);
        }
        return user;
    }

    public Expert searchExpert(String name) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Expert where EName = ?";
        Cursor c = db.rawQuery(query, new String[] {name});
        User expert = searchUser(name);
        Expert e = null;
        if(c.moveToFirst()){
            @SuppressLint("Range")String gender = c.getString(c.getColumnIndex("gender"));
            @SuppressLint("Range")double rate = Double.valueOf(c.getString(c.getColumnIndex("rate")));
            @SuppressLint("Range")double wage = Double.valueOf(c.getString(c.getColumnIndex("wage")));
            @SuppressLint("Range")double balance = Double.valueOf(c.getString(c.getColumnIndex("balance")));
            e = new Expert(name, expert.getEmail(), expert.getPassword(), gender, rate, balance, wage);
        }
        return e;
    }

    public Customer searchCus(String name) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Customer where CName = ?";
        Cursor c = db.rawQuery(query, new String[] {name});
        User customer = searchUser(name);
        Customer cus = null;
        if(c.moveToFirst()){
            @SuppressLint("Range")double balance = Double.valueOf(c.getString(c.getColumnIndex("balance")));;
            cus = new Customer(name, customer.getEmail(), customer.getPassword(), balance);
        }
        return cus;
    }

    public Admin searchAdmin(String name) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Admin where AName = ?";
        Cursor c = db.rawQuery(query, new String[] {name});
        Admin admin = null;
        if(c.moveToFirst()){
            @SuppressLint("Range")int id = Integer.valueOf(c.getString(c.getColumnIndex("AID")));
            @SuppressLint("Range")String email = c.getString(c.getColumnIndex("email"));
            @SuppressLint("Range")String password = c.getString(c.getColumnIndex("password"));
            admin = new Admin(id, name, email, password);
        }
        return admin;
    }

    public Game searchGame(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from Game where GName = ?";
        Cursor c = db.rawQuery(query, new String[] {name});
        Game g = null;
        if(c.moveToFirst()){
            @SuppressLint("Range")String type = c.getString(c.getColumnIndex("GType"));;
            g = new Game(name, type);
        }
        return g;
    }

    public void createGameProfile(Game game, Expert expert, String gameLevel, String description) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into GameProfile values(?,?,?,?)";
        db.execSQL(query, new Object[]{game.getGName(), expert.getName(), gameLevel, description});
        db.close();
    }

    public GameProfile[] searchGameProfile(String name) throws SQLException, ClassNotFoundException {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Select * from GameProfile where GName = ?";
        Cursor c = db.rawQuery(query, new String[] {name});
        int length = 0;
        GameProfile gameProfiles[] = new GameProfile[100];

        while (c.moveToNext()){
            @SuppressLint("Range")String GName = c.getString(c.getColumnIndex("GName"));;
            @SuppressLint("Range")String EName = c.getString(c.getColumnIndex("EName"));;
            @SuppressLint("Range")String description = c.getString(c.getColumnIndex("Description"));;
            gameProfiles[length] = new GameProfile(description, GName, EName);
            length++;
        }
        return gameProfiles;
    }

    public void setCusBalance(Customer customer, double amount) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update customer set balance=? where CName=?";
        db.execSQL(query, new Object[]{customer.getBalance() + amount, customer.getName()});
        db.close();
    }

    public void setExpertBalance (Expert expert, double amount) throws SQLException, ClassNotFoundException{
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "Update expert set balance=? where EName=?";
        db.execSQL(query, new Object[]{expert.getBalance() + amount, expert.getName()});
        db.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void topUp(Customer customer, Admin admin, TopUp topUp, LocalDate date, String transactionType, double amount)
            throws SQLException, ClassNotFoundException {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into TopUp values(?,?,?,?,?,?)";
        db.execSQL(query, new Object[]{topUp.getTTID(), Date.valueOf(String.valueOf(date)), amount,
                                        transactionType, customer.getName(), admin.getName()});
        db.close();
        setCusBalance(customer, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void transactions(Customer customer, Expert expert, Admin admin, Transactions transactions, LocalDate date, double hours, double amount)
            throws SQLException, ClassNotFoundException {
        setCusBalance(customer, -amount);
        setExpertBalance(expert, amount);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "insert into transactions values(?,?,?,?,?,?,?)";

        db.execSQL(query, new Object[]{transactions.getTID(), admin.getName(), expert.getName(),customer.getName(),
                Date.valueOf(String.valueOf(date)), hours, amount});
        db.close();
    }




    /**
     * Main methods
     **/
    static int RatingTimes = 0;
    public String searchingUser(String name) throws SQLException, ClassNotFoundException{
        User user = searchUser(name);
        String display;
        if(!(user==null)){
            display = user.getName() + ", " + user.getEmail();
        }
        else{
            display = "There is no such name " + name;
        }
        return display;
    }

    public String register(String name, String email, String password, int choice) throws SQLException, ClassNotFoundException{

        String display;
        User user;
        if(password.length()<8){
            display = "The password is too short, please retry";
            return display;
        }
        if (!email.contains("@") || !email.contains(".com")){
            display = "The format of email is incorrect.";
            return display;
        }
        if (name.equals("")){
            display = "The name cannot be empty.";
            return display;
        }
        if(!(searchUser(name)==null)){
            display = "The name is already occupied, please choose another one.";
            return display;
        }

        user = new User(name, email, password);
        if (choice == 1){
            addUser(user);
            addCustomer(user);
        }
        else {
            addUser(user);
        }
        return "Register Successful!";
    }

    public String login(String name, String password) throws SQLException, ClassNotFoundException{
        User user = searchUser(name);
        if (name.equals("")){
            return "The name cannot be empty";
        }
        if (user==null){
            return "The user doesn't exist";
        }
        else if (!password.equals(user.getPassword())){
            return "Password incorrect";
        }
        else {
            return "Login successful!";
        }
    }

    public String expertAddingInfo(String name, String gender) throws SQLException, ClassNotFoundException{
        User user = searchUser(name);
        addExpertAdditionalInfo(user, gender);
        return "Information added successful!";
    }

    public String expertRating(Expert expert, int rate) throws SQLException, ClassNotFoundException{
        RatingTimes += 1;
        double currentRate = expert.getRate();
        double RateAfter = (currentRate + rate)/RatingTimes;

        updateRate(expert.getName(), RateAfter);
        return "Rating successful!";
    }

    public String expertWithdraw(Expert expert, double withdraw) throws SQLException, ClassNotFoundException{
        if (withdraw == 0){
            return "Withdraw cannot be 0";
        }
        setExpertBalance(expert, -withdraw);
        return "Withdraw successful!";
    }

    public String editInfo(String name, String password, String newPassword, String newEmail)
            throws SQLException, ClassNotFoundException{
        User user = searchUser(name);

        if((user==null)){
            return "The user does not exist";
        }
        if (!user.getPassword().equals(password)){
            return "Password incorrect";
        }
        if (newPassword.length()<8){
            return "The password is too short, please retry";
        }
        if (user.getPassword().equals(newPassword)){
            return "The old and new password cannot be same";
        }
        if (!newEmail.contains("@") || !newEmail.contains(".com")){
            return "The format of email is incorrect.";
        }
        user = new User(name, newEmail, newPassword);
        edit(user, name);
        return "Info change successful!";
    }

    public String displaying() throws SQLException, ClassNotFoundException{
        return display();
    }

    public String deletingUser(String name, String password) throws SQLException, ClassNotFoundException{
        User user;

        user = searchUser(name);
        if (name.equals("")){
            return "The name cannot be empty";
        }
        if((user==null)){
            return "The name does not exist";
        }
        if (!user.getPassword().equals(password)){
            return "Password incorrect";
        }
        delete(name);
        return "Delete successful!";
    }

    public String addingProfile(String UName, String EName, String description) throws SQLException, ClassNotFoundException {
        if (description.equals("")){
            return "Please fill the description of the selected game";
        }
        addGameProfile(UName, EName, description);
        return "Adding Game Profile successful!";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String customerTopUp(String cusName, String adminName, String transactionType, double topUpAmount)
            throws SQLException, ClassNotFoundException{
        Customer customer;
        Admin admin;
        TopUp topUp = new TopUp();
        LocalDate date = LocalDate.now();

        customer = searchCus(cusName);
        if (checkAdmin(adminName) == true){
            admin = searchAdmin(adminName);
        }else{
            return "Admin name incorrect";
        }

        if((customer==null)){
            return "The customer does not exist";
        }
        if (transactionType.equals("")){
            return "Please enter the transactions type";
        }
        if (topUpAmount==0){
            return "The topUp Amount cannot be 0";
        }
        topUp(customer, admin, topUp, date, transactionType, topUpAmount);
        return "TopUp successful!";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String transactions(String CusName, String expertName, String adminName, double hours, double amount)
            throws SQLException, ClassNotFoundException{
        LocalDate date = LocalDate.now();
        if (CusName.equals("") || expertName.equals("") || adminName.equals("")){
            return "Please enter all the names";
        }
        if (hours==0){
            return "hours cannot be 0";
        }
        if (amount==0){
            return  "amount cannot be 0";
        }
        Transactions tran = new Transactions(date, hours, amount);
        Customer customer; Expert expert; Admin admin;
        customer = (Customer) searchUser(CusName);
        expert = (Expert) searchUser(expertName);

        if (checkAdmin(adminName) == false){
            return "Admin name incorrect";
        }
        admin = searchAdmin(adminName);

        if((customer==null || expert==null || admin==null)){
            return "The user does not exist";
        }
        transactions(customer, expert, admin, tran, date, hours, amount);
        return "Transaction successful!";
    }

    public String creatingGameProfile(String expertName, String gameName, String password, String gameLevel, String description)
            throws SQLException, ClassNotFoundException{
        if (expertName.equals("")||gameName.equals("")||password.equals("")||gameLevel.equals("")||description.equals("")){
            return "Please fill all the blanks";
        }
        Expert expert; Game game;
        expert = (Expert) searchUser(expertName);
        game = searchGame(gameName);
        if((expert==null || game==null)){
            return "The expert or game does not exist";
        }
        if (!password.equals(expert.getPassword())){
            return "Password incorrect";
        }
        createGameProfile(game, expert, gameLevel, description);
        return "Game Profile uploaded successful!";
    }

    public boolean updateUserData(String name,String psw,String Email){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", Email);
        values.put("password", psw);
        int d = sqLiteDatabase.update("User", values, "UName=?", new String[]{name});
        return d > 0;
    }
}
