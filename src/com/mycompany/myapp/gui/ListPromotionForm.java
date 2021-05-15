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
import com.mycompany.myapp.entities.Product;
import com.mycompany.myapp.entities.Promotion;
import com.mycompany.myapp.services.ServiceProduct;
import com.mycompany.myapp.services.ServicePromotion;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ListPromotionForm extends Form{

    public ListPromotionForm(Form previous) {
        setTitle("List des Promotions");
     /*       Map<String,Object>[] data = new HashMap[100];
        SpanLabel sp = new SpanLabel();
        
        sp.setText(ServiceProduct.getInstance().getAllProducts().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());*/
     Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     for(Promotion promo :ServicePromotion.getInstance().getAllPromotions()){
         MultiButton mb = new MultiButton(promo.getTypeProduit()+" "+promo.getPourcentage()+ "%");
         mb.setTextLine3("voir plus");
        mb.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
            DetailPromotionForm DPromoF =new DetailPromotionForm(promo,previous);
             DPromoF.show();
             }
         });
         cnt.add(mb);
     }
     add(cnt);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
