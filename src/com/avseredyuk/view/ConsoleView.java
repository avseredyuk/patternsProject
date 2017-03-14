package com.avseredyuk.view;

import com.avseredyuk.model.Product;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class ConsoleView implements View {
    private static final String STRING_FORMAT_PRODUCTS = "\t%d\t\t%d\t\t%s";
    private static final String PRODUCTS_LIST_HEADER = "\tID\t\tPRICE\tNAME";
    private static final String STRING_FORMAT_ERROR = "Error happened: %s";
    private static final String STRING_FORMAT_ADDED = "Added: %s";
    private static final String STRING_FORMAT_BUCKET_ITEM = " * %s";
    private static final String STRING_FORMAT_COINS_SUM = "  Coins sum: %d";
    private static final String STRING_FORMAT_COIN_ITEM = "Coin %d";
    private static final String COMMAND_NOT_FOUND = "Command not found";
    private static final String ILLEGAL_INPUT = "Illegal input";
    private static final String NO_INPUT_COINS = "There is no input coins";
    private static final String HERE_IS_YOUR_COINS = "Here is your coins : ";
    private static final String STRING_WELCOME = "Welcome!";

    @Override
    public void showGreeting() {
        System.out.println(STRING_WELCOME);
    }

    @Override
    public void showNoSuchCommand() {
        System.out.println(String.format(STRING_FORMAT_ERROR,
                COMMAND_NOT_FOUND));
    }

    @Override
    public void showProducts(List<Product> productList) {
        System.out.println(PRODUCTS_LIST_HEADER);
        for (Product p : productList) {
            System.out.println(String.format(STRING_FORMAT_PRODUCTS,
                    p.getId(),
                    p.getPrice(),
                    p.getName()));
        }
    }
}
