/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
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
public class DetailProductForm extends Form {
     public DetailProductForm(Product prod,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label name = new Label("Nom produit : "+prod.getName());
Label color = new Label("Couleur : "+prod.getColor());
SpanLabel  description = new SpanLabel ("Description : "+prod.getDescription());
Label size = new Label("Taille : "+prod.getSize());
Label type = new Label("Type : "+prod.getType());
Label price = new Label("Prix : "+String.valueOf(prod.getPrice()));
TextField quantite = new TextField("", "Quantité a acheté", 4, TextArea.NUMERIC);

         Button cmd= new Button("Commander");
         
         cmd.setAlignment(CENTER);
         cmd.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                 if(quantite.getText()==""){
                     Dialog.show("Erreur", "Il faut ajouter une quatité", "Fermer", null);
                 }
                 else{
                     if(Dialog.show("Confirmation", "vous etes sur ?"
                  , "OK","Annuler")){
                     int quantit = Integer.parseInt(quantite.getText());
             ServiceCaart.getInstance().addnewcart(prod.getId(),1,quantit) ;
             ListProductForm LPF = new ListProductForm(previous);
             LPF.show();
             }}}
         });

        

cnt.add(name);
cnt.add(description);
cnt.add(size);
cnt.add(color);
cnt.add(type);
cnt.add(price);
cnt.add(quantite);
cnt.add(cmd);
addAll(cnt);

getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }
}
