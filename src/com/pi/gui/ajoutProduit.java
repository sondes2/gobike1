/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.messaging.Message;
import com.codename1.ui.util.Resources;
import com.pi.services.ServiceProduit;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.pi.entities.Produit;
import java.io.IOException;

/**
 *
 * @author ASMA
 */
public class ajoutProduit extends Form {

    String path;
    ImageViewer l = new ImageViewer();
    Container imgCtn;
    private String newfilePath = "";
    ServiceProduit ps = new ServiceProduit();

    public ajoutProduit(Resources res) {
        setTitle("Add a new task");
        setLayout(BoxLayout.y());

//        ImageViewer img1 = new ImageViewer(URLImage.createToStorage(encImage, "file" + pan.getProdImg(),
//                    "http://localhost/SoukLemdina5/web/uploads/images/" + pan.getProdImg()));
        TextField tfName = new TextField("", "libelle");
//        TextField tfimage= new TextField("", "image");
        TextField tfprix = new TextField("", "prix");
        TextField tfqte = new TextField("", "qte");
        //   TextField tfStatus= new TextField("", "Status: 0 - 1");

        Button getimage = new Button("Upload Image");
        getimage.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt != null && evt.getSource() != null) {
                        path = (String) evt.getSource();
                        Image image = null;
                        try {
                            image = Image.createImage(FileSystemStorage.getInstance()
                                    .openInputStream(path)).fill(125, 175);
                        } catch (IOException ex) {
                            Dialog.show("Error", ex.getMessage(), "OK", null);
                        }
                        l = new ImageViewer(image);
                        l.getStyle().setMarginLeft(40);
//                        imgCtn.add(l);
                    }
                }
            }, Display.GALLERY_IMAGE);
        });

        Button submit = new Button("Submit");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button btnValider = new Button("Add Product");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
//                    try {
//                        Produit t = new Produit(tfName.getText(), Integer.parseInt(tfqte.getText()), Float.parseFloat(tfprix.getText()), path);
//                        if (ServiceProduit.getInstance().addProduit(t)) {
//                            Dialog.show("Success", "Connection accepted", new Command("OK"));
//                        } else {
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
//                        }
//                    } catch (NumberFormatException e) {
//                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
//                    }

                }

            }
        });

        addAll(tfName, tfqte, tfprix, btnValider, getimage, submit);

    }

}
