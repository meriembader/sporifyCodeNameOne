/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.ServiceEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ListEventForm extends Form{

    public ListEventForm(Form previous) {
        setTitle("List des Evenements");
     /*       Map<String,Object>[] data = new HashMap[100];
        SpanLabel sp = new SpanLabel();
        
        sp.setText(ServiceProduct.getInstance().getAllProducts().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());*/
     Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     for(Event ev :ServiceEvent.getInstance().getAllEvents()){
         MultiButton mb = new MultiButton(ev.getTitre());
         mb.setTextLine2(ev.getDebut()+" à "+ev.getFin());
         mb.setTextLine3("Voire plus");
                  mb.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
             DetailEventForm DEF =new DetailEventForm(ev,previous);
             DEF.show();
             }
         });

         cnt.add(mb);
     }
     add(cnt);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
