package com.avseredyuk;

import com.avseredyuk.controller.Controller;
import com.avseredyuk.model.Product;
import com.avseredyuk.model.Terminal;
import com.avseredyuk.view.ConsoleView;
import com.avseredyuk.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Main {
    private static final String[] COMMANDS_ARRAY =
            {"list", "add", "cart", "coin", "reset"};
    private static final int[] COIN_VALUES =
            {1, 5, 10, 25, 50};
    private static final List<Product> products = new ArrayList<Product>(){{
        add(new Product(25, "Tea", 1));
        add(new Product(35, "Coffee", 2));
        add(new Product(45, "Juice", 3));}};
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

    public Main() {
        View view = new ConsoleView();
        Terminal terminal = new Terminal(view);
        Controller controller = new Controller(terminal, view);
        controller.run();
    }

    public static void main(String[] args) {
        Main main = new Main();



/*
        Order order = new Order();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String params[] = scanner.nextLine().split(" ");
            if (params.length > 0) {
                if (params[0].equals(COMMANDS_ARRAY[0])) {
                    System.out.println(PRODUCTS_LIST_HEADER);
                    for (Product p : products) {
                        System.out.println(String.format(STRING_FORMAT_PRODUCTS,
                                p.getId(),
                                p.getPrice(),
                                p.getName()));
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[1])) {
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
                    order = new Order();
                } else {
                    System.out.println(String.format(STRING_FORMAT_ERROR,
                            COMMAND_NOT_FOUND));
                }
            }
        }
        */
    }
}
