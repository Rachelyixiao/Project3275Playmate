package com.example.project3275playmate.Classes;

import java.time.LocalDate;

public class Transaction {
    private int TID;
    private LocalDate date;
    private double hours;
    private double totalAmount;
    private static int init = 1001; //static自动赋值

    public Transaction() {
        TID = init++;
    }

    public Transaction(LocalDate date, double hours, double totalAmount) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        Transaction.init = init;
    }
}
