/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.p;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;


import com.mycompany.myapp.entities.Product;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ServiceProduct {

 
    public ArrayList<Product> product;
    public Product prod;
    public static ServiceProduct instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceProduct() {
         req = new ConnectionRequest();
    }

    public static ServiceProduct getInstance() {
        if (instance == null) {
            instance = new ServiceProduct();
        }
        return instance;
    }


   

  /*  public boolean addBenevole(Product p ) {
        String url = Statics.BASE_URL + "/api/tasks/newBenevole"+"?" +"cin="+b.getCin() + "&" +"address=" + b.getAddress()+ "&" +"mail="+ b.getMail()+ "&" +"telephone="+ b.getTelephone()+ "&" +"niveau="+ b.getNiveau()+ "&" +"gouvernorat="+ b.getGouvernorat();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    */
    public ArrayList<Product> parseProdcut(String jsonText){
        try {
            product =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Product p = new Product();
               float id=Float.parseFloat(obj.get("id").toString());
               
               p.setId(((int)id));
               p.setName(((String)(obj.get("name").toString())));
               p.setColor(((String)(obj.get("color").toString())));
               p.setDescription(((String)(obj.get("description").toString())));
               p.setSize(((String)(obj.get("size").toString())));
                  p.setType(((String)(obj.get("type").toString())));
                   
                 float price = Float.parseFloat(obj.get("price").toString());
                p.setPrice((int)price);
               product.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return product;
    }
    
    public ArrayList<Product> getAllProducts(){
        String url = Statics.BASE_URL+"/espritApi/productss";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                product = parseProdcut(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return product;
    }
        public Product parseOneProdcut(String jsonText){
            Product p = new Product();
        try {

            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                
               float id=Float.parseFloat(obj.get("id").toString());
               
               p.setId(((int)id));
               p.setName(((String)(obj.get("name").toString())));
               p.setColor(((String)(obj.get("color").toString())));
               p.setDescription(((String)(obj.get("description").toString())));
               p.setSize(((String)(obj.get("size").toString())));

    
                  p.setType(((String)(obj.get("type").toString())));
                   
                 float price = Float.parseFloat(obj.get("price").toString());
                p.setPrice((int)price);

            }
            
            
        } catch (IOException ex) {
            
        }

        return p;
    }
    public Product getOneProduct(String jsonText,int idprod){
         String url = Statics.BASE_URL+"/product/detail/"+idprod;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                prod = parseOneProdcut(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return prod;

    }
}
