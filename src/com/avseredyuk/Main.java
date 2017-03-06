package com.avseredyuk;

import com.avseredyuk.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Main {
    static final String STRING_FORMAT_PRODUCTS =
            "\t%d\t\t%d\t\t%s";
    static final String PRODUCTS_LIST_HEADER =
            "\tID\t\tPRICE\tNAME";
    static final String STRING_FORMAT_ERROR =
            "Error happened: %s";
    static final String[] COMMANDS_ARRAY =
            {"list", "add"};
    static final List<Product> products = new ArrayList<Product>(){{
        add(new Product(25, "Tea", 1));
        add(new Product(35, "Coffee", 2));
        add(new Product(45, "Juice", 3));}};

    public static void main(String[] args) {
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

                                //todo smth


                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(String.format(STRING_FORMAT_ERROR,
                                    "Illegal input"));
                        }
                    }
                }
            }
        }
    }
}
