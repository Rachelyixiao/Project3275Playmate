package com.example.project3275playmate.Pojo;

public class Game {
    private String GName;
    private String GType;

    public Game(String GName, String GType) {
        this.GName = GName;
        this.GType = GType;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getGType() {
        return GType;
    }

    public void setGType(String GType) {
        this.GType = GType;
    }
}
