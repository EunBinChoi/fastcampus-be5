package me.day05.objectarrays;

import java.util.Arrays;

public class ShoppingItems {
    // singleton
    private static ShoppingItems allShoppingItem;
    public static ShoppingItems getInstance() {
        if (allShoppingItem == null) {
            allShoppingItem = new ShoppingItems();
        }
        return allShoppingItem;
    }

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

    public void init() {
        for (int i = 0; i < 10; i++) {
            allShoppingItem.add(new ShoppingItem(
                    Character.toString('a' + i),
                    ShoppingItem.Category.values()[i % (ShoppingItem.Category.values().length)],
                    i * 1000
            ));
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private boolean isNull() {
        return shoppingItems == null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isValid(int index) {
        if (index < 0 || index > size) return false;
        return true;
    }

    public void set(int index, ShoppingItem shoppingItem) {
        if (isValid(index)) return;
        if (shoppingItem == null) return;

        shoppingItems[index] = shoppingItem;
    }

    public ShoppingItem get(int index) {
        if (isValid(index)) return null;
        return shoppingItems[index];
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
        if (isValid(index)) return;
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

    public void grow() {
        ShoppingItem[] copied = Arrays.copyOf(shoppingItems, shoppingItems.length);
        capacity *= 2; // doubling.
        shoppingItems = new ShoppingItem[capacity];

        System.arraycopy(copied, 0, shoppingItems, 0, copied.length);
        size = copied.length;
    }


    public void pop(int index) {
        if (size == 0) return;
        if (!(index >= 0 && index < size)) return;

        shoppingItems[index] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = index + 1; j < size; j++) {
            shoppingItems[j - 1] = shoppingItems[j];
        }

        shoppingItems[size - 1] = null;
        size--;
    }

    public void pop() {
        if (size == 0) return;

        shoppingItems[size - 1] = null;
        size--;
    }

    public void pop(ShoppingItem shoppingItem) {
        if (size == 0) return;
        if (shoppingItem == null) return;

        pop(indexOf(shoppingItem));
    }

    public ShoppingItems trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        ShoppingItem[] newShoppingItem = new ShoppingItem[size];
        System.arraycopy(shoppingItems, 0, newShoppingItem, 0, size);

        shoppingItems = newShoppingItem;
        capacity = size;

        return new ShoppingItems(newShoppingItem);
    }

    @Override
    public String toString() {
        return "ShoppingItems{" +
                "shoppingItems=" + Arrays.toString(shoppingItems) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
