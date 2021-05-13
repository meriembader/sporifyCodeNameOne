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
public class Product {
    int id; 
    String name;
    String description;
    String quantity;
    String size;
    String color;
    String type;
    String supplier;
    String image;
    float price;

    public Product() {
    }
    
    
    

    public Product(String name, String description, String quantity, String size, String color, String type, String supplier, String image, float price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.type = type;
        this.supplier = supplier;
        this.image = image;
        this.price = price;
    }

    
    
    
    public Product(int id, String name, String description, String quantity, String size, String color, String type, String supplier, String image, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.type = type;
        this.supplier = supplier;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity + ", size=" + size + ", color=" + color + ", type=" + type + ", supplier=" + supplier + ", image=" + image + ", price=" + price + '}';
    }
    
    
    
}
