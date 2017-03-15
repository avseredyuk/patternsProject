package com.avseredyuk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Order {
    private List<Product> cart = new ArrayList<>();
    private List<Integer> coins = new ArrayList<>();

    public void addProduct(Product p) {
        cart.add(p);
    }

    public void addCoin(int coin) {
        coins.add(coin);
    }

    public List<Product> getCart() {
        return new ArrayList<>(cart);
    }

    public List<Integer> getCoins() {
        return new ArrayList<>(coins);
    }

}
