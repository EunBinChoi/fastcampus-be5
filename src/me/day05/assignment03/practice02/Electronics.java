package me.day05.assignment03.practice02;

import java.util.Arrays;

public class Electronics {

    /////////////////////////////////////////
    // singleton
    private static Electronics allElectronics;

    // 실습 3-1
    public static Electronics getInstance() {
        if (allElectronics == null) {
            allElectronics = new Electronics();
        }
        return allElectronics;
    }
    /////////////////////////////////////////

    private Electronic[] electronicList;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Electronics() {
        electronicList = new Electronic[DEFAULT];
        capacity = DEFAULT;
    }

    public Electronics(int initial) {
        electronicList = new Electronic[initial];
        capacity = initial;
    }

    public Electronics(Electronic[] electronicList) {
        this.electronicList = electronicList;
        capacity = electronicList.length;
        size = electronicList.length;
    }

    public Electronic[] getElectronics() {
        return electronicList;
    }

    public void init() { // Electronics 초기화
        for (int i = 0; i < 10; i++) {
            allElectronics.add(new Electronic(
                    Character.toString('e' + i),
                    Electronic.Company.values()[i % Electronic.Company.values().length]
            ));
        }
    }

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)
    public int size() {
        return size;
    }

    // 배열에 얼마나 capacity 남아있는지 외부에 알려줄 필요가 없기 때문에 <private>으로 정의
    private int capacity() {
        return capacity;
    }

    public Electronic get(int index) {
        if (index < 0 || index >= size) return null;
        return electronicList[index];
    }

    public void set(int index, Electronic electronic) {
        if (index < 0 || index >= size) return;
        if (electronic == null) return;

        electronicList[index] = electronic;
    }

    public int indexOf(Electronic electronic) {
        if (electronic == null) return -1; // not found (instead of throwing exception)

        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].equals(electronic)) return i;
        }
        return -1; // not found
    }

    // 배열의 cap이 부족한 경우
    public void add(Electronic electronic) {
        if (electronic == null) return; // if argument is null, do not add null value in array

        if (size < capacity) {
            electronicList[size] = electronic;
            size++;
        } else {
            grow();
            add(electronic);
        }
    }

    public void add(int index, Electronic electronic) {
        if (index < 0 || index >= size) return;
        if (electronic == null) return;

        if (size < capacity) {
            for (int i = size-1; i >= index ; i--) {
                electronicList[i+1] = electronicList[i];
            }
            electronicList[index] = electronic;
            size++;
        } else {
            grow();
            add(index, electronic);
        }
    }

    public Electronic pop() {
//        if (size == 0) return null;
//
//        Electronics popElement = electronicList[size-1];
//        electronicList[size-1] = null;
//        size--;
//        return popElement;
        return pop(size-1);
    }

    public Electronic pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        Electronic popElement = electronicList[index];
        electronicList[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            electronicList[i-1] = electronicList[i];
        }
        electronicList[size-1] = null;
        size--;
        return popElement;
    }

    public Electronic pop(Electronic electronic) {
        return pop(indexOf(electronic));
    }

    private void grow() {
        capacity *= 2; // doubling
        electronicList = Arrays.copyOf(electronicList, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public Electronics trimToSize() {
        electronicList = Arrays.copyOf(electronicList, size);
        capacity = size;

        return new Electronics(electronicList);
    }
    /////////////////////////////////////////

    // 실습 3-2
    public Electronic findByProductNo(String productNo) {
        if (productNo == null) return null;

        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].equals(productNo)) return electronicList[i];
        }
        return null;
    }

    // 실습 3-3
    public Electronic[] groupByCompanyName(Electronic.Company company) {
        if (company == null) return null;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].getCompanyName() == null) continue;
            if (electronicList[i].getCompanyName() == company) count++;
        }

        Electronic[] group = new Electronic[count];
        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].getCompanyName() == null) continue;
            if (electronicList[i].getCompanyName() == company) {
                group[i] = electronicList[i];
            }
        }

        return group;
    }

    // 실습 3-4
    public Electronic[] groupByAuthMethod(Electronic.AuthMethod authMethod) {
        if (authMethod == null) return null;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].getAuthMethods() == null || electronicList[i].getAuthMethods().length == 0) continue;
            for (int j = 0; j < electronicList[i].getAuthMethods().length; j++) {
                if (electronicList[i].getAuthMethods()[j] == null) continue;
                if (electronicList[i].getAuthMethods()[j] == authMethod) {
                    count++;
                    break;
                }
            }
        }

        Electronic[] group = new Electronic[count];
        for (int i = 0; i < size; i++) {
            if (electronicList[i] == null) continue;
            if (electronicList[i].getCompanyName() == null || electronicList[i].getAuthMethods().length == 0) continue;
            for (int j = 0; j < electronicList[i].getAuthMethods().length; j++) {
                if (electronicList[i].getAuthMethods()[j] == null) continue;
                if (electronicList[i].getAuthMethods()[j] == authMethod) {
                    group[i] = electronicList[i];
                    break;
                }
            }
        }

        return group;
    }

}
