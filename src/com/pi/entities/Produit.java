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
public class Produit {
    protected int id;
    protected String libelle;
    protected int qte;
    protected float prix;
    protected String categorie;
    protected String image;
    
    

    public Produit() {
    }

    public Produit(int id, String libelle, int qte, float prix, String categorie, String image) {
        this.id = id;
        this.libelle = libelle;
        this.qte = qte;
        this.prix = prix;
        this.categorie = categorie;
        this.image = image;
    }

    public Produit(String libelle, int qte, float prix, String image) {
        this.libelle = libelle;
        this.qte = qte;
        this.prix = prix;
        this.image = image;
    }
    
    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", libelle=" + libelle + ", qte=" + qte + ", prix=" + prix + ", categorie=" + categorie + ", image=" + image + '}';
    }


   
    
    
}
