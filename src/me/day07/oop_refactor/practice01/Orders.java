package me.day07.oop_refactor.practice01;


public class Orders extends DArray<Orders> {
    // not singleton class
    // 각각의 Member가 다른 Orders 공간을 가져야하기 때문


    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (arrays[i] + "\n");
        }
        return toStr;
    }
}
