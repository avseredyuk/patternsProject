package com.avseredyuk.model;

/**
 * Created by Anton_Serediuk on 3/7/2017.
 */
public class SaleLineItem {
    private int quantity;
    private Product product;

    public int subtotal() {
        return quantity * product.getPrice();
    }


}
