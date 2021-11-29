package com.example.project3275playmate.Classes;

public class Expert extends User{
    private char gender;
    private double rating;
    private int NOT;
    private double wage;

    public Expert(String name, String email, String password, char gender, double rating, int NOT, double wage) {
        super(name, email, password);
        this.gender = gender;
        this.rating = rating;
        this.NOT = NOT;
        this.wage = wage;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNOT() {
        return NOT;
    }

    public void setNOT(int NOT) {
        this.NOT = NOT;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}
