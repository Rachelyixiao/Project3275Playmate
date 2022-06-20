package com.example.project3275playmate.Pojo;

import java.util.Date;

public class TopUp {
    private int TTID;
    private Date date;
    private double amount;
    private int transactionType;
    private static int init = 1001; //自动赋值

    public TopUp(){
        TTID = init++;
    }
    public TopUp(Date date, double amount, int transactionType) {
        this();
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getTTID() {
        return TTID;
    }

    public void setTTID(int TTID) {
        this.TTID = TTID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }
}
