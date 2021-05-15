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
import com.mycompany.myapp.entities.Cart;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.entities.Product;
import com.mycompany.myapp.entities.Promotion;

/**
 *
 * @author Meriem
 */
public class CartForm extends Form {
     public CartForm(Cart cart,Promotion promo ,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label identifiant = new Label("id : "+cart.getId());
Label quantité = new Label("quantité : "+cart.getQuantity());

Label promotion = new Label("promotion : "+promo.getPourcentage());

cnt.add(identifiant);
cnt.add(quantité);
cnt.add(promotion);

add(cnt);
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }

 
}
