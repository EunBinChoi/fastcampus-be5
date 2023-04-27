package me.day10.smartstore.customer;

import me.day10.smartstore.arrays.DArray;
import me.day10.smartstore.group.Groups;

public class Customers extends DArray {

    // singleton
    private static Customers allCustomers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    private Customers() {}

    // refresh 함수가 호출되는 경우
    // 1. 분류기준 바뀔 때
    // 2. 새로운 고객이 들어올 때
    public void refresh(Groups groups) {

    }

}
