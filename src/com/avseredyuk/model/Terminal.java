package com.avseredyuk.model;

import com.avseredyuk.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Terminal {
    private ConsoleView view;
    private Order order = new Order();

    public Terminal(ConsoleView view) {
        this.view = view;
    }

    public void on() {
        view.showGreeting();
    }

    public List<Product> getProducts() {
        //todo load products from somewhere
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(25, "Tea", 1));
        productList.add(new Product(35, "Coffee", 2));
        productList.add(new Product(45, "Juice", 3));

        return productList;
    }

    public void addProduct(int id) {
        List<Product> productList = getProducts();
        Optional<Product> optionalProduct = productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            order.addProduct(product);
        } else {
            throw new NumberFormatException();
        }
    }

    public void checkout() {
        //todo some logic here
    }

    public void addCoin(int coin) {
        order.addCoin(coin);
    }

    public void resetOrder() {
        order = new Order();
    }

    public Order getOrder() {
        return order;
    }

//    public void resetOrder() {
//
//    }
}
