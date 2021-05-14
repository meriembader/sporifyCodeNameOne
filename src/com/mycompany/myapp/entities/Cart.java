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
public class Cart {
    int id; 
    int product_id;
    int user_id;
    int quantity;
    
    public Cart(){}

    public Cart(int id, int product_id, int user_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    public Cart(int product_id, int user_id, int quantity) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", quantity=" + quantity + '}';
    }
   
    
}
