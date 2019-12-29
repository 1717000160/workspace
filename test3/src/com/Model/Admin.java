package com.Model;

public class Admin {
    private int id;
    private String userName;
    private String password;
    private int power;

    public Admin(String userName, String password, int power) {
        this.userName = userName;
        this.password = password;
        this.power = power;
    }

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
