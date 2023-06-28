package com.example.studentskasluzba;

public class admin{

    private String username;
    private String password;
    private boolean admin ;

    public admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.admin = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
