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
public class AcceuilEvent {
 
    Form AcceuilEvent1;
    Resources theme;
Database db;
    public AcceuilEvent(Resources theme) {
        
         AcceuilEvent1 = new Form("Home Responsable", new BoxLayout(BoxLayout.Y_AXIS));
//         try {
//             //************************************SQL lite
//            db=Database.openOrCreate("velo");
//                    
//                    db.execute("create table if not exists nbrProd(nbr integer);");
//                    
//                    Cursor c=db.executeQuery("select count(*) from nbrProd");
//                    Row r=c.getRow();
//                    AcceuilEvent1.add(new Label("vous avez ajouté "+r.getInteger(0)+" produit sur cette appareil"));
//                    System.out.println(r.getInteger(0));
//                    db.close();
//                     //************************************SQL lite
//        } catch (Exception e) {
//        }

        Button btnAddEvent = new Button("Add new Reservation");
        btnAddEvent.addActionListener(e -> new AjoutEvent(theme).getAjoutEventI().show());
       
        Button listEvent = new Button("List Reservation");
                listEvent.addActionListener(e -> new ListEvent(theme).show());


       
       AcceuilEvent1.add(btnAddEvent).add(listEvent);

    }

    public Form getAcceuilEvent1() {
        return AcceuilEvent1;
    }

    public void setAcceuilEvent1(Form AcceuilEvent1) {
        this.AcceuilEvent1 = AcceuilEvent1;
    }
    
    
}
