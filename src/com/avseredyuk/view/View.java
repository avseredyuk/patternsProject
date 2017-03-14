package com.avseredyuk.view;

import com.avseredyuk.model.Product;

import java.util.List;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public interface View {
    void showGreeting();
    void showNoSuchCommand();
    void showProducts(List<Product> productList);
}
