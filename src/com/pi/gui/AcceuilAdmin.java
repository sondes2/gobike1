/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.pi.gui.AcceuilAdmin;

/**
 *
 * @author ASMA
 */
public class AcceuilAdmin {
 
    Form AcceuilAdminI;
    Resources theme;
Database db;
    public AcceuilAdmin(Resources theme) {
        
         AcceuilAdminI = new Form("Home Responsable", new BoxLayout(BoxLayout.Y_AXIS));
         try {
             //************************************SQL lite
            db=Database.openOrCreate("velo");
                    
                    db.execute("create table if not exists nbrProd(nbr integer);");
                    
                    Cursor c=db.executeQuery("select count(*) from nbrProd");
                    Row r=c.getRow();
                    AcceuilAdminI.add(new Label("vous avez ajouté "+r.getInteger(0)+" produit sur cette appareil"));
                    System.out.println(r.getInteger(0));
                    db.close();
                     //************************************SQL lite
        } catch (Exception e) {
        }

        Button btnAddProd = new Button("Add new product");
        btnAddProd.addActionListener(e -> new AjoutForm1(theme).getAjoutForm1I().show());
       
        Button listProd = new Button("List product");
                listProd.addActionListener(e -> new ShowList(theme).getShowListI().show());


       
       AcceuilAdminI.add(btnAddProd).add(listProd);

    }
     public Form getAcceuilAdminI() {
        return AcceuilAdminI;
    }

    public void setAcceuilAdminI(Form AcceuilAdminI) {
        this.AcceuilAdminI = AcceuilAdminI;
    }

    
}
