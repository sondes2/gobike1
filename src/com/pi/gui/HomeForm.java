/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author ASMA
 */
public class HomeForm extends Form {
    Form current;
  public Resources resource;    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    Resources theme;
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Event");
        Button btnListTasks = new Button("Orders");
        Button produit = new Button("List product");

        btnAddTask.addActionListener(e -> new List(current).show());
        btnListTasks.addActionListener(e -> new ListCmd(current).show());
        produit.addActionListener(e -> new listProduit(theme).show());
       
        addAll(btnAddTask, btnListTasks, produit);

    }
    
}
