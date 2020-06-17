/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.pi.entities.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Siwar
 */
public class ServiceCategory {
    
     private ConnectionRequest req;
    public static ServiceCategory instance=null;
    private ArrayList<Categorie> categories;
    
     public ServiceCategory(){
        req=new ConnectionRequest();
    }

    public static ServiceCategory getInstance(){
        if(instance==null)
            instance=new ServiceCategory();
        return instance;
    }

    
        public ArrayList<Categorie> parseCategory(String jsonText){
        categories=new ArrayList<>();
        JSONParser j=new JSONParser();
        try {

            Map<String,Object> productsListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list=(List<Map<String, Object>>)productsListJson.get("root");
            for (Map<String,Object> obj:list){
                Categorie c=new Categorie();
                float id=Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                c.setLibelle(obj.get("libelle").toString());
                categories.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }
    public ArrayList<Categorie> allCategories(){
        String url = "http://localhost/bicycle/web/app_dev.php/categorie/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categories = parseCategory(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
       NetworkManager.getInstance().addToQueueAndWait(req);
        return categories;
    }
    
}
