package com.example.project3275playmate.Pojo;

public class Transactions {
    private int TID;
    private String date;
    private double hours;
    private double totalAmount;
    private static int init = 1001; //static自动赋值

    public Transactions() {
        TID = init++;
    }

    public Transactions(String date, double hours, double totalAmount) {
        this();
        this.date = date;
        this.hours = hours;
        this.totalAmount = totalAmount;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        Transactions.init = init;
    }
}
