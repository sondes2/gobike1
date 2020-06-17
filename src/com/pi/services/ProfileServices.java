/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.pi.entities.User;

/**
 *
 * @author ASMA
 */
public class ProfileServices {
    
        public User p;

    public User findProfileByIdUser(Integer id){
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/bicycle/web/app_dev.php/findProfWS/" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            this.p = new User(Integer.parseInt(str));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return p;
    }
}
