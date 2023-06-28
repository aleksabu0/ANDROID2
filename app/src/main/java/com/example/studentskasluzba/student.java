package com.example.studentskasluzba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aleksa
 */
public class student{
    private String indeks;
    private String ime;
    private String prezime;
    private String jmbg;
    private ArrayList<String> predmeti;

    private ArrayList<int[]> osvBodovi;
    private ArrayList<String> godina;
    private String user;

    private ArrayList<String> polozeno;
    //private int[] brojKategorija;

    public student(String ime, String prezime, String jmbg, String indeks, String user) {
        /*if(!isIndeksValid(indeks)){
            System.out.println("Indeks mora biti u formatu E/e - 1/2/3");
            throw new IllegalArgumentException();
        }
        if(!isJmbgValid(jmbg)){
            System.out.println("Los format za JMBG");
            throw new IllegalArgumentException();
        }*/
        this.indeks = indeks;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.user=user;
        this.predmeti=new ArrayList<String>();
        this.godina=new ArrayList<String>();
        this.osvBodovi= new ArrayList<>();
        this.polozeno=new ArrayList<String>();
        //this.brojKategorija=new int[20];
    }

    public String getIndeks() {
        return indeks;
    }

    public String getGodina(int i) {
        return godina.get(i);
    }

    public ArrayList<String> getGodina() {
        return godina;
    }

    public int[] getOsvBodovi(int ind) {
        return osvBodovi.get(ind);
    }

    public ArrayList<int[]> getOsvBodovi() {
        return osvBodovi;
    }

    public int getOcena(int i) {
        int ocena=5;
        int osvBodoviUkupno=0;
        osvBodoviUkupno+= Arrays.stream(osvBodovi.get(i)).sum();
        System.out.println(osvBodoviUkupno);
        if(osvBodoviUkupno>50){
            ocena=6;
        }
        if(osvBodoviUkupno>60){
            ocena=7;
        }
        if(osvBodoviUkupno>70){
            ocena=8;
        }
        if(osvBodoviUkupno>80){
            ocena=9;
        }
        if(osvBodoviUkupno>90){
            ocena=10;
        }
        System.out.println(ocena);
        return ocena;
    }

   /* public void setBrojKategorija(int brojKat,int i) {
        this.brojKategorija[i]=brojKat;
    }*/

