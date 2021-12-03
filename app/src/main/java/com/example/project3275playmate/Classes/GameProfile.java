package com.example.project3275playmate.Classes;

public class GameProfile {
    private String description;
    private String GName;
    private String EName;

    public GameProfile(String description, String GName, String EName) {
        this.description = description;
        this.GName = GName;
        this.EName = EName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
