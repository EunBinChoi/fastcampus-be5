package me.day10.smartstore.group;

import me.day10.smartstore.arrays.DArray;
import me.day10.smartstore.customer.Customers;

public class Groups extends DArray {
    // singleton
    private static Groups allGroups;

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }

    private Groups() {}
}
