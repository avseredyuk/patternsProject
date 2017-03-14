package com.avseredyuk.model;

import com.avseredyuk.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Terminal {
    private View view;

    public Terminal(View view) {
        this.view = view;
    }

    public void on() {
        view.showGreeting();
    }

    public void getProducts() {
        //todo load products from somewhere
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(25, "Tea", 1));
        productList.add(new Product(35, "Coffee", 2));
        productList.add(new Product(45, "Juice", 3));

        view.showProducts(productList);
    }

}
