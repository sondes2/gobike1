/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.pi.services.ServiceCmd;

/**
 *
 * @author ASMA
 */
public class ListCmd extends Form{
     public ListCmd(Form previous) {
        setTitle("List Commande");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceCmd.getInstance().getAllTasks().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
