package com.example.project3275playmate.Classes;

public class GameProfile {
    private String description;
    private String GName;
    private String EName;

    public GameProfile(String GName, String EName, String description) {
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

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }
}
