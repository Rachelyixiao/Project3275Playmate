package com.example.project3275playmate.Classes;

public class Expert extends User{
    private String gender;
    private double rate;
    private double balance;
    private double wage;

    public Expert(String name, String email, String password, String gender, double rate, double balance, double wage) {
        super(name, email, password);
        this.gender = gender;
        this.rate = rate;
        this.balance = balance;
        this.wage = wage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}
