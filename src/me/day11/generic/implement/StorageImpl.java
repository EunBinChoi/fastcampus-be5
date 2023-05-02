package me.day11.generic.implement;


import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<T extends Clothes> implements Storage<T> {
    private static final int DEFAULT_SIZE = 10;
    private int capacity;

    private T[] list;
    private int size;

    public StorageImpl() {
        list = (T[]) new Clothes[DEFAULT_SIZE];
        this.capacity = DEFAULT_SIZE;
    }

    public StorageImpl(int capacity) {
        list = (T[]) new Clothes[capacity];
        this.capacity = capacity;
    }

    public T get(int i) {
        return list[i];
    }

    public void add(T element) {
        if (size < capacity) {
            list[size] = element;
            size++;
        } else {
            T[] origin = Arrays.copyOf(list, size);
            capacity *= 2;
            list = Arrays.copyOf(origin, capacity);
            add(element);
        }
    }

    public void remove(T element) {
        int elementIndex = -1;
        for (int i = 0; i < size; i++) {
            if (list[i] != null) {
                if (list[i].equals(element)) {
                    elementIndex = i;
                }
            }
        }
        if (elementIndex == -1) {
            System.out.println(element + " can't be found.");
        } else {
            list[elementIndex] = null;
            for (int i = elementIndex+1; i < size; i++) {
                list[i-1] = list[i];
            }
            size--;

            System.out.println(element + " removed successfully.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageImpl<?> storage = (StorageImpl<?>) o;
        return capacity == storage.capacity && size == storage.size && Arrays.equals(list, storage.list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, size);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }

    @Override
    public String toString() {
        return "StorageImpl{" +
                "capacity=" + capacity +
                ", list=" + Arrays.toString(list) +
                ", size=" + size +
                '}';
    }
}
