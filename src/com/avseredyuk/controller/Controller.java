package com.avseredyuk.controller;

import com.avseredyuk.model.Product;
import com.avseredyuk.model.Terminal;
import com.avseredyuk.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class Controller {
    private static final String[] COMMANDS_ARRAY =
            {"list", "add", "cart", "coin", "reset"};
    private static final int[] COIN_VALUES =
            {1, 5, 10, 25, 50};
    private static final List<Product> products = new ArrayList<Product>(){{
        add(new Product(25, "Tea", 1));
        add(new Product(35, "Coffee", 2));
        add(new Product(45, "Juice", 3));}};

    private Terminal terminal;
    private View view;

    public Controller(Terminal terminal, View view) {
        this.terminal = terminal;
        this.view = view;
    }

    public void run() {

        terminal.on();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String params[] = scanner.nextLine().split(" ");
            if (params.length > 0) {
                if (params[0].equals(COMMANDS_ARRAY[0])) {
                    view.showProducts(products);
                /*} else if (params[0].equals(COMMANDS_ARRAY[1])) {
                    if (params.length == 2) {
                        try {
                            String idString = params[1];
                            int id = Integer.valueOf(idString);
                            Optional<Product> optionalProduct = products.stream()
                                    .filter(p -> p.getId() == id)
                                    .findFirst();
                            if (optionalProduct.isPresent()) {
                                Product product = optionalProduct.get();
                                order.addProduct(product);
                                System.out.println(String.format(STRING_FORMAT_ADDED, product.getName()));
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(String.format(STRING_FORMAT_ERROR,
                                    ILLEGAL_INPUT));
                        }
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[2])) {
                    for (Product p : order.getCart()) {
                        System.out.println(String.format(STRING_FORMAT_BUCKET_ITEM, p.getName()));
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[3])) {
                    if (params.length == 2) {
                        try {
                            String coinString = params[1];
                            int coin = Integer.valueOf(coinString);
                            if (IntStream.of(COIN_VALUES).anyMatch(x -> x == coin)) {
                                order.addCoin(coin);
                                System.out.println(String.format(STRING_FORMAT_COINS_SUM,
                                        order.getCoins().stream()
                                                .mapToInt(Integer::intValue)
                                                .sum()));
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(String.format(STRING_FORMAT_ERROR,
                                    ILLEGAL_INPUT));
                        }
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[4])) {
                    if (order.getCoins().size() > 1) {
                        System.out.println(HERE_IS_YOUR_COINS);
                        for (Integer coin : order.getCoins()) {
                            System.out.println(String.format(STRING_FORMAT_COIN_ITEM, coin));
                        }
                    } else {
                        System.out.println(NO_INPUT_COINS);
                    }
                    order = new Order();*/
                } else {
                    view.showNoSuchCommand();
                }
            }


        }
    }

}
