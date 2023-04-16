package me.day05.objectarrays;

import java.util.Arrays;

public class ShoppingItems {
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

    private ShoppingItem[] shoppingItems;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private ShoppingItems() {
        shoppingItems = new ShoppingItem[DEFAULT];
        capacity = DEFAULT;
    }

    private ShoppingItems(int initial) {
        shoppingItems = new ShoppingItem[initial];
        capacity = initial;
    }

    private ShoppingItems(ShoppingItem[] shoppingItems) {
        this.shoppingItems = shoppingItems;
        capacity = shoppingItems.length;
        size = shoppingItems.length;
    }

    public ShoppingItem[] getShoppingItems() {
        return shoppingItems;
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            allShoppingItems.add(new ShoppingItem(
                    Character.toString('a' + i),
                    ShoppingItem.Category.values()[i % (ShoppingItem.Category.values().length)],
                    (i+1) * 1000
            ));
        }
    }

    /////////////////////////////////////////
    // CRUD (CREATE, READ, UPDATE, DELETE)
    public ShoppingItem select(String itemId) {
        if (itemId == null) return null;

        for (int i = 0; i < allShoppingItems.size(); i++) {
            if (allShoppingItems.get(i).equals(new ShoppingItem(itemId))) return allShoppingItems.get(i);
            // new ShoppingItem(itemId): create temporary shoppingCart instance with argument itemId.
        }
        return null;
    }

    public boolean insert(ShoppingItem shoppingItem) {
        if (shoppingItem == null) return false;
        if (shoppingItem.getItemId() == null) return false;

        // id duplicate check
        for (int i = 0; i < allShoppingItems.size(); i++) {
            if (allShoppingItems.get(i).equals(shoppingItem)) return false;
        }

        allShoppingItems.add(shoppingItem);
        return true;
    }

    public boolean update(ShoppingItem shoppingItem) {
        if (shoppingItem == null) return false;
        if (shoppingItem.getItemId() == null) return false;

        // find shoppingItem's index
        int idx = indexOf(shoppingItem);
        if (idx == -1) return false; // shoppingItem is not found to be updated.

        allShoppingItems.set(idx, shoppingItem);
        return true;
    }

    public boolean delete(String itemId) {
        if (itemId == null) return false;

        // find shoppingItem's index
        int idx = indexOf(new ShoppingItem(itemId));
        // new ShoppingItem(itemId): create temporary member instance with argument itemId.
        if (idx == -1) return false; // member is not found to be updated.

        allShoppingItems.pop(idx);
        return true;
    }
    /////////////////////////////////////////

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)
    public int size() {
        return size;
    }

    private int capacity() {
        return capacity;
    }


    public ShoppingItem get(int index) {
        if (index < 0 || index >= size) return null;
        return shoppingItems[index];
    }

    public void set(int index, ShoppingItem shoppingItem) {
        if (index < 0 || index >= size) return;
        if (shoppingItem == null) return;

        shoppingItems[index] = shoppingItem;
    }



    public int indexOf(ShoppingItem shoppingItem) {
        if (shoppingItem == null) return -1; // not found.

        for (int i = 0; i < size; i++) {
            if (shoppingItems[i] == null) continue;
            if (shoppingItems[i].equals(shoppingItem)) return i;
        }
        return -1; // not found.
    }

    public void add(ShoppingItem shoppingItem) {
        if (shoppingItem == null) return;

        if (size < capacity) {
            shoppingItems[size] =shoppingItem;
            size++;
        } else {
            grow();
            add(shoppingItem);
        }
    }

    public void add(int index, ShoppingItem shoppingItem) {
        if (index < 0 || index >= size) return;
        if (shoppingItem == null) return;

        if (size < capacity) {
            for (int i = shoppingItems.length-1; i >= index; i--) {
                shoppingItems[i+1] = shoppingItems[i];
            }

            shoppingItems[index] = shoppingItem;
            size++;
        } else {
            grow();
            add(shoppingItem);
        }
    }


    public ShoppingItem pop() {
        return pop(size-1);
    }

    public ShoppingItem pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        ShoppingItem popElement = shoppingItems[index];
        shoppingItems[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            shoppingItems[i-1] = shoppingItems[i];
        }
        shoppingItems[size-1] = null;
        size--;
        return popElement;
    }


    public ShoppingItem pop(ShoppingItem shoppingItem) {
        return pop(indexOf(shoppingItem));
    }

    public void grow() {
        capacity *= 2; // doubling
        shoppingItems = Arrays.copyOf(shoppingItems, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public ShoppingItems trimToSize() {
        shoppingItems = Arrays.copyOf(shoppingItems, size);
        capacity = size;

        return new ShoppingItems(shoppingItems);
    }
    /////////////////////////////////////////

    /////////////////////////////////////////
    // 프로그램 기능 구현을 위한 메소드
    public ShoppingItem searchByItemName(String itemName) {
        if (itemName == null) return null;

        for (int i = 0; i < size; i++) {
            if (shoppingItems[i] == null) return null;
            if (shoppingItems[i].getItemName() == null) return null;
            if (shoppingItems[i].getItemName().equals(itemName)) return shoppingItems[i];
        }
        return null;
    }

    public ShoppingItems searchByCategory(ShoppingItem.Category category) {
        if (category == null) return null;

        ShoppingItems groups = new ShoppingItems();
        for (int i = 0; i < size; i++) {
            if (shoppingItems[i] == null) return null;
            if (shoppingItems[i].getCategory() == null) return null;
            if (shoppingItems[i].getCategory() == category) groups.add(shoppingItems[i]);
        }
        return (groups.size == 0) ? null : groups;
    }

    /**
     * @param
     * start - minimum price to search items (inclusive)
     * end - maximum price to search items (exclusive)
     * */
    public ShoppingItems searchByPriceRange(int start, int end) {
        if (start >= end) return null;

        ShoppingItems groups = new ShoppingItems();
        for (int i = 0; i < size; i++) {
            if (shoppingItems[i] == null) return null;
            if (shoppingItems[i].getPrice() >= start && shoppingItems[i].getPrice() < end) {
                groups.add(shoppingItems[i]);
            }
        }
        return (groups.size == 0) ? null : groups;
    }
    /////////////////////////////////////////

    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (shoppingItems[i] + "\n");
        }
        return toStr;
    }
}
