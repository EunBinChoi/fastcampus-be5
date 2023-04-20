package me.day07.oop_practice.practice01;

public class DArray<T> implements Collections<T> { // Dynamic Array

    protected T[] arrays;
    protected static final int DEFAULT = 10;
    protected int size;
    protected int capacity;

    public DArray() {
        arrays = (T[]) new Object[DEFAULT];
        capacity = DEFAULT;
    }

    public DArray(int initial) {
        arrays = (T[]) new Object[initial];
        capacity = initial;
    }

    public DArray(T[] arrays) {
        this.arrays = arrays;
        capacity = arrays.length;
        size = arrays.length;
    }

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)

    @Override
    public int size() {
        return size;
    }

    // 배열에 얼마나 capacity 남아있는지 외부에 알려줄 필요가 없기 때문에 <protected>으로 정의
    protected int capacity() {
        return capacity;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return arrays[index];
    }

    @Override
    public void set(int index, T object) {
        if (index < 0 || index >= size) return;
        if (object == null) return;

        arrays[index] = object;
    }

    @Override
    public int indexOf(T object) {
        if (object == null) return -1; // not found (instead of throwing exception)

        for (int i = 0; i < size; i++) {
            if (arrays[i] == null) continue;
            if (arrays[i].equals(object)) return i;
        }
        return -1; // not found
    }

    // 배열의 cap이 부족한 경우
    @Override
    public void add(T object) {
        if (object == null) return; // if argument is null, do not add null value in array

        if (size < capacity) {
            arrays[size] = object;
            size++;
        } else {
            grow();
            add(object);
        }
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index >= size) return;
        if (object == null) return;

        if (size < capacity) {
            for (int i = size-1; i >= index ; i--) {
                arrays[i+1] = arrays[i];
            }
            arrays[index] = object;
            size++;
        } else {
            grow();
            add(index, object);
        }
    }

    @Override
    public T pop() {
//        if (size == 0) return null;
//
//        T popElement = arrays[size-1];
//        arrays[size-1] = null;
//        size--;
//        return popElement;
        return pop(size-1);
    }

    @Override
    public T pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        T popElement = arrays[index];
        arrays[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            arrays[i-1] = arrays[i];
        }
        arrays[size-1] = null;
        size--;
        return popElement;
    }

    @Override
    public T pop(T object) {
        return pop(indexOf(object));
    }

    protected void grow() {
        capacity *= 2; // doubling
        arrays = java.util.Arrays.copyOf(arrays, capacity);

        // size는 그대로
    }

    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (arrays[i] + "\n");
        }
        return toStr;
    }
}
