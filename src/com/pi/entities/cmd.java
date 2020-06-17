/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

import java.util.Objects;

/**
 *
 * @author ASMA
 */
public class cmd {
    
  private int id;
 private String adresse;
 private int prix;
private String telephone;
private lignecmd lignecmds;

    public cmd() {
    }

    public cmd(int id, String adresse, int prix, String telephone, lignecmd lignecmds) {
        this.id = id;
        this.adresse = adresse;
        this.prix = prix;
        this.telephone = telephone;
        this.lignecmds = lignecmds;
    }

    public cmd(int id, String adresse, int prix, String telephone) {
        this.id = id;
        this.adresse = adresse;
        this.prix = prix;
        this.telephone = telephone;
    }

    public cmd(String adresse, int prix, String telephone) {
        this.adresse = adresse;
        this.prix = prix;
        this.telephone = telephone;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public lignecmd getLignecmds() {
        return lignecmds;
    }

    public void setLignecmds(lignecmd lignecmds) {
        this.lignecmds = lignecmds;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.adresse);
        //hash = 89 * hash + this.telephone;
        hash = 89 * hash + Objects.hashCode(this.lignecmds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cmd other = (cmd) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.telephone != other.telephone) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.lignecmds, other.lignecmds)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cmd{" + "id=" + id + ", adresse=" + adresse + ", prix=" + prix + ", telephone=" + telephone + ", lignecmds=" + lignecmds + '}';
    }
    



}
