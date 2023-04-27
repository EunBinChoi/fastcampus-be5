package me.day10.smartstore;

import me.day10.smartstore.customer.Customer;
import me.day10.smartstore.customer.Customers;
import me.day10.smartstore.group.Group;
import me.day10.smartstore.group.GroupType;
import me.day10.smartstore.group.Groups;
import me.day10.smartstore.group.Parameter;
import me.day10.smartstore.menu.Menu;

public class SmartStoreApp {
    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();
    private final Menu menu = Menu.getInstance();

    // singleton
    private static SmartStoreApp smartStoreApp;

    public static SmartStoreApp getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApp();
        }
        return smartStoreApp;
    }

    private SmartStoreApp() {}

    public void details() {
        System.out.println("\n\n===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println(" Release Date : 23.04.27");
        System.out.println(" Copyright 2023 Eunbin All rights reserved.");
        System.out.println("===========================================\n");
    }

    public SmartStoreApp test() {
        allGroups.add(new Group(new Parameter(10, 100000), GroupType.GENERAL));
        allGroups.add(new Group(new Parameter(20, 200000), GroupType.VIP));
        allGroups.add(new Group(new Parameter(30, 300000), GroupType.VVIP));

        for (int i = 0; i < 26; i++) {
            allCustomers.add(new Customer(
                    Character.toString(
                            (char) ('a' + i)),
                    (char) ('a' + i) + "123",
                    ((int) (Math.random() * 5) + 1) * 10,
                    ((int) (Math.random() * 5) + 1) * 100000));
        }

        System.out.println("allCustomers = " + allCustomers);
        System.out.println("allGroups = " + allGroups);

        // @TODO: refresh do not implemented yet.
        allCustomers.refresh(allGroups);

        return this; // smartStoreApp
    }

    public void run() {
        details();

        while ( true ) { // 프로그램 실행 while
            int choice = menu.dispMenu(new String[] {
                    "Group",
                    "Customer",
                    "Classification Summary",
                    "Quit"});

//            if (choice == 1) group();
//            else if (choice == 2) customer();
//            else if (choice == 3) summary();
//            else if (choice == 4) { System.out.println("Program Finished"); break; }
        }

    }
}
