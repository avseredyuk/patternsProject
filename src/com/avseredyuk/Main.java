package com.avseredyuk;

import com.avseredyuk.domain.Order;
import com.avseredyuk.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Main {
    private static final String STRING_FORMAT_PRODUCTS = "\t%d\t\t%d\t\t%s";
    private static final String PRODUCTS_LIST_HEADER = "\tID\t\tPRICE\tNAME";
    private static final String STRING_FORMAT_ERROR = "Error happened: %s";
    private static final String STRING_FORMAT_ADDED = "Added: %s";
    private static final String STRING_FORMAT_BUCKET_ITEM = " * %s";
    private static final String COMMAND_NOT_FOUND = "Command not found";
    private static final String ILLEGAL_INPUT = "Illegal input";
    private static final String[] COMMANDS_ARRAY =
            {"list", "add", "showorder"};
    private static final List<Product> products = new ArrayList<Product>(){{
        add(new Product(25, "Tea", 1));
        add(new Product(35, "Coffee", 2));
        add(new Product(45, "Juice", 3));}};


    public static void main(String[] args) {

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
                                order.add(product);
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
                    for (Product p : order.getBucket()) {
                        System.out.println(String.format(STRING_FORMAT_BUCKET_ITEM, p.getName()));
                    }
                } else {
                    System.out.println(String.format(STRING_FORMAT_ERROR,
                            COMMAND_NOT_FOUND));
                }
            }
        }
    }
}
