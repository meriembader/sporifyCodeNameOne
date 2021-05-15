/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Meriem
 */
public class Event {
    int id; 
    String titre;
    String description;
    String image;
    String location;
    String debut;
    String fin;

    public Event() {}

    public Event(int id, String titre, String description, String image, String location, String debut, String fin) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.location = location;
        this.debut = debut;
        this.fin = fin;
    }

    public Event(String titre, String description, String image, String location, String debut, String fin) {
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.location = location;
        this.debut = debut;
        this.fin = fin;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }


    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", image=" + image + ", location=" + location + ", debut=" + debut + ", fin=" + fin + '}';
    }

 
    

}
    
    
    
