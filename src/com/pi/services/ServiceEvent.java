/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.pi.entities.Produit;
import com.pi.entities.Reservations;
import static com.pi.services.ServiceProduit.instance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author GHAITH
 */
public class ServiceEvent {

      public static ServiceEvent instance = null;

        public boolean resultOK;
      public  MultipartRequest con;

    private ConnectionRequest req;

    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
        }
        return instance;
    }
    public ServiceEvent() {
        req = new ConnectionRequest();
    }
 //   includes a JSONParser class that allows you to, quite easily, 
            //consume a web service and parse its output into a tree of Hashtables and Vectors
    public ArrayList<Reservations> affiche() {

        ArrayList<Reservations> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        // con.setUrl("http://127.0.0.1/pidevweb/web/app_dev.php/api/Loisir/all");
        con.setUrl("http://127.0.0.1/bicycle/web/app_dev.php/Event/allJSON");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    // System.out.println("roooooot:" +tasks.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {

                        Reservations task = new Reservations();
//                        task.setId(((Double) obj.get("id")).intValue());
                        float idreservation = Float.parseFloat(obj.get("idreservation").toString());
                        float iduser= Float.parseFloat(obj.get("iduser").toString());

                        task.setIdreservation((int) idreservation);
                        String date=obj.get("date").toString();
                        task.setDate(date.substring(6, 16));
                        
                        task.setPlace(obj.get("place").toString());
                        task.setBike(obj.get("bike").toString());
                        task.setIduser((int) iduser);                        
                      //   task.setCreator(((Double) obj.get("creator")).intValue());
                       //float idC = Float.parseFloat(obj.get("creator").toString());
                      //  task.setCreator((int) idC);
                        // task.setAdresse(obj.get("adresse").toString());
                        listTasks.add(task);

                    }

                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listTasks;

    }   
public void ajoutEvent(Reservations Res, MultipartRequest con) {
        // final User me = new User();

        System.out.println("Yes");
        String Url = "http://127.0.0.1/bicycle/web/app_dev.php/Event/add/"+Res.getDate() +"/"+ Res.getPlace() + "/" + Res.getBike()+"/"+Res.getIduser();//+"&adresse="+ ta.getAdresse();

        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }   
public boolean updateEvent(Reservations Res) {
         String url = "http://localhost/bicycle/web/app_dev.php/Event/postupdate/"+Res.getIdreservation() +"/"+Res.getDate() +"/"+ Res.getPlace() + "/" + Res.getBike(); //création de l'URL

         System.out.println(url);
          req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
       // NetworkManager.getInstance().addToQueueAndWait(con);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    
    }
 public boolean deleteEvent(Integer idreservation) {
        try {resultOK=false;
            
            req.setPost(true);
           req.setContentType("application/json");
            req.setUrl("http://localhost/bicycle/web/app_dev.php/Event/delete/" + idreservation);
            req.addResponseListener((e) -> {
                String str = new String(req.getResponseData());
                 resultOK = req.getResponseCode() == 200;
                System.out.println(str);
            });

            NetworkManager.getInstance().addToQueueAndWait(req);
             return resultOK;
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
         return resultOK;
    }

   
}
