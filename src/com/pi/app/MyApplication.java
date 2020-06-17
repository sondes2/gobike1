package com.pi.app;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.pi.gui.AcceuilAdmin;
import com.pi.gui.AcceuilEvent;
import com.pi.gui.AjoutEvent;
import com.pi.gui.AjoutForm1;


import com.pi.gui.DetailsProduit;
import com.pi.gui.HomeForm;
import com.pi.gui.List;
import com.pi.gui.ListEvent;
import com.pi.gui.Login;
import com.pi.gui.ajoutProduit;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
  if(current != null){
            current.show();
            return;
        }
//        Ajoutereve e = new Ajoutereve();
//        testaff e = new testaff(res);
//        e.getF().show();


  Login login = new Login();
   login.show();

//ajoutProduit a = new ajoutProduit(theme);
//a.show();

//AjoutForm a = new  AjoutForm(theme);
//a.getF().show();

//        AjoutForm1 a = new  AjoutForm1(theme);
//a.getF1().show();
//
//AcceuilAdmin b = new  AcceuilAdmin(theme);
//b.getAcceuilAdminI().show();
//AcceuilEvent b = new  AcceuilEvent(theme);
//b.getAcceuilEvent1().show();
   
  //  ListEvent b = new  ListEvent(theme);
//    AjoutEvent a = new  AjoutEvent(theme);
//a.getAjoutEventI().show();
//   
    }
    
    
    public void destroy() {
    }

}
