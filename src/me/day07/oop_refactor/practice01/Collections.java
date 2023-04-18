package me.day07.oop_refactor.practice01;

public interface Collections<T> {
    int size();
    T get(int index);
    void set(int index, T object);
    int indexOf(T object);
    void add(T object);
    void add(int index, T object);
    T pop();
    T pop(int index);
    T pop(T object);
}
