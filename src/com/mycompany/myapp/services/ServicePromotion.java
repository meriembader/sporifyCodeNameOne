/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Cart;
import com.mycompany.myapp.entities.Promotion;


import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ServicePromotion {

    public ArrayList<Promotion> promotions;
    
    
    public static ServicePromotion instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePromotion() {
         req = new ConnectionRequest();
    }

    public static ServicePromotion getInstance() {
        if (instance == null) {
            instance = new ServicePromotion();
        }
        return instance;
    }


    
    
     public ArrayList<Promotion> parsePromotions(String jsonText){
        try {
            promotions=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                  Promotion promo = new Promotion();
                 float id=Float.parseFloat(obj.get("id").toString());
                 promo.setId(((int)id));
                   promo.setTitre(((String)(obj.get("titre").toString())));
                 float pourcentage = Float.parseFloat(obj.get("pourcentage").toString());
               promo.setPourcentage((int)pourcentage);
                  
             
              promo.setDescription(((String)(obj.get("description").toString())));
              promo.setTypeProduit(((String)(obj.get("typeProduit").toString())));
            promo.setDate_debut(((String)(obj.get("date_debut").toString())).substring(0, 16));
             promo.setDate_fin(((String)(obj.get("date_fin").toString())).substring(0, 16));
               promotions.add(promo);
            }
            
        } catch (IOException ex) {
            
        }
        return promotions;
    }
    
    public ArrayList<Promotion> getAllPromotions(){
        String url = Statics.BASE_URL+"/espritApi/allPromotions";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                promotions = parsePromotions(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return promotions;
    }
}
