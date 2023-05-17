package me.day15.smartstore.arrays;

public interface Collections<T> {
    // 데이터를 가지고 있는 객체가 아님
    // 구현 해야하는 메소드의 정보만 가지고 있음 (인터페이스)

    int size();
    T get(int index);
    void set(int index, T object);
    int indexOf(T object);
    void add(T object);
    void add(int index, T object);
    T pop();
    T pop(int index);
    T pop(T object);
    boolean isEmpty();
    boolean isNull();
}
