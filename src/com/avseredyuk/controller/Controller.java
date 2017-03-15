package com.avseredyuk.controller;

import com.avseredyuk.model.Terminal;
import com.avseredyuk.view.ConsoleView;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class Controller {
    private static final String[] COMMANDS_ARRAY =
            {"list", "add", "coin", "checkout", "reset", "show"};
    private static final int[] COIN_VALUES =
            {1, 5, 10, 25, 50};

    private Terminal terminal;
    private ConsoleView view;

    public Controller(Terminal terminal, ConsoleView view) {
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
                    view.showProducts(terminal.getProducts());
                } else if (params[0].equals(COMMANDS_ARRAY[1])) {
                    if (params.length == 2) {
                        try {
                            String idString = params[1];
                            int id = Integer.valueOf(idString);
                            terminal.addProduct(id);
                            view.showOrder(terminal.getOrder());
                        } catch (NumberFormatException e) {
                            view.showIllegalInput();
                        }
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[2])) {
                    if (params.length == 2) {
                        try {
                            String coinString = params[1];
                            int coin = Integer.valueOf(coinString);

                            if (IntStream.of(COIN_VALUES).anyMatch(x -> x == coin)) {
                                terminal.addCoin(coin);
                                view.showOrder(terminal.getOrder());
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            view.showIllegalInput();
                        }
                    }
                } else if (params[0].equals(COMMANDS_ARRAY[3])) {
                    terminal.checkout();
                } else if (params[0].equals(COMMANDS_ARRAY[4])) {
                    terminal.resetOrder();
                    view.showOrder(terminal.getOrder());
                } else if (params[0].equals(COMMANDS_ARRAY[5])) {
                    view.showOrder(terminal.getOrder());
                } else {
                    view.showNoSuchCommand();
                }
            }
        }
    }

}
