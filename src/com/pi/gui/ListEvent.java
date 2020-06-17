/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.pi.entities.Produit;
import com.pi.entities.Reservations;
import static com.pi.gui.addPanier.modifbtn;
import static com.pi.gui.addPanier.suppbtn;
import com.pi.services.ServiceEvent;
import com.pi.services.ServiceProduit;
import com.pi.services.ServiceUsers;
import com.pi.services.Servicelignecmd;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASMA
 */
public class ListEvent extends Form {

    public static final String ACCOUNT_SID = "ACb2c9181ec5bcf3aacf2fb2f10af17ed3";
    public static final String AUTH_TOKEN = "bd720de0879bf05a5e7b3e1308eebcc2";
    private String url, url1, url3;
    private Image img, img1, img3;

    private TextField chnompub;
    private ImageViewer imgv, imgv1, imgv3;
    private EncodedImage enc, enc1, enc3;

    public ListEvent(Resources res) {
        ServiceEvent s = new ServiceEvent();
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
//int ff =ServiceUsers.getInstance().current().getId();
        //tb.addMaterialCommandToSideMenu("My Cart", FontImage.MATERIAL_HOME, e -> {
        // addPanier a = new addPanier(ff);
        //  a.show();

        ArrayList<Reservations> listTasks = s.affiche();

        for (Reservations task : listTasks) {
            Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

//                          Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//                        Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Button b = new Button("delete");
            Button a = new Button("update");
           b.addActionListener((e) -> {
                    
                if (s.deleteEvent(task.getIdreservation())) {
                    new ListEvent(res).show();
                      Dialog.show("Succés", "reservation deleted", "ok", null);
                }

              
            });
                    //new DetailsPostForm(resource,e).show();
                    // DetailsProduit a = new DetailsProduit(theme, task);
                    //   a.show();
                
          
//           a.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//
//                }
//            });          
            a.addActionListener((e) -> {
                new editEvent(res,task).getEditEventI().show();
              
//                ModifPub m = new ModifPub(task, theme);
//                m.getF().showmodifbtn();
                                            
            });
//        EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("logo.png").scaled(1000, 1000), false);    
//                      ImageViewer imgCon = new ImageViewer();
//        
//
//        imgCon.setImage(URLImage.createToStorage(palceHolder, task.getImage(),"http://localhost/bicycle/web/produit/uploads/images/"+task.getImage()));
//           System.out.println(p.getId());
            Label date = new Label(task.getDate());
            Label place = new Label(task.getPlace());
            Label bike = new Label(task.getBike());

            c.add(date);
            c.add(place);
            c.add(bike);

//                                     c.add(back);
            //   ct.add(c);
            add(c);
            c.add(b);
            c.add(a);
            
            // c.add(c1);
        }
    }

}
