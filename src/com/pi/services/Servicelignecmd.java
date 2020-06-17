/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import com.pi.entities.lignecmd;
import com.pi.entities.Produit;
import com.pi.entities.cmd;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author ASMA
 */
public class Servicelignecmd {
    

 public static Servicelignecmd instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public Servicelignecmd() {
         req = new ConnectionRequest();
    }

    public static Servicelignecmd getInstance() {
        if (instance == null) {
            instance = new Servicelignecmd();
        }
        return instance;
    }
       
    
    
    
    
    /**********************************/
       
    public ArrayList<lignecmd> getLignesCommandeProduit(Integer id) {
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("id"+id);
        String Url = "http://localhost/bicycle/web/app_dev.php/affJson/"+id;
        con.setUrl(Url);
        ArrayList<lignecmd> mapPanier = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> lcommandes = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) lcommandes.get("root");
              //  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for (Map<String, Object> obj : list) {
                    
                    /*       double t = (double) obj.get("dateLivraison");
                        long x = (long) (t * 1000L);
                    String format = new SimpleDateFormat("MM/dd/yyyy").format(new Date(x));
*/                    

                    lignecmd lcp = new lignecmd();
                    lcp.setId((int)Float.parseFloat(obj.get("id").toString()));
                    lcp.setProduit((int)Float.parseFloat(obj.get("produit").toString()));
                   // lcp.setProduit((obj.get("produit").toString()));
                    lcp.setQuantite((obj.get("qte").toString()));
                   // lcp.setUserid((int)Float.parseFloat(obj.get("userid").toString()));
                    
                    
                 
                  //  System.out.println(obj.get("numTel").toString());
              
                    
                    mapPanier.add(lcp);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return mapPanier;
    }
    
    
    
    
    
    
    
    
    /**********************************/
    
   
    /**********************************/
       
    public ArrayList<cmd> getCommande () {
        ConnectionRequest con = new ConnectionRequest();
       // System.out.println("id"+id);
        String Url = "http://localhost/bicycle/web/app_dev.php/affJson/";
        con.setUrl(Url);
        ArrayList<cmd> mapPanier = new ArrayList<>();
        con.addResponseListener((e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> lcommandes = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) lcommandes.get("root");
              //  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for (Map<String, Object> obj : list) {
                    
                    /*       double t = (double) obj.get("dateLivraison");
                        long x = (long) (t * 1000L);
                    String format = new SimpleDateFormat("MM/dd/yyyy").format(new Date(x));
*/                    

                    cmd lcp = new cmd();
                    lcp.setId((int)Float.parseFloat(obj.get("id").toString()));
                    lcp.setPrix((int)Float.parseFloat(obj.get("prix").toString()));
                    lcp.setTelephone((obj.get("telephone").toString()));
                    lcp.setAdresse((obj.get("adresse").toString()));
                  //  lcp.setQuantite((int)Float.parseFloat(obj.get("qte").toString()));
                   // lcp.setUserid((int)Float.parseFloat(obj.get("userid").toString()));
                    
                    
                 
                  //  System.out.println(obj.get("numTel").toString());
              
                    
                    mapPanier.add(lcp);
               //    System.out.println("id commande : "+lcp.getPrixTotal());
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return mapPanier;
    }
    
    
    
   
    
    
    
    /**********************************/
   int ff =ServiceUsers.getInstance().current().getId();

    
     public boolean addTask(lignecmd t) {
            String url = "http://localhost/bicycle/web/app_dev.php/ajoutLigneCommandeJson/" + ff + "/" + t.getProduit()+ "/" + t.getQuantite(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
  
    
    
    /**********************************/
    
    
      public boolean addCmd(cmd t) {
        String url = "http://localhost/bicycle/web/app_dev.php/add/" + ff + "/" + t.getAdresse()+ "/" + t.getPrix() + "/" + t.getTelephone(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
        /**********************************/

    
    
    
   public ArrayList<lignecmd> getLignesWishlistProduit(Integer id) {
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("id"+id);
        String Url = "http://localhost/bicycle/web/app_dev.php/lignecmd/affich"+id;
        con.setUrl(Url);
        ArrayList<lignecmd> maplwishlist = new ArrayList<>();
        con.addResponseListener((NetworkEvent e) -> {
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> lwishlists = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) lwishlists.get("root");
                for (Map<String, Object> obj : list) {
                    
                    /*       double t = (double) obj.get("dateLivraison");
                        long x = (long) (t * 1000L);
                    String format = new SimpleDateFormat("MM/dd/yyyy").format(new Date(x));
*/                    

                    lignecmd lwp = new lignecmd();
                    lwp.setUserid((int)Float.parseFloat(obj.get("userid").toString()));
                    //lwp.setProduit((obj.get("produit").toString()));
                   lwp.setQuantite((obj.get("qte").toString()));
                  
                    
                 //   System.out.println("qte "+lwp.getQuantiteEnStock());
                    
                    maplwishlist.add(lwp);
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return maplwishlist;
    }
   
   
   
   
   
   
   
   
     public void deleteLigneWishlist(Integer id)
      {
            try {
            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setPost(true);
            connReq.setContentType("application/json");
connReq.setUrl("http://localhost/bicycle/web/app_dev.php/delete/"+id);  
connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });

            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
      }
   
   
   
   
   
   }