    public void addPolozeno() {
        int cnt;
        System.out.println("trazi predmet da li je polozen");
        for(predmet p1:MainActivity.predmeti){
            cnt=0;
            for(String p2:this.predmeti) {
                if (p1.getImePredmeta().equals(p2)){
                    System.out.println("nadjen predmet " + p2);
                    if(Arrays.stream(osvBodovi.get(cnt)).sum()>50){
                        System.out.println("Ima dovoljno bodova");
                        if(p1.getBodovi_minimum()[0]!=null){

                            System.out.println("osv bodovi 1 "+osvBodovi.get(cnt)[0]);
                            System.out.println("min bodovi 1 "+p1.getBodovi_minimum()[0]);

                            if(osvBodovi.get(cnt)[0] < Integer.parseInt(p1.getBodovi_minimum()[0])){
                                System.out.println("Nema dovoljno poena iz prve kategorije");
                                polozeno.add("Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[1]!=null){
                            if(osvBodovi.get(cnt)[1] < Integer.parseInt(p1.getBodovi_minimum()[1])){
                                System.out.println("Nema dovoljno poena iz druge kategorije");
                                polozeno.add("Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[2]!=null){
                            if(osvBodovi.get(cnt)[2] < Integer.parseInt(p1.getBodovi_minimum()[2])){
                                System.out.println("Nema dovoljno poena iz trece kategorije");
                                polozeno.add("Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[3]!=null){
                            if(osvBodovi.get(cnt)[3] < Integer.parseInt(p1.getBodovi_minimum()[3])){
                                System.out.println("Nema dovoljno poena iz cetvrte kategorije");
                                polozeno.add("Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[4]!=null){
                            if(osvBodovi.get(cnt)[4] <Integer.parseInt(p1.getBodovi_minimum()[4])){
                                System.out.println("Nema dovoljno poena iz pete kategorije");
                                polozeno.add("Nije polozen");
                                break;
                            }
                        }
                        polozeno.add("Polozen");
                    }
                    else{
                        System.out.println("Nema dovoljno bodova");
                        polozeno.add("Nije polozen");
                    }
                }
                cnt++;
            }
        }
    }

    public void addPolozeno(int ind) {
        int cnt;
        System.out.println("trazi predmet da li je polozen");
        for(predmet p1:MainActivity.predmeti){
            cnt=0;
            for(String p2:this.predmeti) {
                if (p1.getImePredmeta().equals(p2)){
                    System.out.println("nadjen predmet " + p2);
                    if(Arrays.stream(osvBodovi.get(cnt)).sum()>50){
                        System.out.println("Ima dovoljno bodova");
                        if(p1.getBodovi_minimum()[0]!=null){

                            System.out.println("osv bodovi 1 "+osvBodovi.get(cnt)[0]);
                            System.out.println("min bodovi 1 "+p1.getBodovi_minimum()[0]);

                            if(osvBodovi.get(cnt)[0] < Integer.parseInt(p1.getBodovi_minimum()[0])){
                                System.out.println("Nema dovoljno poena iz prve kategorije");
                                polozeno.add(ind,"Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[1]!=null){
                            if(osvBodovi.get(cnt)[1] < Integer.parseInt(p1.getBodovi_minimum()[1])){
                                System.out.println("Nema dovoljno poena iz druge kategorije");
                                polozeno.add(ind,"Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[2]!=null){
                            if(osvBodovi.get(cnt)[2] < Integer.parseInt(p1.getBodovi_minimum()[2])){
                                System.out.println("Nema dovoljno poena iz trece kategorije");
                                polozeno.add(ind,"Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[3]!=null){
                            if(osvBodovi.get(cnt)[3] < Integer.parseInt(p1.getBodovi_minimum()[3])){
                                System.out.println("Nema dovoljno poena iz cetvrte kategorije");
                                polozeno.add(ind,"Nije polozen");
                                break;
                            }
                        }
                        if(p1.getBodovi_minimum()[4]!=null){
                            if(osvBodovi.get(cnt)[4] <Integer.parseInt(p1.getBodovi_minimum()[4])){
                                System.out.println("Nema dovoljno poena iz pete kategorije");
                                polozeno.add(ind,"Nije polozen");
                                break;
                            }
                        }
                        polozeno.add(ind,"Polozen");
                    }
                    else{
                        System.out.println("Nema dovoljno bodova");
                        polozeno.add(ind,"Nije polozen");
                    }
                }
                cnt++;
            }
        }
    }

    public String getPolozeno(int i){
        return polozeno.get(i);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        if(!isJmbgValid(jmbg)){
            System.out.println("Los format za JMBG");
            throw new IllegalArgumentException();
        }
        this.jmbg = jmbg;
    }


    public ArrayList<String> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(ArrayList<String> predmeti) {
        this.predmeti = predmeti;
    }

    public void addPredmet(String p1) {
        this.predmeti.add(p1);
    }
    public void addGodina(String god) {
        this.godina.add(god);
    }

    public void addBodovi(int bod[]) {
        this.osvBodovi.add(bod);
    }

    public void addBodovi(int ind, int bod[]) {
        this.osvBodovi.add(ind, bod);
    }

    public void removeBodovi(int ind) {this.osvBodovi.remove(ind);}

    public void removePolozeno(int ind) {this.polozeno.remove(ind);}

    private boolean isIndeksValid(String indeks) {
        System.out.println(indeks);
        //return Pattern.matches("[0-9]", indeks);
        return Pattern.matches("[eE][1-3][\\-\\/]([2][0]([0-1][0-9]|[2][0-3]))", indeks);
    }

    private boolean isJmbgValid(String jmbg) {
        return Pattern.matches("([0][1-9]|[12][0-9]|3[01])([0][1-9]|[1][012])([0-9][0-9][0-9][0-9][0-9][0-9])([9][5-9][0-9]|[0][0][0-9])", jmbg);
    }
}
