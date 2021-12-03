package com.example.project3275playmate.Classes;

public class Admin extends User{
    private int AId;;

    public Admin() {
    }

    public Admin(int AId, String name, String email, String password) {
        super(name, email, password);
        this.AId = AId;
    }

    public int getAId() {
        return AId;
    }

    public void setAId(int AId) {
        this.AId = AId;
    }
}
