package com.example.project3275playmate.Classes;

public class Customer extends User{

    private double balance = 0;
    public Customer() {
    }

    public Customer(String name, String email, String password, double balance) {
        super(name, email, password);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
