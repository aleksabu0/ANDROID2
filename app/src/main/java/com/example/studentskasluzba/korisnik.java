package com.example.studentskasluzba;

public class korisnik {

    private String username;
    private String password;
    private String admin ;
    private int id;
    private static int cntStudent=0;
    public korisnik(String username, String password, String admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        if(this.admin=="Student"){
            this.id=cntStudent;
            cntStudent++;
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAdmin() {
        return admin;
    }
}