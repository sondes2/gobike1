/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;
import com.codename1.components.ImageViewer;
import com.pi.services.UserSession;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.social.FacebookConnect;
import com.codename1.social.GoogleConnect;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextComponentPassword;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.pi.entities.User;
import com.pi.entities.login;
import com.pi.services.ServiceUsers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ASMA
 */
public class Login extends Form 
{
        Resources theme;

    User userr;
  public Login(){
            try {
                //        getToolbar().hideToolbar();
//        getAllStyles().setBorder(Border.createEmpty());
//        getAllStyles().setBackgroundType(BACKGROUND_NONE);
//        getAllStyles().setBgTransparency(255);
//        getAllStyles().setBgColor(0x0d0d0d);
//
ImageViewer logo = new ImageViewer(Image.createImage("/logo.PNG"));
logo.getImage().scale(700, 700);
setLayout(BoxLayout.xCenter());
Container c=new Container(BoxLayout.yCenter());
Label hk=new Label("Go Bike", getTitle());
//  hk.getAllStyles().setFgColor(0x194C1F);
hk.setAlignment(CENTER);
//        hk.getAllStyles().setMarginBottom(100);
//        hk.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
Label title=new Label("Login", getUIID());
title.setAlignment(CENTER);
Label err=new Label(" ");
err.setAlignment(CENTER);
// err.getAllStyles().setFgColor(0xfe0000);
//        title.getAllStyles().setMarginBottom(20);
//        err.getAllStyles().setMarginBottom(100);
//      TextComponent username = new TextComponent().label("Username");

TextField login = new TextField(null, "Enter your username ! Exp: Admin_Admin", 20, TextField.ANY) ;
login.getAllStyles().setMarginBottom(5);
// TextComponentPassword pass = (TextComponentPassword) new TextComponentPassword().label("Password");
TextField password = new TextField(null, "Enter your password", 20, TextField.PASSWORD) ;
password.getAllStyles().setMarginBottom(5);
//Button login=new Button("Login");
Button loginButton = new Button("LOGIN");
loginButton.getAllStyles().setBorder(Border.createEmpty());
//loginButton.getAllStyles().setBackgroundType(BACKGROUND_NONE);
loginButton.getAllStyles().setBgTransparency(255);
//        loginButton.getAllStyles().setBgColor(0x194C1F);
//        loginButton.getAllStyles().setFgColor(0xd3d3d3);
loginButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        if ((login.getText().length() == 0)) {
            Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
        } else {
            try {
                login l = new login(login.getText(), password.getText());
                userr = ServiceUsers.getInstance().Login(l);
                if (userr != null) {
                    Dialog.show("Success", "Connection accepted", new Command("OK"));
                    
                    
                    new AcceuilEvent(theme).getAcceuilEvent1().show();
                    
                    
                    
                    
                    //ServiceUser.getInstance().current();
                    
                    
                    
                } else {
                    Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            } catch (NumberFormatException e) {
                Dialog.show("ERROR", "Status must be a number", new Command("OK"));
            }
            
        }
        
    }
});
c.addAll(hk,title,err);
c.addAll(logo, login,password,loginButton);
addAll(c);
            } catch (IOException ex) {
                  System.out.println("Error" + ex.getMessage());
            }
    }
}
