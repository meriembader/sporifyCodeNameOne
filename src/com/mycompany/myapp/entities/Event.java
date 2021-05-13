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
  

    public Event() {}

    public Event(int id, String titre, String description, String image, String location) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.location = location;
    }

    public Event(String titre, String description, String image, String location) {
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.location = location;
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

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", image=" + image + ", location=" + location + '}';
    }
    

}
    
    
    
