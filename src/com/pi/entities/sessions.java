/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.entities;

/**
 *
 * @author ASMA
 */
public class sessions {
    
   private static User User=null;

    public static void start(User currentUser) {
        User = currentUser;
    }

    public static User getCurrentSession() {
        if (User != null) {
            return User;
        }
        return null;

    }
    
        public static void close() throws Exception {
        if (User != null) {
            User =null;
        } else {
            throw new Exception("Session has not started yet!");
        }
    }
    
}
