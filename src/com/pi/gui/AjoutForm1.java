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
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
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
import com.pi.services.ServiceCategory;
import com.pi.services.ServiceProduit;
import java.io.IOException;
import java.util.Map;

public class AjoutForm1 {

    private final String categ1 = "Bike";
    private final String categ2 = "Accessory";
    String path;
    String filePath;
    Container imgCtn;
    //  Resources theme;

    static Produit b = new Produit();
    String imName;
    Form AjoutForm1I;
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    ImageViewer l = new ImageViewer();
//    MultipartRequest cr = new MultipartRequest();
    Resources theme;

    String accountSID = "ACb6f7ddd37997b071e786b2e400f6eb63";
    String authToken = "e5cc95898a7db4626eca9938aa36ce06";
    String fromPhone = "+12028901202";
    String vall;
    
    
    
    Database db;
 String fileName;
    /**
     * *******************************************************Form add
     * product***************************************************
     */
    public AjoutForm1(Resources res) {

        AjoutForm1I = new Form("ADD new Product", new BoxLayout(BoxLayout.Y_AXIS));

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
        TextComponent tflibelle = new TextComponent().label("Libelle:");
        TextComponent tfqte = new TextComponent().label("Quantite:");//.multiline(true);
        TextComponent tfprix = new TextComponent().label("Prix:");//.multiline(true);
        TextComponent tfcategorie = new TextComponent().label("categorie:");

        /**
         * *******************validateur*********************************
         */
        Validator val = new Validator();
        val.addConstraint(tflibelle, new LengthConstraint(10));
        val.addConstraint(tfqte, new NumericConstraint(false));
        val.addConstraint(tfprix, new NumericConstraint(false));
        val.addConstraint(tfcategorie, new LengthConstraint(10));

        ///enjareb fi el clavier 
        // Name.putClientProperty("searchField", Boolean.TRUE);
        /**
         * ****************************************Image*****************************************************************
         */
        Button getimage = new Button("Upload Image");
        getimage.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt != null && evt.getSource() != null) {
                        path = (String) evt.getSource();
                        int fileNameIndex = path.lastIndexOf("/")+1 ;
                         fileName = path.substring(fileNameIndex);
                       
                        System.out.println(fileName);
                        Image image = null;
                        try {
                            image = Image.createImage(FileSystemStorage.getInstance()
                                    .openInputStream(path)).fill(125, 175);
                            
                            //imName=image.;
                        } catch (IOException ex) {
                            Dialog.show("Error", ex.getMessage(), "OK", null);
                        }
                        l = new ImageViewer(image);
                        l.getStyle().setMarginLeft(40);
                        imgCtn.add(l);
                    }
                }
            }, Display.GALLERY_IMAGE);
        });

        imgCtn = new Container();
        /**
         * ************************************************************************************************
         */
        Button submit = new Button("Add Product");

        ///**
//        ShareButton sb = new ShareButton();
//        sb.setText("Share Screenshot");
//        
//        //hi.add(sb);
//        Image screenshot = Image.createImage(hi.getWidth(), hi.getHeight());
//        hi.revalidate();
//        hi.setVisible(true);
//        hi.paintComponent(screenshot.getGraphics(), true);
//        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
//        try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
//            ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
//        } catch (IOException err) {
//            Log.e(err);
//        }
        // sb.setImageToShare(imageFile, "image/png");
//        TableLayout.Constraint cn = tl.createConstraint();/////////////////////////////////////////////////////////
//        cn.setHorizontalSpan(spanButton);
//        cn.setHorizontalAlign(Component.RIGHT);
        ComboBox listCat = new ComboBox();
        try {
            for (Categorie c : ServiceCategory.getInstance().allCategories()) {
                listCat.addItem(c.getLibelle());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        AjoutForm1I.add(tflibelle)
                .add(tfqte)
                .add(tfprix)
                //.add(tfcategorie)
                .add(new Label("Categorie"))
                .add(listCat)
                .add(getimage)
                .add(imgCtn)
                .add(submit);
//       hi.setEditOnShow(tflibelle.getField());

        /**
         * ******************************************Back to home
         * admin*************************************
         */
        AjoutForm1I.getToolbar().addCommandToLeftBar("Back", null, (ActionListener) (ActionEvent evt1) -> {
            new AcceuilAdmin(theme).getAcceuilAdminI().show();
        });
        /**
         * *************************************************************************************************
         */

        submit.addActionListener((e) -> {

            // String image = path.substring(6);
            try {
                Produit p = new Produit();
                p.setLibelle(tflibelle.getText());
                p.setPrix(Integer.parseInt(tfprix.getText()));
                p.setQte(Integer.parseInt(tfqte.getText()));
                p.setImage(fileName);
                if (ServiceProduit.getInstance().addProduit(p, listCat.getSelectedItem().toString())) {
                    //***********************************************************************************************SMS sender
                    vall = "le produit" + p.getLibelle() + "est ajouté avec succées";
                    String destinationPhone = "+21655173727";
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
                    
                    db=Database.openOrCreate("velo");
                    
                    db.execute("create table if not exists nbrProd(nbr integer);");
                    
                    db.execute("insert into nbrProd(nbr) values (1);");
                    db.close();
                    
                    
                    System.out.println("added");
                }

                //         FileUploader fc=new FileUploader("localhost/pidevweb/web/uploads");
                // String f=fc.upload(image);
                //ServiceLoisir ser = new ServiceLoisir();
                //  Loisir t = new Loisir(9, Name.getText(), Desc.getText(), path);
                // ser.ajoutLoisir(t,cr);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (tflibelle.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            } else if (tfqte.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            } else if (tfprix.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");

            } //            else if (tfcategorie.getText().isEmpty()) {
            //                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            //
            //            } 
            else {
                //ServiceLoisir ser = new ServiceLoisir();
                ToastBar.Status status = ToastBar.getInstance().createStatus();
                status.setMessage("Product added");
                //notification
                // status.setIcon(icon);///bel logo w to93ed 
                status.setExpires(3000);  // only show the status for 3 seconds, then have it automatically clear
                status.show();
//                Message m = new Message("Body of message");
                //Loisir t = new Loisir(9, Name.getText(), Desc.getText(), path);
                //Produit c = new  Produit(); Produit em3abi bel path 
                ServiceProduit ser = new ServiceProduit();
                //ser.ajoutLoisir(t, cr);
//                ser.addProd(b, con);

            }

        });

    }

    public Form getAjoutForm1I() {
        return AjoutForm1I;
    }

    public void setAjoutForm1I(Form AjoutForm1I) {
        this.AjoutForm1I = AjoutForm1I;
    }

}
