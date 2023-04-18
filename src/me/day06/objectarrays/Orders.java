package me.day06.objectarrays;

import java.util.Arrays;

public class Orders {
    // not singleton class
    // 각각의 Member가 다른 Orders 공간을 가져야하기 때문

    private Order[] orders;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;


    public Orders() {
        orders = new Order[DEFAULT];
        capacity = DEFAULT;
    }

    public Orders(int initial) {
        orders = new Order[initial];
        capacity = initial;
    }

    public Orders(Order[] orders) {
        this.orders = orders;
        capacity = orders.length;
        size = orders.length;
    }

    public Order[] getOrders() {
        return orders;
    }

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)
    public int size() {
        return size;
    }

    private int capacity() {
        return capacity;
    }


    public Order get(int index) {
        if (index < 0 || index >= size) return null;
        return orders[index];
    }

    public void set(int index, Order order) {
        if (index < 0 || index >= size) return;
        if (order == null) return;

        orders[index] = order;
    }

    public int indexOf(Order order) {
        if (order == null) return -1; // not found.

        for (int i = 0; i < size; i++) {
            if (orders[i] == null) continue;
            if (orders[i].equals(order)) return i;
        }
        return -1; // not found.
    }

    public void add(Order order) {
        if (order == null) return;

        if (size < capacity) {
            orders[size] = order;
            size++;
        } else {
            grow();
            add(order);
        }
    }

    public void add(int index, Order order) {
        if (index < 0 || index >= size) return;
        if (order == null) return;

        if (size < capacity) {
            for (int i = orders.length-1; i >= index; i--) {
                orders[i+1] = orders[i];
            }

            orders[index] = order;
            size++;
        } else {
            grow();
            add(order);
        }
    }


    public Order pop() {
        return pop(size-1);
    }

    public Order pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        Order popElement = orders[index];
        orders[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            orders[i-1] = orders[i];
        }
        orders[size-1] = null;
        size--;
        return popElement;
    }


    public Order pop(Order order) {
        return pop(indexOf(order));
    }

    public void grow() {
        capacity *= 2; // doubling
        orders = Arrays.copyOf(orders, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public Orders trimToSize() {
        orders = Arrays.copyOf(orders, size);
        capacity = size;

        return new Orders(orders);
    }
    /////////////////////////////////////////

    /////////////////////////////////////////
    // 프로그램 기능 구현을 위한 메소드
    public Orders groupByStatus(Order.Status status) {
        if (status == null) return null;
        Orders group = new Orders();

        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderStatus() == status) { // enum equals() (X) => == (O)
                group.add(orders[i]);
            }
        }
        return (group.size == 0) ? null : group;
    }

    /////////////////////////////////////////

    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (orders[i] + "\n");
        }
        return toStr;
    }
}
