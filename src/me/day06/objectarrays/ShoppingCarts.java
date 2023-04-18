package me.day06.objectarrays;

import java.util.Arrays;
import java.util.Comparator;

public class ShoppingCarts {
    // not singleton class
    // 각각의 Member가 다른 ShoppingCarts 공간을 가져야하기 때문

    private ShoppingCart[] shoppingCarts;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    public ShoppingCarts() {
        shoppingCarts = new ShoppingCart[DEFAULT];
        capacity = DEFAULT;
    }

    public ShoppingCarts(int initial) {
        shoppingCarts = new ShoppingCart[initial];
        capacity = initial;
    }

    public ShoppingCarts(ShoppingCart[] shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
        capacity = shoppingCarts.length;
        size = shoppingCarts.length;
    }

    public ShoppingCart[] getShoppingCarts() {
        return shoppingCarts;
    }

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)
    public int size() {
        return size;
    }

    private int capacity() {
        return capacity;
    }


    public ShoppingCart get(int index) {
        if (index < 0 || index >= size) return null;
        return shoppingCarts[index];
    }

    public void set(int index, ShoppingCart shoppingCart) {
        if (index < 0 || index >= size) return;
        if (shoppingCart == null) return;

        shoppingCarts[index] = shoppingCart;
    }

    public int indexOf(ShoppingCart shoppingCart) {
        if (shoppingCart == null) return -1; // not found.

        for (int i = 0; i < size; i++) {
            if (shoppingCarts[i] == null) continue;
            if (shoppingCarts[i].equals(shoppingCart)) return i;
        }
        return -1; // not found.
    }

    public void add(ShoppingCart shoppingCart) {
        if (shoppingCart == null) return;

        if (size < capacity) {
            shoppingCarts[size] = shoppingCart;
            size++;
        } else {
            grow();
            add(shoppingCart);
        }
    }

    public void add(int index, ShoppingCart shoppingCart) {
        if (index < 0 || index >= size) return;
        if (shoppingCart == null) return;

        if (size < capacity) {
            for (int i = shoppingCarts.length-1; i >= index; i--) {
                shoppingCarts[i+1] = shoppingCarts[i];
            }
            shoppingCarts[index] = shoppingCart;
            size++;
        } else {
            grow();
            add(shoppingCart);
        }
    }


    public ShoppingCart pop() {
        return pop(size-1);
    }

    public ShoppingCart pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        ShoppingCart popElement = shoppingCarts[index];
        shoppingCarts[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            shoppingCarts[i-1] = shoppingCarts[i];
        }
        shoppingCarts[size-1] = null;
        size--;
        return popElement;
    }


    public ShoppingCart pop(ShoppingCart shoppingCart) {
        return pop(indexOf(shoppingCart));
    }

    public void grow() {
        capacity *= 2; // doubling
        shoppingCarts = Arrays.copyOf(shoppingCarts, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public ShoppingCarts trimToSize() {
        shoppingCarts = Arrays.copyOf(shoppingCarts, size);
        capacity = size;

        return new ShoppingCarts(shoppingCarts);
    }
    /////////////////////////////////////////

    public Order ordered(String address) {
        if (size == 0) return null;

        ShoppingCarts ordered = new ShoppingCarts();
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (shoppingCarts[i].getSelected()) {
                ordered.add(shoppingCarts[i]);
                total += (shoppingCarts[i].getShoppingItem().getPrice() * shoppingCarts[i].getQuantity());

                shoppingCarts[i].setOrdered(true);
            }
        }

        Order order = new Order(address, ordered);
        order.setPayment(total);

        removeOrderedItems();
        return order;
    }

    private void removeOrderedItems() {
        if (size == 0) return;

        for (int i = size-1; i >= 0; i--) {
            if (shoppingCarts[i].getOrdered()) pop(shoppingCarts[i]);
        }
    }

    enum Sort {ASC, DESC}

    public void sortByTime(Sort sortMethod) {
        int comp = (sortMethod == Sort.ASC) ? 1 : -1;
        Arrays.sort(shoppingCarts, new Comparator<ShoppingCart>() {
            @Override
            public int compare(ShoppingCart o1, ShoppingCart o2) {
                return comp*(o1.getShoppingTime().compareTo(o2.getShoppingTime()));
            }
        });
    }


    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (shoppingCarts[i] + "\n");
        }
        return toStr;
    }

}
