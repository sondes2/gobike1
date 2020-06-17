/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;


/**
 *
 * @author GHAITH
 */
public class Reservations {
    


 protected int idreservation ;
 public String date  ;
    protected String place ;
 protected String bike ;
 protected int Iduser ;

    public Reservations() {
    }

    public Reservations(int idreservation, String date, String place, String bike, int Iduser) {
        this.idreservation = idreservation;
        this.date = date;
        this.place = place;
        this.bike = bike;
        this.Iduser = Iduser;
    }

    public Reservations(String date, String place, String bike, int Iduser) {
        this.date = date;
        this.place = place;
        this.bike = bike;
        this.Iduser = Iduser;
    }

    public Reservations(String place, String bike, int Iduser) {
        this.place = place;
        this.bike = bike;
        this.Iduser = Iduser;
    }

   

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBike() {
        return bike;
    }

    public void setBike(String bike) {
        this.bike = bike;
    }

    public int getIduser() {
        return Iduser;
    }

    public void setIduser(int Iduser) {
        this.Iduser = Iduser;
    }
 
}
