/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import static com.codename1.io.Log.p;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.pi.entities.Produit;
import com.pi.entities.User;
import com.pi.entities.lignecmd;
import com.pi.services.ServiceUsers;
import com.pi.services.Servicelignecmd;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASMA
 */
public class DetailsProduit extends Form {
  Form current;

    Form f, form, F2;
    SpanLabel lb;
    private Image img, img1, img3;
    private String url, url1, url3;
    private TextField chnompub;
    private ImageViewer imgv, imgv1, imgv3;
    private EncodedImage enc, enc1, enc3;
    private Image imag;
    public static Button suppbtn, modifbtn,Comment;
    public lignecmd l;
    DetailsProduit(Resources theme, Produit loisir) {
        /*  ServiceLoisir s = new ServiceLoisir();

        //membre p = login.user;
        Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Toolbar tb = getToolbar();
        //Image icon = theme.getImage("icon.png"); 
        Container topBar = BorderLayout.east(new Label());
        topBar.add(BorderLayout.SOUTH, new Label("Menu"));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        Button back = new Button("menu");
        back.addActionListener((e) -> {

            // WalkthruForm w = new WalkthruForm(theme);
            // w.show();
        });

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            AcceuilLoisir a = new AcceuilLoisir(theme);
            a.show();
        });

        tb.addMaterialCommandToSideMenu("Add new Post", FontImage.MATERIAL_SETTINGS, e -> {
            AjoutForm d = new AjoutForm(theme);
            d.getF().show();
        });
        //tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOCK, e -> { login a = new login(theme);
        //   a.show();});
        ArrayList<Loisir> listTasks = s.affiche();
        for (Loisir task : listTasks) {
            Label lbser = new Label();
            Label lbser1 = new Label();
            Label lbser2 = new Label();
           Label Title = new Label("Les details de l'évenement");

            Container F3 = new Container(BoxLayout.y());
           // F3.add(Title);

          
            F3.add(lbser1);
            F3.add(lbser2);
            add(F3);

            System.out.println("imaage");

            ConnectionRequest con = new ConnectionRequest();
          //  ConnectionRequest con2 = new ConnectionRequest();

            String url = "http://127.0.0.1/BlogPidev/web/app_dev.php/api/tasks/find/" + task.getId();
            con.setUrl(url);

            con.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent le) {
                    //                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                     Label nameLabel = new Label("Titre   :   " + task.getTitle());
                      F3.add(nameLabel);

                    url1 = "http://127.0.0.1/BlogPidev/web/uploads/post" + task.getPhoto();

                    try {
                        enc1 = EncodedImage.create("/load.png");
                    } catch (IOException ex) {

                    }
                    img1 = URLImage.createToStorage(enc1, url1, url1, URLImage.RESIZE_SCALE);
                    imgv1 = new ImageViewer(img1);

                    add(imgv1);
                    lbser1.setText("Description  :  " + task.getDescription());
                    // lbser2.setText("Lieu  :   " + li.getLieu());
                }
            });
        }
    }*/
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        Container topBar = BorderLayout.east(new Label());
        topBar.add(BorderLayout.SOUTH, new Label("Menu"));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        Button back = new Button("menu");
        back.addActionListener((e) -> {

            // WalkthruForm w = new WalkthruForm(theme);
            // w.show();
        });

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            listProduit a = new listProduit(theme);
            a.show();
        });

//        tb.addMaterialCommandToSideMenu("Add new Post", FontImage.MATERIAL_SETTINGS, e -> {
//            AjoutForm d = new AjoutForm(theme);
//            d.getF().show();
//        });

        Label titre = new Label("Product Details :");
        add(titre);
        //Creating custom container
        Container element = new Container(BoxLayout.y());
         //element.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        //String url = "http://127.0.0.1/BlogPidev/web/uploads/post"+loisir.getPhoto();
//
//        EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("logo.png").scaled(1000, 1000), false);
//
//        ImageViewer imgCon = new ImageViewer();
//        imgCon.setImage(URLImage.createToStorage(palceHolder, loisir.getImage(), "http://localhost/bicycle/web/produit/uploads/images/" + loisir.getImage()));

        //   imag = URLImage.createToStorage(palceHolder, url, url, URLImage.RESIZE_SCALE);
        
        
      
        
          url3 = "http://localhost/bicycle/web/produit/uploads/images/" + loisir.getImage();
            try {
                enc3 = EncodedImage.create("/user.png");
            } catch (IOException ex) {

            }
            img3 = URLImage.createToStorage(enc3, url3, url3, URLImage.RESIZE_SCALE);
            imgv3 = new ImageViewer(img3);

          element.add(imgv3);
        
        ImageViewer img = new ImageViewer(imag);
        Label nameLabel = new Label("Name : " + loisir.getLibelle());
        Label nameDes = new Label("Price : " + loisir.getPrix());




   TextField tfStatus= new TextField("", "quantite");
        

element.add(tfStatus);



        // element.add(img);
        element.add(nameLabel);
//        element.add(imgCon);
        element.add(nameDes);

        add(element);

       
        
        
        
        
        
        
        
        //element.add(modifbtn);
       


        /*raiting****************/
        Label note = new Label("Like: 5");
        add(note);

        Slider st = new Slider();
        st.setMinValue(0);
        st.setMaxValue(10);
        st.setIncrements(1);
        st.setProgress(5);
        st.setEditable(true);
        add(st);

        Button btn = new Button("Valider");
        add(btn);
        //addActionListener ->button Ki tenzel 
        st.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                note.setText("Like : " + st.getProgress());//To change body of generated methods, choose Tools | Templates.
            }

        });
        
        
       
        //ki  addDataChangedListener ->etharek
        st.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                note.setText("Like : " + st.getProgress());
            }
        });
        //byn valider
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Confirmation", "Did you give  "
                        + st.getProgress() + "for the post " + loisir.getLibelle(), "OK", "ANNULER");
            }
        });
        //detailsForm.showBack();
       
        
        
         Comment = new Button("Add to cart");
          Comment.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                     try  {
                            int ff =ServiceUsers.getInstance().current().getId();

                       // int a = loisir.getId();
                         
                        lignecmd t = new lignecmd( tfStatus.getText() ,loisir.getId() , ff);
                        if( Servicelignecmd.getInstance().addTask(t)){
                           
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                           addPanier b = new addPanier(ff);

//                          b.show() ;
                            System.out.println(loisir.getId());
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                    
                    
                    
                    
//addPanier a = new addPanier(current);
//
//                             a.show()   ;

                }
            });
        element.add(Comment);
        }
     

}

