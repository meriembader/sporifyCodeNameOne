/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Product;
import com.mycompany.myapp.entities.Promotion;
import com.mycompany.myapp.services.ServiceCaart;
import com.mycompany.myapp.gui.CartForm;
/**
 *
 * @author Meriem 
 */
public class DetailPromotionForm extends Form {
     public DetailPromotionForm(Promotion promo,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("titre : "+promo.getTitre());
Label pourcentage = new Label("pourcentage : "+promo.getPourcentage());
SpanLabel  description = new SpanLabel ("Description : "+promo.getDescription());
Label typeProduit = new Label("typeProduit : "+promo.getTypeProduit());
Label date_debut = new Label("date_debut : "+promo.getDate_debut());
Label date_fin = new Label("date_fin : "+String.valueOf(promo.getDate_fin()));
         
         
       
        
        

cnt.add(titre);
cnt.add(description);
cnt.add(pourcentage);
cnt.add(typeProduit);
cnt.add(date_debut);
cnt.add(date_fin);

addAll(cnt);

getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }
}
