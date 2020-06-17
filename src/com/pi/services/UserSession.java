/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.services;

import com.pi.entities.User;

/**
 *
 * @author ASMA
 */
public class UserSession {
    
   
    public static UserSession          instance = null;

    public static void logout() {
        instance=null;
        
    }
    public User                        user     = null;
 //   private final Map<Produit, Integer> panier   = new HashMap<>();
    public float total=0;
    public UserSession() {}

    private UserSession(User userConnected) {
        this.user = userConnected;
    }

    public float getTotal() {
        return total;
    }
 public static UserSession getInstance() {
        return instance;
    }

    public final static UserSession getInstance(User userConnected) {
        if (UserSession.instance == null) {
            UserSession.instance = new UserSession(userConnected);
        }

        return UserSession.instance;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }
    
    
    
       public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class getInstance {
        public getInstance() {}
    }
}

