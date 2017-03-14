package com.avseredyuk.model;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Product {
    private int price;
    private String name;
    private int id;

    public Product(int price, String name, int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
