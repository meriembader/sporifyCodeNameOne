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
import com.mycompany.myapp.entities.association;

import com.mycompany.myapp.entities.formation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceFormation {

 
    public ArrayList<formation> benevoles;
    
    public static ServiceFormation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceFormation() {
         req = new ConnectionRequest();
    }

    public static ServiceFormation getInstance() {
        if (instance == null) {
            instance = new ServiceFormation();
        }
        return instance;
    }


   

    public boolean addBenevole(formation b ) {
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
    
    public ArrayList<formation> parseBenevoles(String jsonText){
        try {
            benevoles=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                formation b = new formation();
                float id = Float.parseFloat(obj.get("id").toString());
                b.setId((int)id);
                float cin = Float.parseFloat(obj.get("cin").toString());
                b.setCin((int)cin);
               b.setAddress(((String)(obj.get("address").toString())));
                float telephone = Float.parseFloat(obj.get("telephone").toString());
                b.setId((int)telephone);
               b.setNiveau(((String)(obj.get("niveau").toString())));
               b.setGouvernorat(((String)(obj.get("gouvernorat").toString())));
               benevoles.add(b);
            }
            
            
        } catch (IOException ex) {
            
        }
        return benevoles;
    }
    
    public ArrayList<formation> getAllTasks(){
        String url = Statics.BASE_URL+"/api/tasks/allBenevole";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                benevoles = parseBenevoles(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return benevoles;
    }
}
