///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pi.gui;
//
//import com.codename1.ui.Button;
//import com.codename1.ui.ComboBox;
//import com.codename1.ui.Container;
//import com.codename1.ui.Dialog;
//import com.codename1.ui.Form;
//import com.codename1.ui.Label;
//import com.codename1.ui.TextArea;
//import com.codename1.ui.TextField;
//import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.plaf.UIManager;
//import com.codename1.ui.util.Resources;
//import com.pi.entities.Produit;
//import com.pi.entities.lignecmd;
//import com.pi.services.Servicelignecmd;
//import java.util.ArrayList;
//
///**
// *
// * @author ASMA
// */
//public class ajoutLigne {
//    
//    protected Form hi;
//    protected Resources theme;
//    
//      public ajoutLigne() {
//        theme = UIManager.initFirstTheme("/theme");
//        hi = new Form("Best Pets");
//    
//       this.hi.setTitle("ajouter Annonce Adoption");
//        Label ltype = new Label("choisir le type de l'annonce");
//        String[] lesTYpes = {"Donner temporairement votre animal","donner définitivement votre animal"};
//        ComboBox type = new ComboBox();
//        for (int i = 0; i < 2; i++) {
//            type.addItem(lesTYpes[i]);
//            
//        }
//        Label llieu = new Label("lieu");
//        TextField   lieu = new TextField("","ajouter l'adresse");
//        Label lanimal = new Label("choisir votre animal");
//        
//        ComboBox  cmb = new ComboBox<>();
//              
//        
//       ArrayList<Produit> anim = new ArrayList<>();
//
////        
////       Servicelignecmd ad = new Servicelignecmd();
////        anim.addAll(ad.getLignesWishlistProduit());
//        
//        for (Produit object : anim) {
//            cmb.addItem(object.getId());
//        }
//        Label ldescription = new Label("ajouter une description");
//        TextField description = new TextField("","",12,TextArea.ANY);
//        
//        Button ButtonAjout = new Button("ajouter");
//
//        ButtonAjout.addActionListener((evt) -> {
//            Produit a = anim.get(cmb.getSelectedIndex());
//            lignecmd adoption = new lignecmd(a, 88);
//             Dialog.show("felicitation", " votre annonce d'adoption est Ajouter", "ok", null);
//             
//             Servicelignecmd as = new Servicelignecmd();
//             as.AjouterAdoption(adoption);
//            addPanier h = new addPanier(hi);
//            h.getHi().show();
//            
//        });
//        Container c = new Container(BoxLayout.y());
//        c.add(ltype);
//        c.add(type);
//        c.add(llieu);
//        c.add(lieu);
//        c.add(ldescription);
//        c.add(description);
//        c.add(lanimal);
//        c.add(cmb);
//        c.add(ButtonAjout);
//        
//        hi.add(c);
//        
//        
//        
//        
//        
//    }
//
//    public Form getHi() {
//        return hi;
//    }
//
//    public void setHi(Form hi) {
//        this.hi = hi;
//    }
//    
//}
//
//    
//
