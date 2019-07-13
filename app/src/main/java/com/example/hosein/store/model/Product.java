package com.example.hosein.store.model;

public class Product {


    // Store the id of the  movie poster
    private String name;
    // Store the name of the movie
    private String desc;
    // Store the release date of the movie
    private String  price;

    // Constructor that is used to create an instance of the Movie object
    public Product(String name, String desc , String price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
