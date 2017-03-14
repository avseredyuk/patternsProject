package com.avseredyuk.controller;

import com.avseredyuk.controller.command.CommandEnum;
import com.avseredyuk.model.Terminal;
import com.avseredyuk.view.View;

import java.util.Scanner;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public class Controller {
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
            //todo strategy here or command

            if (params.length > 0) {

                for (CommandEnum c: CommandEnum.values()) {
                    for(String s : c.getCommandsMap()) {
                        if (s.equals(params[0])) {

                        }
                    }
                }

                if (params[0].equals("list")) {
                    terminal.getProducts();
                } else {
                    view.showNoSuchCommand();
                }
            }



        }
    }

}
