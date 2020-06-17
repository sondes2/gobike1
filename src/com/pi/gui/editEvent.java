/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.db.Database;
import com.codename1.io.FileSystemStorage;
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
import java.util.Date;
import java.util.Map;

public class editEvent {

    Date date;
    String place;
    String bike;

    MultipartRequest cr = new MultipartRequest();
    //  Resources theme;

    static Reservations rs = new Reservations();
    String imName;
    Form EditEventI;
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    ImageViewer l = new ImageViewer();
//    MultipartRequest cr = new MultipartRequest();
    Resources theme;

    String vall;

    Database db;
    String fileName;

    /**
     * *******************************************************Form add
     * product***************************************************
     */
    public editEvent(Resources res,Reservations p) {

        EditEventI = new Form("Update ", new BoxLayout(BoxLayout.Y_AXIS));

//        hi.setScrollVisible(true);
//        hi.setSmoothScrolling(true);
//        TableLayout tl;////////////////////////////////////////////////////////////
//        int spanButton = 2;
//        if (Display.getInstance().isTablet()) {
//            tl = new TableLayout(7, 2);
//        } else {
//            tl = new TableLayout(14, 1);
//            spanButton = 1;
//        }
//        tl.setGrowHorizontally(true);
//        hi.setLayout(tl);
//      TextField tflibelle= new TextField("", "libelle");
//         TextField tfqte = new TextField("", "Quantite");
//        TextField tfprix = new TextField("", "Price");
        TextComponent tfplace = new TextComponent().label("place:");
        TextComponent tfbike = new TextComponent().label("bike:");//.multiline(true);
        Picker date1 = new Picker();
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
        Button submit = new Button("update reservation");

        EditEventI.add(date1)
                .add(tfplace)
                .add(tfbike)
                .add(submit);
//       hi.setEditOnShow(tflibelle.getField());

        /**
         * ******************************************Back to home
         * admin*************************************
         */
        EditEventI.getToolbar().addCommandToLeftBar("Back", null, (ActionListener) (ActionEvent evt1) -> {
            new ListEvent(theme).show();
        });
        /**
         * *************************************************************************************************
         */

        submit.addActionListener((e) -> {

            
                try {
                  //  Reservations p = new Reservations();
                    System.out.println(date1.getValue());
                    p.setPlace(tfplace.getText());
                    p.setBike(tfbike.getText());

                    if (ServiceEvent.getInstance().updateEvent(p)) {
                        new ListEvent(res).show();
                        System.out.println("updated");
                    } else {
                        
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                // String image = path.substring(6);
                //p.setDate(date1.getDate())
                //***********************************************************************************************END SMS sernder
                //*******************************************SQLlite
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
                } else {
                    //ServiceLoisir ser = new ServiceLoisir();
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("reservation updated");
                    //notification
                    // status.setIcon(icon);///bel logo w to93ed
                    status.setExpires(3000);  // only show the status for 3 seconds, then have it automatically clear
                    status.show();
                   // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    ServiceEvent se = new ServiceEvent();
                    //Reservations r = new Reservations(formatter.format(date1.getValue()), tfplace.getText(), tfbike.getText(), 9);
                 //   se.updateEvent(rs);

                }
            
        });

    }

    public Form getEditEventI() {
        return EditEventI;
    }

    public void setEditEventI(Form EditEventI) {
        this.EditEventI = EditEventI;
    }

}
