/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceProduct;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ListProductForm extends Form{

    public ListProductForm(Form previous) {
        setTitle("List des produit");
            Map<String,Object>[] data = new HashMap[100];
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceProduct.getInstance().getAllProducts().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
