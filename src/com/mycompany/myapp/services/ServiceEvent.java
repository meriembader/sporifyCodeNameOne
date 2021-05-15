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
import com.mycompany.myapp.entities.Event;


import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Meriem
 */
public class ServiceEvent {

 
    public ArrayList<Event> event;
    
    public static ServiceEvent instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEvent() {
         req = new ConnectionRequest();
    }

    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
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
    public ArrayList<Event> parseEvent(String jsonText){
        try {
            event =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Event e = new Event();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                e.setTitre(((String)(obj.get("titre").toString())));
                 e.setDescription(((String)(obj.get("description").toString())));
                  
                     e.setImage(((String)(obj.get("image").toString())));
                       e.setLocation(((String)(obj.get("location").toString())));
               e.setDebut(((String)(obj.get("date_debut").toString())).substring(0, 16));
               e.setFin(((String)(obj.get("date_fin").toString())).substring(0, 16));
                System.out.println(e);

               event.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return event;
    }
    
    public ArrayList<Event> getAllEvents(){
        String url = Statics.BASE_URL+"/espritApi/allEvent";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                event = parseEvent(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return event;
    }
}
