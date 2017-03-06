package com.avseredyuk.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/6/2017.
 */
public class Order {
    List<Product> bucket = new ArrayList<>();

    public void add(Product p) {
        bucket.add(p);
    }

    public List<Product> getBucket() {
        return bucket;
    }
}
