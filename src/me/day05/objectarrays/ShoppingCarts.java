package me.day05.objectarrays;

import java.util.Arrays;
import java.util.Random;

public class ShoppingCarts {
    // singleton
    private static ShoppingCarts allShoppingCarts;
    public static ShoppingCarts getInstance() {
        if (allShoppingCarts == null) {
            allShoppingCarts = new ShoppingCarts();
        }
        return allShoppingCarts;
    }

    private ShoppingCart[] shoppingCarts;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private ShoppingCarts() {
        shoppingCarts = new ShoppingCart[DEFAULT];
        capacity = DEFAULT;
    }
    private ShoppingCarts(int initial) {
        shoppingCarts = new ShoppingCart[initial];
        capacity = initial;
    }

    private ShoppingCarts(ShoppingCart[] shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
        capacity = shoppingCarts.length;
        size = shoppingCarts.length;
    }

    private ShoppingCart[] getShoppingCarts() {
        return shoppingCarts;
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
        return shoppingCarts == null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isValid(int index) {
        if (index < 0 || index > size) return false;
        return true;
    }

    public void set(int index, ShoppingCart shoppingCart) {
        if (isValid(index)) return;
        if (shoppingCart == null) return;

        shoppingCarts[index] = shoppingCart;
    }

    public ShoppingCart get(int index) {
        if (isValid(index)) return null;
        return shoppingCarts[index];
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
            shoppingCarts[size] =shoppingCart;
            size++;
        } else {
            grow();
            add(shoppingCart);
        }
    }

    public void add(int index, ShoppingCart shoppingCart) {
        if (isValid(index)) return;
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

    public void grow() {
        ShoppingCart[] copied = Arrays.copyOf(shoppingCarts, shoppingCarts.length);
        capacity *= 2; // doubling.
        shoppingCarts = new ShoppingCart[capacity];

        System.arraycopy(copied, 0, shoppingCarts, 0, copied.length);
        size = copied.length;
    }


    public void pop(int index) {
        if (size == 0) return;
        if (!(index >= 0 && index < size)) return;

        shoppingCarts[index] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = index + 1; j < size; j++) {
            shoppingCarts[j - 1] = shoppingCarts[j];
        }

        shoppingCarts[size - 1] = null;
        size--;
    }

    public void pop() {
        if (size == 0) return;

        shoppingCarts[size - 1] = null;
        size--;
    }

    public void pop(ShoppingCart shoppingCart) {
        if (size == 0) return;
        if (shoppingCart == null) return;

        pop(indexOf(shoppingCart));
    }

    public ShoppingCarts trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        ShoppingCart[] newShoppingCarts = new ShoppingCart[size];
        System.arraycopy(shoppingCarts, 0, newShoppingCarts, 0, size);

        shoppingCarts = newShoppingCarts;
        capacity = size;

        return new ShoppingCarts(newShoppingCarts);
    }

    public Order order() {
        ShoppingCarts selectedOrder = copyShoppingCartsOfSelected();
        for (int i = 0; i < selectedOrder.size; i++) {
            selectedOrder.get(i).setOrdered(true);
        }
        return new Order(selectedOrder);
    }

    public Integer getTotalPaymentOfSelected() {
        int totals = 0;
        for (int i = 0; i < allShoppingCarts.size(); i++) {
            ShoppingCart shoppingCart = allShoppingCarts.get(i);
            if (shoppingCart.getSelected()) {
                totals += shoppingCart.getShoppingItem().getPrice();
            }
        }
        return totals;
    }

    public static ShoppingCarts copyShoppingCartsOfSelected() {
        return new ShoppingCarts(allShoppingCarts.getShoppingCarts());
    }




    @Override
    public String toString() {
        return "ShoppingCarts{" +
                "shoppingCarts=" + Arrays.toString(shoppingCarts) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
