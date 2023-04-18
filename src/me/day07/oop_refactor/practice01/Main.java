package me.day07.oop_refactor.practice01;

public class Main {
    static DArray<Member> members = new DArray<>();
    static DArray<ShoppingItem> shoppingItems = new DArray<>();


    public static void main(String[] args) {
        System.out.println("<<initialize>>");
        init();
        System.out.println(members);
        System.out.println(shoppingItems);
        System.out.println();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            members.add(new Member(Character.toString('a' + i),
                    Character.toString('a' + i) + "1234"));
        }

        for (int i = 0; i < 10; i++) {
            shoppingItems.add(new ShoppingItem(
                    Character.toString('a' + i),
                    ShoppingItem.Category.values()[i % (ShoppingItem.Category.values().length)],
                    (i+1) * 1000
            ));
        }
    }
}
