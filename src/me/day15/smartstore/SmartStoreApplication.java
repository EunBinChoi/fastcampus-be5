package me.day15.smartstore;

import me.day15.smartstore.customers.Customer;
import me.day15.smartstore.customers.Customers;
import me.day15.smartstore.groups.Group;
import me.day15.smartstore.groups.Parameter;
import me.day15.smartstore.menu.*;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Groups;


public class SmartStoreApplication {

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static SmartStoreApplication smartStoreApp;

    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////

    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();
    private final MainMenu mainMenu = MainMenu.getInstance();


    public SmartStoreApplication test() {
        allGroups.add(new Group( GroupType.GENERAL, new Parameter(10, 100000)) );
        allGroups.add(new Group( GroupType.VIP, new Parameter(20, 200000)) );
        allGroups.add(new Group( GroupType.VVIP, new Parameter(30, 300000)) );

        for (int i = 0; i < 20; ++i) {
            allCustomers.add(new Customer(
                    Character.toString(
                               (char) ('a' + i)),
                        (char) ('a' + i) + "123",
                     ((int) (Math.random() * 5) + 1) * 10,
                       ((int) (Math.random() * 5) + 1) * 100000));
        }

        allCustomers.refresh(allGroups); // Customer 들의 Group 지정 (자동 배정)
        return this;
    }

    private void details() {
        System.out.println("\n\n===========================================");
        System.out.println(" Title : SmartStore Customer Segmentation");
        System.out.println(" Release Date : 23.05.16");
        System.out.println(" Copyright 2023 Eunbin All rights reserved.");
        System.out.println("===========================================\n");
    }

    public void run() {
        details();

        mainMenu.manage();
    }
}
