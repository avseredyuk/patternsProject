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
    public Main() {
        ConsoleView view = new ConsoleView();
        Terminal terminal = new Terminal(view);
        Controller controller = new Controller(terminal, view);
        controller.run();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
