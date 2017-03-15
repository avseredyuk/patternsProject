package com.avseredyuk.model;

import com.avseredyuk.view.ConsoleView;

import java.util.*;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Terminal {
    public static final int[] COIN_VALUES =
            {1, 5, 10, 25, 50};
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
        int coinsTotal = order.getCoinsTotal();
        int orderTotal = order.getOrderTotal();
        if (coinsTotal >= orderTotal) {
            view.showCheckout(order);
            int change = coinsTotal - orderTotal;
            List<Integer> changeCoins = getChangeCoins(change);
            view.showChange(changeCoins);
            resetOrder();
        } else {
            view.showNotEnoughCoins();
        }
    }

    private List<Integer> getChangeCoins(int change) {
        List<Integer> resultList = new ArrayList<>();
        int[] sortedCoins = Arrays.stream(COIN_VALUES)
                .boxed()
                .sorted((a, b) -> b.compareTo(a))
                .mapToInt(i -> i)
                .toArray();
        for (int i = 0; i < sortedCoins.length; i++) {
            while (change >= sortedCoins[i]) {
                change -= sortedCoins[i];
                resultList.add(sortedCoins[i]);
            }
        }
        return resultList;
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

}
