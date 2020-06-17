/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import static com.codename1.io.Log.p;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.pi.entities.Produit;
import com.pi.entities.cmd;
import com.pi.entities.lignecmd;
import com.pi.services.ServiceProduit;
import com.pi.services.ServiceUsers;
import com.pi.services.Servicelignecmd;
import java.util.ArrayList;

/**
 *
 * @author ASMA
 */
public class checkout extends Form {
       int ff =ServiceUsers.getInstance().current().getId();

    Servicelignecmd lcs = new Servicelignecmd();
   lignecmd li = new lignecmd();
     public checkout(Form previous) {
        
      Produit p = new Produit();
            p.getId();
            
            
            
        setTitle("Submit your Cart");
        setLayout(BoxLayout.y());
        
        
        
           ArrayList<lignecmd> lstlcp = lcs.getLignesCommandeProduit(ff);

         for (lignecmd lcp : lstlcp) {
      
      
      
        /***********************/
            ServiceProduit ps = new ServiceProduit();

      ArrayList<Produit> p1 = ps.getList2();
  for (Produit pp : p1){
            
               if(lcp.getProduit()== pp.getId()){
                   System.out.println(pp.getPrix());
           
           
               
           // Label l1 = new Label( " " + pp.getLibelle() + ""  );
            
 //   tota int = pp.getPrix() * lcp.getQuantite();
    
    /************/
    
      
      
      
      
      
      
    Label l = new Label( " Your Product name is " + lcp.getProduit() +  " " );
          Label m = new Label( " The Price is" + pp.getPrix() + "" );
        
        
        
         
        TextField tfName = new TextField("","adresse");
        TextField tfStatus= new TextField("", "telephone");
        
    // ArrayList<cmd> cmd  = lcs.getCommande();

//  }
        Button btnValider = new Button("Add Command");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfStatus.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    
               //     float  i = (pp.getPrix() * lcp.getQuantite())+ pp.getPrix());
                    try  {
                        cmd t = new cmd (89, tfName.getText(), (int) pp.getPrix() , tfStatus.getText());
                        if( Servicelignecmd.getInstance().addCmd(t))
                            Dialog.show("Success","Your Order is submitted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(l, m,tfName,tfStatus,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
    }
    
     }
}
     }
}
