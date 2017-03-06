package com.avseredyuk;

import java.util.Scanner;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Main {
    static final String[] COMMANDS_ARRAY =
            {"list"};

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String params[] = scanner.nextLine().split(" ");
            if (params.length > 0) {
                if (params[0].equals(COMMANDS_ARRAY[0])) {
                    // list smth
                }
            }
        }
    }
}
