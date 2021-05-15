/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.components.ToastBar;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;


import com.mycompany.myapp.gui.ListEventForm;
import com.mycompany.myapp.gui.ListProductForm;
import com.mycompany.myapp.gui.ListPromotionForm;




/**
 * Common code that can setup the side menu
 *
 * @author Meriem
 */
public abstract class SideMenuBaseForm extends Form {
Form current;
    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }
 
    public SideMenuBaseForm(String title) {
       
        super(title);
         current=this;
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("Sporify", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        
        getToolbar().addComponentToSideMenu(sidemenuTop);
   
            getToolbar().addMaterialCommandToSideMenu("list Produit", FontImage.MATERIAL_AC_UNIT, e-> new ListProductForm(this).show());
              getToolbar().addMaterialCommandToSideMenu("list Event", FontImage.MATERIAL_AC_UNIT, e-> new ListEventForm(this).show());
              getToolbar().addMaterialCommandToSideMenu("Promotions", FontImage.MATERIAL_AC_UNIT, e-> new ListPromotionForm(this).show());
      
     
    }
    
    protected abstract void showOtherForm(Resources res);
}

