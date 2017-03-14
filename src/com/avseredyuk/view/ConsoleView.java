package com.avseredyuk.view;

import com.avseredyuk.model.Product;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class ConsoleView implements View {


    @Override
    public void showGreeting() {
        System.out.println("Welcome!");
    }

    @Override
    public void showNoSuchCommand() {
        System.out.println("no stuff");
    }

    @Override
    public void showProducts(List<Product> productList) {
        productList.forEach(p -> {
            System.out.println(p);
        });
    }
}
