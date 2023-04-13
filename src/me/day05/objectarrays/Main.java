package me.day05.objectarrays;

import java.util.LinkedList;

public class Main {
    static Members members = Members.getInstance();
    public static void main(String[] args) {

        members.init();
        System.out.println(members);
        System.out.println();

        members.add(new Member("eunbin", "eunbin1234"));
        System.out.println(members);
        System.out.println();

    }
}
