package me.day10.smartstore.customer;

import me.day10.smartstore.arrays.DArray;

public class Customers extends DArray {

    // singleton
    private static Customers allCustomers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

}
