/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.pi.entities.Categorie;
import com.pi.entities.Produit;
import com.pi.entities.cmd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASMA
 */
public class ServiceProduit {

    public static ServiceProduit instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceProduit() {
        req = new ConnectionRequest();
    }

    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }

    public ArrayList<Produit> getListProduit(String json) {

        ArrayList<Produit> listProduits = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(produits);

            List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");

            for (Map<String, Object> obj : list) {
                Produit p = new Produit();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());

                float quantite = Float.parseFloat(obj.get("qte").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                
                
                Map<String,Object> catObj=(Map<String,Object>) obj.get("categorie");
                String nameCategory=(String) catObj.get("libelle");
                
                 p.setCategorie( nameCategory);
                 
                 
                 
                 
                System.out.println(id);
                p.setId((int) id);
               

                p.setPrix((int) prix);
                p.setQte((int) quantite);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                p.setLibelle(obj.get("libelle").toString());

                // p.setCategorie((obj.get("categorie").toString()));
                p.setImage(obj.get("image").toString());
                System.out.println(p);
                listProduits.add(p);

            }

        } catch (IOException ex) {
        }
        System.out.println(listProduits);
        return listProduits;

    }

    ArrayList<Produit> listProduits = new ArrayList<>();

    public ArrayList<Produit> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bicycle/web/app_dev.php/produit/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                listProduits = ser.getListProduit(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }

    /**
     * ************************************
     */
    /**
     * ************************ Ajout*****************************************
     */
//    public void addProd(Produit prod) {
//        // final User me = new User();
//
//        System.out.println("Yes");
//        String Url = "http://localhost/bicycle/web/app_dev.php/addProduct/"  + "&libelle=" + prod.getLibelle() + "&qte=" + prod.getQte() + "&prix=" + prod.getPrix() + "&categorie=" + prod.getCategorie() + "&image=" + prod.getImage();
//
//req.setUrl(Url);
//
//        req.addResponseListener((e) -> {
//            String str = new String(req.getResponseData());
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//
//    }
    public boolean addProduit(Produit t, String category) {
        String url = "http://localhost/bicycle/web/app_dev.php/produit/addProduct" + "/" + t.getLibelle() + "/" + t.getPrix() + "/" + t.getQte() + "/" + category + "/" + t.getImage(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteProd(Integer id) {
        try {resultOK=false;
            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setPost(true);
            connReq.setContentType("application/json");
            connReq.setUrl("http://localhost/bicycle/web/app_dev.php/produit/deleteProduct/" + id);
            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                 resultOK = req.getResponseCode() == 200;
                System.out.println(str);
            });

            NetworkManager.getInstance().addToQueueAndWait(connReq);
             return resultOK;
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
         return resultOK;
    }

    public boolean updateProduit(Produit t, String category) {
         String url = "http://localhost/bicycle/web/app_dev.php/produit/updateProduct/"+t.getId() + "/" + t.getLibelle() + "/" + t.getPrix() + "/" + t.getQte() + "/" + category + "/" + t.getImage(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    
    }
    
    
    
    
    

   

}
