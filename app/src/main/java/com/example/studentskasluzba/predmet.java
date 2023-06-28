package com.example.studentskasluzba;




import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aleksa
 */
public class predmet {
    private String imePredmeta;
    private int ocena;
    private int polozeno;
    private ArrayList<String> godina;
    private int izabranaGodina;
    private ArrayList<int[]> osvojeni_bodovi;
    private ArrayList<String[]> kategorije;
    private ArrayList<String[]> bodovi;
    private ArrayList<String[]> bodovi_minimum;

    public predmet(String imePredmeta, String[] kategorije, int[] bodovi, int[] bodovi_minimum) {
        if(kategorije.length!=bodovi.length || kategorije.length!=bodovi_minimum.length){
            System.out.println("Uneti bodove po jednom za svaku od kategorija");
            throw new IllegalArgumentException();
        }
        if(Arrays.stream(bodovi).sum()!=100){
            System.out.println("Ukupan broj bodova mora biti 100");
            throw new IllegalArgumentException();
        }
        for(int i=0;i<bodovi.length;i++){
            if(bodovi[i]<=bodovi_minimum[i]){
                System.out.println("Minimalan broj bodova mora biti manji od ukupnog");
                throw new IllegalArgumentException();
            }
        }
        //int kat_len = kategorije.length;
        this.imePredmeta = imePredmeta;
        /*this.kategorije = kategorije;
        this.bodovi = bodovi;
        this.bodovi_minimum = bodovi_minimum;*/
    }



    public predmet(String imePredmeta){
        this.imePredmeta = imePredmeta;
        this.godina = new ArrayList<String>();
        this.bodovi_minimum = new ArrayList<String[]>();
        this.bodovi = new ArrayList<String[]>();
        this.kategorije = new ArrayList<String[]>();
    }

    public int[] getOsvojeni_bodovi() {
        return osvojeni_bodovi.get(izabranaGodina);
    }

    public void setIzabranaGodina(String izbor) {
        int i=0;

        for(String god:this.godina){
            System.out.println(god);
            if(izbor.equals(god)){
                System.out.println("Pronadjena godina");
                break;
            }
            i++;
        }

        this.izabranaGodina = i;
    }

    public void addGodina(String godina) {
        this.godina.add(godina);
    }
    public void addKat(String kat[]) {
        this.kategorije.add(kat);
    }
    public void addMin(String bod[]) {
        this.bodovi_minimum.add(bod);
    }
    public void addMax(String bod[]) {
        this.bodovi.add(bod);
    }

    public void setOsvojeni_bodovi(int[] osvojeni_bodovi) {
        /*for(int i=0;i<bodovi.get(izabranaGodina).length;i++){
            if(osvojeni_bodovi[i]> bodovi.get(izabranaGodina)[i]){
                System.out.println("Osvojeni bodovi moraju biti manji od maksimalnog broja bodova");
                throw new IllegalArgumentException();
            }
        }
        this.osvojeni_bodovi.set(izabranaGodina,osvojeni_bodovi);*/
    }

    public ArrayList<String> getGodina() {
        return godina;
    }

    public String getImePredmeta() {
        return imePredmeta;
    }

    public int getOcena() {
        return ocena;
    }

    public int getPolozeno() {
        return polozeno;
    }

    public String[] getKategorije() {
        return kategorije.get(izabranaGodina);
    }

    public String[] getBodovi() {
        return bodovi.get(izabranaGodina);
    }

    public String[] getBodovi_minimum() {
        return bodovi_minimum.get(izabranaGodina);
    }



    public void checkIfPolozeno(){
        /*for(int i=0;i<bodovi.get(izabranaGodina).length;i++){
            if(osvojeni_bodovi.get(izabranaGodina)[i]>=bodovi_minimum.get(izabranaGodina)[i]){}
            else{
                polozeno = 0;
                System.out.println("Nije polozeno");
                ocena = 5;
                return;
            }
        }
        if(Arrays.stream(osvojeni_bodovi.get(izabranaGodina)).sum()>51){
            polozeno = 1;
            System.out.println("Polozeno");
            ocena = (Arrays.stream(osvojeni_bodovi.get(izabranaGodina)).sum()-1)/10+1;
        }
        else{
            polozeno = 0;
            ocena = 5;
            System.out.println("Nije polozeno");
        }*/
    }

}

