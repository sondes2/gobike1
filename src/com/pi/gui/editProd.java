/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.pi.entities.Categorie;
import com.pi.entities.Produit;
import com.pi.services.ServiceCategory;
import com.pi.services.ServiceProduit;
import java.io.IOException;

/**
 *
 * @author Siwar
 */
public class editProd {

 private final String categ1 = "Bike";
    private final String categ2 = "Accessory";
    String path;
    String filePath;
    Container imgCtn;
    //  Resources theme;

    static Produit b = new Produit();
    String imName;
    Form editForm;
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    ImageViewer l = new ImageViewer();
//    MultipartRequest cr = new MultipartRequest();
    Resources theme;
    
    
    
    public editProd(Resources res,Produit p) {
        editForm = new Form("Update  Product", new BoxLayout(BoxLayout.Y_AXIS));


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
                        int fileNameIndex=path.lastIndexOf("/")+1;
                        String fileName=path.substring(fileNameIndex);
                        System.out.println(fileName);
                        Image image = null;
                        try {
                            image = Image.createImage(FileSystemStorage.getInstance()
                                    .openInputStream(path)).fill(125, 175);
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
        ComboBox listCat=new ComboBox();
        try {
            for(Categorie c:ServiceCategory.getInstance().allCategories()){
            listCat.addItem(c.getLibelle());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /**
         * ************************************************************************************************
         */
        Button submit = new Button("update Product:   "+p.getLibelle());
           
            tflibelle.getField().setText(p.getLibelle());
            tfqte.getField().setText(String.valueOf(p.getQte()));
            tfprix.getField().setText(String.valueOf(p.getPrix()));
            tfcategorie.getField().setText(p.getCategorie());
            
            
        editForm.add(tflibelle)
                .add(tfqte)
                .add(tfprix)
               // .add(tfcategorie)
                .add(new Label("Categorie"))
                .add(listCat)
                .add(getimage)
                .add(imgCtn)
                .add(submit);


        /**
         * ******************************************Back to home admin*************************************
         */
        editForm.getToolbar().addCommandToLeftBar("Back", null, (ActionListener) (ActionEvent evt1) -> {
            new AcceuilAdmin(theme).getAcceuilAdminI().show();
        });
        /**
         * *************************************************************************************************
         */

        submit.addActionListener((e) -> {


            
            try {
            //    Produit pp=new Produit();
                p.setLibelle(tflibelle.getText());
                p.setPrix(Integer.parseInt(tfprix.getText()));
                p.setQte(Integer.parseInt(tfqte.getText()));
                p.setImage(null);
                if (ServiceProduit.getInstance().updateProduit(p,listCat.getSelectedItem().toString())) {
                System.out.println("updated");
                    
                }
      
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (tflibelle.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            } else if (tfqte.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");
            } else if (tfprix.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");

            }else if (tfcategorie.getText().isEmpty()) {
                Dialog.show("Error", "Please complete all fields", "OK", "CANCEL");

            } else {
                ToastBar.Status status = ToastBar.getInstance().createStatus();
                status.setMessage("Product updated");
                status.setExpires(3000); 
                status.show();
                ServiceProduit ser = new ServiceProduit();
            }

        });

    }

    public Form getEditForm() {
        return editForm;
    }

    public void setEditForm(Form editForm) {
        this.editForm = editForm;
    }
    
    
    
    }
    

