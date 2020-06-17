/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

/**
 *
 * @author ASMA
 */
public class lignecmd {
    
    
    private int id;
    private String quantite;
    private int etat;
    private int produit;
    private int cmd_id;
    private int userid;
  
    

    public lignecmd() {
    }
    
    
    

    public lignecmd(int id, String quantite, int etat, int produit, int cmd_id, int userid) {
        this.id = id;
        this.quantite = quantite;
        this.etat = etat;
        this.produit = produit;
        this.cmd_id = cmd_id;
        this.userid = userid;
    }

    public lignecmd(String quantite, int produit, int userid) {
        this.quantite = quantite;
        this.produit = produit;
        this.userid = userid;
    }

  

    public lignecmd(int produit) {
        this.produit = produit;
    }

    public lignecmd(int produit, int userid) {
        this.produit = produit;
        this.userid = userid;
    }

     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getCmd_id() {
        return cmd_id;
    }

    public void setCmd_id(int cmd_id) {
        this.cmd_id = cmd_id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "lignecmd{" + "id=" + id + ", quantite=" + quantite + ", etat=" + etat + ", produit_id=" + produit + ", cmd_id=" + cmd_id + ", userid=" + userid + '}';
    }

}
