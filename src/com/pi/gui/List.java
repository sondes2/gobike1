/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

/**
 *
 * @author ASMA
 */


import com.pi.entities.lignecmd;
//import com.mycompany.Service.ServiceLoisir;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.pi.services.Servicelignecmd;
//import com.mycompany.Entite.membre;
import java.io.IOException;
import java.util.ArrayList;

public class List extends Form  {
             
       Form current;
      private EncodedImage placeHolder;
    public List(  Form previous) {
        Servicelignecmd s = new Servicelignecmd ();

   
  setTitle("List tasks");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(Servicelignecmd.getInstance().getLignesWishlistProduit(TOP).toString());
        add(sp);
    }            //Label adresse= new Label(task.getAdresse());
            // c2.add(btn);
            // c2.add(btn2);

           
            // c.add(c2);
            //c.add(back);

            //   ct.add(c);
      

    }



