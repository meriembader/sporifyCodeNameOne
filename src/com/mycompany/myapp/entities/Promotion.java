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

    int pourcentage;

     public Promotion( ) {
      
    }
    
     public Promotion( int pourcentage) {
       
        this.pourcentage = pourcentage;
    }
    public Promotion(int id, int pourcentage) {
        this.id = id;
        this.pourcentage = pourcentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", pourcentage=" + pourcentage + '}';
    }
  
    
    
    
}
