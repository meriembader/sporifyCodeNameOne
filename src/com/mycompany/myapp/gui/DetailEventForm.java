/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.entities.Product;

/**
 *
 * @author Meriem
 */
public class DetailEventForm extends Form {
     public DetailEventForm(Event ev,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label name = new Label("Titre : "+ev.getTitre());
Label Localisation = new Label("Localisation : "+ev.getLocation());
SpanLabel  description = new SpanLabel ("Description : "+ev.getDescription());
Label debut = new Label("Date debut : "+ev.getDebut());
Label fin = new Label("Date fin : "+ev.getFin());
cnt.add(name);
cnt.add(description);
cnt.add(Localisation);
cnt.add(debut);
cnt.add(fin);

add(cnt);
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }

    DetailEventForm(Product prod, Form previous) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
