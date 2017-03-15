package com.avseredyuk.view;

import com.avseredyuk.model.Order;
import com.avseredyuk.model.Product;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class ConsoleView {
    private static final String STRING_FORMAT_PRODUCTS = "\t%d\t\t%d\t\t%s";
    private static final String STRING_FORMAT_PRODUCT = "\t\t%s";
    private static final String STRING_FORMAT_CART = "\t\t%s\t\t%s";
    private static final String STRING_FORMAT_COIN = "\t\t%d";
    private static final String PRODUCTS_LIST_HEADER = "\tID\t\tPRICE\tNAME";
    private static final String STRING_NO_ITEMS = "\t\t<No items>";
    private static final String STRING_NOT_ENOUGH_COINS = "Not enough coins";
    private static final String STRING_FORMAT_ERROR = "Error happened: %s";
    private static final String STRING_HEADER_ITEMS_IN_CART = "\tItems in cart:";
    private static final String STRING_HEADER_INSERTED_COINS = "\tInserted coins:";
    private static final String STRING_HEADER_TOTAL_COINS = "\tTotal coins:";
    private static final String STRING_HEADER_CHANGE = "\tHere is your change:";
    private static final String STRING_HEADER_CHECKEDOUT_ORDER = "\tHere is your products:";
    private static final String COMMAND_NOT_FOUND = "Command not found";
    private static final String ILLEGAL_INPUT = "Illegal input";
    private static final String STRING_WELCOME = "Welcome!";

    public void showGreeting() {
        System.out.println(STRING_WELCOME);
    }

    public void showNoSuchCommand() {
        System.out.println(String.format(STRING_FORMAT_ERROR,
                COMMAND_NOT_FOUND));
    }

    public void showIllegalInput() {
        System.out.println(String.format(STRING_FORMAT_ERROR,
                ILLEGAL_INPUT));
    }

    public void showProducts(List<Product> productList) {
        System.out.println(PRODUCTS_LIST_HEADER);
        for (Product p : productList) {
            System.out.println(String.format(STRING_FORMAT_PRODUCTS,
                    p.getId(),
                    p.getPrice(),
                    p.getName()));
        }
    }

    public void showNotEnoughCoins() {
        System.out.println(STRING_NOT_ENOUGH_COINS);
    }

    public void showCheckout(Order order) {
        System.out.println(STRING_HEADER_CHECKEDOUT_ORDER);
        order.getCart().forEach(p -> System.out.println(String.format(STRING_FORMAT_PRODUCT, p.getName())));
    }

    public void showChange(List<Integer> changeCoins) {
        if (changeCoins.size() > 0) {
            System.out.println(STRING_HEADER_CHANGE);
            changeCoins.forEach(i -> System.out.println(String.format(STRING_FORMAT_COIN, i)));
        }
    }

    public void showOrder(Order order) {
        List<Product> productList = order.getCart();

        System.out.println(STRING_HEADER_ITEMS_IN_CART);
        if (productList.size() > 0) {
            productList.forEach(p -> System.out.println(String.format(STRING_FORMAT_CART,
                    p.getPrice(),
                    p.getName())));
        } else {
            System.out.println(String.format(STRING_FORMAT_ERROR, STRING_NO_ITEMS));
        }

        int coinsTotal = order.getCoinsTotal();
        System.out.println(STRING_HEADER_INSERTED_COINS);
        if (coinsTotal > 0) {
            List<Integer> coinList = order.getCoins();
            coinList.forEach(coin -> System.out.println(String.format(STRING_FORMAT_COIN, coin)));
            System.out.println(STRING_HEADER_TOTAL_COINS);
            System.out.println(String.format(STRING_FORMAT_COIN, coinsTotal));
        } else {
            System.out.println(STRING_NO_ITEMS);
        }

    }


}
