/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
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
import com.codename1.ui.util.Resources;
import com.pi.entities.Produit;
import static com.pi.gui.addPanier.modifbtn;
import static com.pi.gui.addPanier.suppbtn;
import com.pi.services.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASMA
 */
public class ShowList {
    

     Form ShowListI;
     
     public static final String ACCOUNT_SID = "ACb2c9181ec5bcf3aacf2fb2f10af17ed3";
    public static final String AUTH_TOKEN = "bd720de0879bf05a5e7b3e1308eebcc2";
    private String url, url1, url3;
private Image img,img1,img3;
   
//    private TextField chnompub;
       private ImageViewer imgv,imgv1,imgv3;
       private EncodedImage enc,enc1,enc3;
       
       
     public ShowList(Resources res) {
        
        ShowListI = new Form("Product List", new BoxLayout(BoxLayout.Y_AXIS));
        
    ShowListI.getToolbar().addCommandToLeftBar("Back",null, (ActionListener) (ActionEvent evt1) -> {
        new AcceuilAdmin(res).getAcceuilAdminI().show();
//                          new AcceuilAdmin(theme).getF2().show();
                        });
    
    
     ServiceProduit s = new ServiceProduit();

        
//        Toolbar tb = getToolbar();
//        Container topBar = BorderLayout.east(new Label());
//        topBar.add(BorderLayout.SOUTH, new Label("Menu"));
//        topBar.setUIID("SideCommand");
//        tb.addComponentToSideMenu(topBar);
        
         ArrayList<Produit> listTasks = s.getList2();

        for (Produit task : listTasks) {
            Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            url3 = "http://localhost/bicycle/web/produit/uploads/images/" + task.getImage();
            try {
                enc3 = EncodedImage.create("/user.png");
            } catch (IOException ex) {

            }
            img3 = URLImage.createToStorage(enc3, url3, url3, URLImage.RESIZE_SCALE);
            imgv3 = new ImageViewer(img3);
            
              suppbtn = new Button("Delete");
            modifbtn = new Button("Edit");
            suppbtn.addActionListener((e) -> {
                    
                if (s.deleteProd(task.getId())) {
                    new ShowList(res).getShowListI().show();
                      Dialog.show("Succés", "Post deleted", "ok", null);
                }

              
            });

            modifbtn.addActionListener((e) -> {
                new editProd(res,task).getEditForm().show();
//                ModifPub m = new ModifPub(task, theme);
//                m.getF().showmodifbtn();
                                            
            });
//            c.add(b);
           
//            add(c);

          c.add(imgv3);
           c.add(suppbtn);
            c.add(modifbtn);

 

           ShowListI.add(c);

        }}



//    private Toolbar getToolbar() {
//         return null;
//    }

    public Form getShowListI() {
        return ShowListI;
    }

    public void setShowListI(Form ShowListI) {
        this.ShowListI = ShowListI;
    }
     
     
}