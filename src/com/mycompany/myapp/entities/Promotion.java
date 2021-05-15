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
public class Promotion {
    int id;
String titre;
int pourcentage;

String description;
String typeProduit;
String date_debut;
String date_fin;

    
     public Promotion( ) {
      
    }

    public Promotion(int id, String titre, int pourcentage, String description, String typeProduit, String date_debut, String date_fin) {
        this.id = id;
        this.titre = titre;
        this.pourcentage = pourcentage;
        this.description = description;
        this.typeProduit = typeProduit;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Promotion(String titre, int pourcentage, String description, String typeProduit, String date_debut, String date_fin) {
        this.titre = titre;
        this.pourcentage = pourcentage;
        this.description = description;
        this.typeProduit = typeProduit;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
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

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", titre=" + titre + ", pourcentage=" + pourcentage + ", description=" + description + ", type_produit=" + typeProduit + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
   
}
