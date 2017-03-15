package com.avseredyuk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Order {
    List<Product> cart = new ArrayList<>();
    List<Integer> coins = new ArrayList<>();

    public void addProduct(Product p) {
        cart.add(p);
    }

    public void addCoin(int coin) {
        coins.add(coin);
    }

    public List<Product> getCart() {
        return cart;
    }

    public List<Integer> getCoins() {
        return coins;
    }



}
