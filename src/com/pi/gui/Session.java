/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.pi.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ASMA
 */
class Session {
    
  public User user;
    public String recupemail;
    public String recupmdp;
    
         public static Session instance;

   
   
    

    /*public User getUser() {
        user = getList2(recupemail, recupmdp);
        return user;
    }*/
      public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
 
   
   
   
     public ArrayList<User> getList(String json) {

        ArrayList<User> listUser = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> User = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("User connecté");
           
            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) User.get("root");

            for (Map<String, Object> obj : list) {
                User Us = new User();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                
                //System.out.println(id);
                Us.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                //rec.setId_user(obj.get("id_user"));
               Us.setUsername(obj.get("username").toString());
               Us.setUsername_canonical(obj.get("username").toString());
               Us.setEmail(obj.get("email").toString());
               Us.setEmail_canonical(obj.get("email").toString());
               Us.setPassword(obj.get("password").toString());
              
               //rec.setContenu_rec(obj.get("contenu_reclamation").toString());
               user=Us;
               System.out.println(Us);
                listUser.add(Us);

            }

        } catch (IOException ex) {
        }
        //System.out.println(listUser);
        return listUser;

    }
    
    //User UserConn = new User();
    ArrayList<User> listU = new ArrayList<>();
    
    
    public ArrayList<User> getList2(String Email, String Password){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bicycle/web/app_dev.php/LoginWebSer/"+ Email + "/" + Password);  
        con.addResponseListener((NetworkEvent evt) -> {
            //Session s = new Session();
            listU = getList(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    //user=UserConn;
        
      
       return listU;
        
    }
    
   

   /* 
   public void Loginn(String usr, String pass) throws ClassNotFoundException, SQLException, InstantiationException {

        try {

            Connection connection;

            PreparedStatement ps;

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bonsplans", "root", "");
            ps = connection.prepareStatement("SELECT `id`, `Email`, `test` ,`nom` , `username` FROM `user` WHERE `email` = ? AND `password` = ? ");
            ps.setString(1, String.valueOf(usr));

            ps.setString(2, String.valueOf(pass));

            ResultSet result = ps.executeQuery();

            if (result.next()) {

                user = new User();
                user.setId(result.getInt("id"));
                user.setNom(result.getString("nom"));
                user.setEmail(result.getString("email"));
                user.setLogin(result.getString("username"));
                LoginController in = new LoginController();

               

                String mr = result.getString("test");
                switch (mr) { 
                    case "Admin":
                        in.setStage("/gui/BackendAdminAcceuil.fxml");

                        Al("Hello Admin!");

                        break;
                    case "Membre":
                         in.setStage("/gui/Profile.fxml");

                        Al("Hello Membre!");

                        break;
                    case "Membre professionnel":
                         in.setStage("/gui/Profile.fxml");

                        break;

                }

//    }
            } else {

                //   jLabel_Message.setText("Invalide Username Or Password");
                Al("Failed :(");

            }
        } catch (Exception ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
}


