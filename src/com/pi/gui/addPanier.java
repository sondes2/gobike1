/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.pi.entities.Produit;
import com.pi.entities.lignecmd;
import com.pi.services.ServiceProduit;
import com.pi.services.Servicelignecmd;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASMA
 */
public class addPanier extends Form {
   
    Servicelignecmd lcs = new Servicelignecmd();
    ServiceProduit ps = new ServiceProduit();
   // private Form f;
    Button btnModif;
    
    Resources theme;
    
    //  Form f, form, F2;
    SpanLabel lb;
    private Image img, img1, img3;
    private String url, url1, url3;
    private TextField chnompub;
    private ImageViewer imgv, imgv1, imgv3;
    private EncodedImage enc, enc1, enc3;
    private Image imag;
    public static Button suppbtn, modifbtn,Comment;
    public lignecmd l;
    public static Integer X =0;
    
    
    
    Form form = new Form(new FlowLayout(Component.CENTER, Component.CENTER));
Form F2 = new Form(BoxLayout.yCenter());
    public addPanier(Integer id) {
        //f = new Form("Lignes de commande");
   Label l = new Label("My Cart");

       // Accordion accr = new Accordion();
        //Container cc = new Container();
        ArrayList<lignecmd> lstlcp = lcs.getLignesCommandeProduit(id);
        ArrayList<Produit> p = ps.getList2();
//        System.out.println(id);
//        System.out.println(lstlcp);

 
 
        for (lignecmd lcp : lstlcp) {
             for (Produit pp : p){
            
//               if(lcp.getProduit()== pp.getId()){
//                   System.out.println(pp.getLibelle());
//           
//              
//                    url3 = "http://localhost/bicycle/web/produit/uploads/images/" + pp.getImage();
//            try {
//                enc3 = EncodedImage.create("/user.png");
//            } catch (IOException ex) {
//
//            }
//            img3 = URLImage.createToStorage(enc3, url3, url3, URLImage.RESIZE_SCALE);
//            imgv3 = new ImageViewer(img3);
//
//          //element.add(imgv3);
//        f.add(imgv3);
//        
//        ImageViewer img = new ImageViewer(imag);
//        Label nameLabel = new Label("Name : " + pp.getLibelle());
//        Label nameDes = new Label("Price : " + pp.getPrix());
//
//                   
//                   f.add(nameLabel);
                   
                // f.add(nameDes);

         //   Label la = new Label( " " + pp.getLibelle() + ""  );
            
           // accr.addContent(l1, new SpanLabel(lcp.getQuantite() + " "));
          
          btnModif = new Button("Checkout");
            
          //  System.out.println("add" + lcp.getAdresse());
btnModif.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            X = 1;
                       checkout acf = new checkout(F2) ;                    
                       acf.show();
                       lcs.deleteLigneWishlist(lcp.getId());
                       
                        }
                    });
             

        
     // accr.add(btnModif); 
   //f.add(btnModif);
        //f.add(BorderLayout.CENTER);
        
        
        
             Container ct1 = new Container(BoxLayout.y());
           
            Container c = new Container(BoxLayout.y());
             if(lcp.getProduit()== pp.getId()){
                   System.out.println(pp.getLibelle());
           
              
                    url3 = "http://localhost/bicycle/web/produit/uploads/images/" + pp.getImage();
            try {
                enc3 = EncodedImage.create("/user.png");
            } catch (IOException ex) {

            }
            img3 = URLImage.createToStorage(enc3, url3, url3, URLImage.RESIZE_SCALE);
            imgv3 = new ImageViewer(img3);

          //element.add(imgv3);
       // c.add(imgv3);
        
//        ImageViewer img = new ImageViewer(imag);
//        Label nameLabel = new Label("Name : " + pp.getLibelle());
//        Label nameDes = new Label("Price : " + pp.getPrix());

//            Label titre = new Label(task.getTitle());
//            Label body = new Label(task.getDescription());
            //    Label conetne = new Label(task.getComments().getContent());
            Label DateAjout = new Label("Name: " + pp.getLibelle());
            //  System.out.println(task.getComments().getContent());
            Label Comments = new Label("Price :" + pp.getPrix());
         
           Button  btnchercher = new Button("Delete From Cart");
           
             btnchercher.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    lcs.deleteLigneWishlist(lcp.getId());
                    addPanier.this.getF2();
                    // f.removeComponent(c);
                    //  Button ok = new Button("vous etes sur?");
                    // c1.replaceAndWait(btnAjout, ok, null);
                    addPanier ijamennadhou9lbenna = new addPanier(id);
                    ijamennadhou9lbenna.getF2().showBack();
                }
            });
           
           
        //f.add(chnompub);
     
       /* btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.xCenter());
           /// String d = chnompub.getText();

            ArrayList<Comment> liche = sc.recherchePost(task.getId());
            System.out.println("nnn" + liche);
            for (Comment lis : liche) {
                 Label aa1 = new Label("Title  : " + lis.getContent());
               c.add(aa1);
            

            }
        });*/
//            c.add(imgCon);
//            // c.add(img);***img serveur 
//            c.add(titre);
//            c.add(body);
            //   c.add(conetne);
            //  c.add(Contenu);
         //  ct1.add(l);
            c.add(imgv3);
            
            c.add(Comments);

          c.add( DateAjout);
          c.add(btnchercher);

          ct1.add(c);
          
           btnModif = new Button("Checkout");
         F2.add(ct1); 
         
             }
             }
             }
        
        
    F2.add(btnModif);

          
 F2.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> new listProduit(theme).showBack());          
        
     F2.show();

         
    }

    public Form getF2() {
        return F2;
    }

    public void setF2(Form F2) {
        this.F2 = F2;
    }
 

  
}
