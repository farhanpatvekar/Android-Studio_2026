package com.example.demo_10_recyclerviewuserproduct;


public class User {
    private int userId;
    private String username;
    private String userCity;

    public User(){
        this.userId = 90;
        this.username = "Abc";
        this.userCity = "Nashik";
    }
    public User(int userId, String username, String userCity) {
        this.userId = userId;
        this.username = username;
        this.userCity = userCity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
