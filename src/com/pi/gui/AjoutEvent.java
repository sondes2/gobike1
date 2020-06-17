/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.ToastBar;
import com.codename1.db.Database;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.pi.entities.Categorie;
import com.pi.entities.Produit;
import com.pi.entities.Reservations;
import com.pi.services.ServiceCategory;
import com.pi.services.ServiceEvent;
import com.pi.services.ServiceProduit;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

public class AjoutEvent {
    
 public static final String accountSID = "AC121b0f9e3710a25d80aed3c4fb64d5a4";
    public static final String authToken = "3553c60c6bc0d6a1c3b64f1613df9ce2";
      String fromPhone = "+12058097699";
    String vall;
    Date date;
    String place;
    String bike;
   
     MultipartRequest cr = new MultipartRequest();
    //  Resources theme;

    static Reservations rs = new Reservations();
    String imName;
    Form AjoutEventI;
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    ImageViewer l = new ImageViewer();
//    MultipartRequest cr = new MultipartRequest();
    Resources theme;

  
    
    
    Database db;
 String fileName;
    /**
     * *******************************************************Form add
     * product***************************************************
     */
    public AjoutEvent(Resources res) {

        AjoutEventI = new Form("ADD new reservation", new BoxLayout(BoxLayout.Y_AXIS));

Button fbButton = new Button("Share on Facebook");
        ///**
        ShareButton sb = new ShareButton();
        sb.setText("Share ");
        
        //hi.add(sb);
        Image screenshot = Image.createImage(AjoutEventI.getWidth(), AjoutEventI.getHeight());
        AjoutEventI.revalidate();
        AjoutEventI.setVisible(true);
        AjoutEventI.paintComponent(screenshot.getGraphics(), true);
        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
        try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
            ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
        } catch (IOException err) {
            Log.e(err);
        }
        TextComponent tfplace = new TextComponent().label("place:");
        TextComponent tfbike = new TextComponent().label("bike:");//.multiline(true);
        Picker  date1 = new Picker();
                 date1.getAllStyles().setMargin(LEFT, 0);
   //     startDate = new Date();
date1.setType(Display.PICKER_TYPE_DATE);
        /**
         * *******************validateur*********************************
         */
        Validator val = new Validator();
        val.addConstraint(tfplace, new LengthConstraint(20));
        val.addConstraint(tfbike, new LengthConstraint(20));
       

        ///enjareb fi el clavier 
        // Name.putClientProperty("searchField", Boolean.TRUE);
        /**
         * ****************************************Image*****************************************************************
         */
        
      
        /**
         * ************************************************************************************************
         */
        Button submit = new Button("Add reservation");

      
        AjoutEventI.add(date1)
                .add(tfplace)
                .add(tfbike)
                .add(submit)
                .add(sb);
//       hi.setEditOnShow(tflibelle.getField());

        /**
         * ******************************************Back to home
         * admin*************************************
         */
        AjoutEventI.getToolbar().addCommandToLeftBar("Back", null, (ActionListener) (ActionEvent evt1) -> {
            new ListEvent(theme).show();
        });
        /**
         * *************************************************************************************************
         */

        submit.addActionListener((e) -> {

            // String image = path.substring(6);
           
                Reservations p = new Reservations();
                System.out.println(date1.getValue());
                //p.setDate(date1.getDate())
                p.setPlace(tfplace.getText());
                p.setBike(tfbike.getText());
                String url = "http://localhost/bicycle/web/app_dev.php/add/" + p.getDate()+ "/" + p.getPlace()+ "/" + p.getBike(); //création de l'URL

            
                    //***********************************************************************************************SMS sender
                    vall = "la reservation est ajouté avec succées ";
                    String destinationPhone = "+21655281015";
                    Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                            queryParam("To", destinationPhone).
                            queryParam("From", fromPhone).
                            queryParam("Body", vall).
                            basicAuth(accountSID, authToken).
                            getAsJsonMap();
                    new ShowList(res).getShowListI().show();
                    if (result.getResponseData() != null) {
                        String error = (String) result.getResponseData().get("error_message");
                     

                    } else {

                    }
                    //***********************************************************************************************END SMS sernder
                    
                    
                    //*******************************************SQLlite
                    
                    System.out.println("added");
                                        new ListEvent(res).show();


                //         FileUploader fc=new FileUploader("localhost/pidevweb/web/uploads");
                // String f=fc.upload(image);
                //ServiceLoisir ser = new ServiceLoisir();
                //  Loisir t = new Loisir(9, Name.getText(), Desc.getText(), path);
                // ser.ajoutLoisir(t,cr);
           
            if (tfplace.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            } else if (tfbike.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            //            else if (tfcategorie.getText().isEmpty()) {
            //                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            //
            //            
            } 
            else {
                //ServiceLoisir ser = new ServiceLoisir();
                ToastBar.Status status = ToastBar.getInstance().createStatus();
                status.setMessage("reservation added");
                //notification
                // status.setIcon(icon);///bel logo w to93ed 
                status.setExpires(3000);  // only show the status for 3 seconds, then have it automatically clear
                status.show();
//                Message m = new Message("Body of message");
                //Loisir t = new Loisir(9, Name.getText(), Desc.getText(), path);
                //Produit c = new  Produit(); Produit em3abi bel path 
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                ServiceEvent se = new ServiceEvent();
               Reservations r= new Reservations(formatter.format(date1.getValue()), tfplace.getText(), tfbike.getText(),9);
                se.ajoutEvent(r, cr);
            

            }

        });



    }

    public Form getAjoutEventI() {
        return AjoutEventI;
    }

    public void setAjoutEventI(Form AjoutEventI) {
        this.AjoutEventI = AjoutEventI;
    }

  
}
