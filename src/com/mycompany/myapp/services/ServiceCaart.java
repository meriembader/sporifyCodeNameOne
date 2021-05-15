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
public class ServiceCaart {

    public ArrayList<Cart> carts;
    public ArrayList<Promotion> promotions;
    
    public static ServiceCaart instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCaart() {
         req = new ConnectionRequest();
    }

    public static ServiceCaart getInstance() {
        if (instance == null) {
            instance = new ServiceCaart();
        }
        return instance;
    }


    public ArrayList<Cart> parseCarts(String jsonText){
        try {
            carts=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Cart c = new Cart();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                 float quantity = Float.parseFloat(obj.get("quantity").toString());
                c.setQuantity((int)quantity);
              
               carts.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return carts;
    }
    
     public ArrayList<Cart> parsePromotions(String jsonText){
        try {
            carts=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Cart c = new Cart();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                 float quantity = Float.parseFloat(obj.get("quantity").toString());
                c.setQuantity((int)quantity);
              
               carts.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return carts;
    }
    
    public ArrayList<Cart> getAllCarts(){
        String url = Statics.BASE_URL+"/espritApi/checkoutJson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                carts = parseCarts(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return carts;
    }
    public Boolean addnewcart(int id,int idprod,int quant){
        String url = Statics.BASE_URL+"/espritApi/commander"+id+"/"+idprod+"/"+quant;
        req.setUrl(url);
        req.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return true;
    }
}
