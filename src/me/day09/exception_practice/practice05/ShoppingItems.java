package me.day09.exception_practice.practice05;

public class ShoppingItems extends DArray<ShoppingItem> {
    /////////////////////////////////////////
    // singleton
    private static ShoppingItems allShoppingItems;
    public static ShoppingItems getInstance() {
        if (allShoppingItems == null) {
            allShoppingItems = new ShoppingItems();
        }
        return allShoppingItems;
    }
    /////////////////////////////////////////

    public void init() {
        for (int i = 0; i < 10; i++) {
            allShoppingItems.add(new ShoppingItem(
                    Character.toString('a' + i),
                    ShoppingItem.Category.values()[i % (ShoppingItem.Category.values().length)],
                    (i+1) * 1000
            ));
        }
    }

}
