package me.day05.assignment03.practice03;

import java.util.Arrays;

public class Users {
    /////////////////////////////////////////
    // singleton
    private static Users allUsers;

    // 실습 2-1
    public static Users getInstance() {
        if (allUsers == null) {
            allUsers = new Users();
        }
        return allUsers;
    }
    /////////////////////////////////////////

    private User[] userList;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Users() {
        userList = new User[DEFAULT];
        capacity = DEFAULT;
    }
    private Users(int initial) {
        userList = new User[initial];
        capacity = initial;
    }

    private Users(User[] userList) {
        this.userList = userList;
        capacity = userList.length;
        size = userList.length;
    }

    public User[] getUsers() {
        return userList;
    }

    public void init() { // Users 초기화
        for (int i = 0; i < 10; i++) {
            allUsers.add(new User(Character.toString('a' + i),
                    Character.toString('a' + i) + "1234"));
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

    public User get(int index) {
        if (index < 0 || index >= size) return null;
        return userList[index];
    }

    public void set(int index, User user) {
        if (index < 0 || index >= size) return;
        if (user == null) return;

        userList[index] = user;
    }

    public int indexOf(User user) {
        if (user == null) return -1; // not found (instead of throwing exception)

        for (int i = 0; i < size; i++) {
            if (userList[i] == null) continue;
            if (userList[i].equals(user)) return i;
        }
        return -1; // not found
    }

    // 배열의 cap이 부족한 경우
    public void add(User user) {
        if (user == null) return; // if argument is null, do not add null value in array

        if (size < capacity) {
            userList[size] = user;
            size++;
        } else {
            grow();
            add(user);
        }
    }

    public void add(int index, User user) {
        if (index < 0 || index >= size) return;
        if (user == null) return;

        if (size < capacity) {
            for (int i = size-1; i >= index ; i--) {
                userList[i+1] = userList[i];
            }
            userList[index] = user;
            size++;
        } else {
            grow();
            add(index, user);
        }
    }

    public User pop() {
//        if (size == 0) return null;
//
//        Users popElement = userList[size-1];
//        userList[size-1] = null;
//        size--;
//        return popElement;
        return pop(size-1);
    }

    public User pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        User popElement = userList[index];
        userList[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            userList[i-1] = userList[i];
        }
        userList[size-1] = null;
        size--;
        return popElement;
    }

    public User pop(User user) {
        return pop(indexOf(user));
    }

    private void grow() {
        capacity *= 2; // doubling
        userList = Arrays.copyOf(userList, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public Users trimToSize() {
        userList = Arrays.copyOf(userList, size);
        capacity = size;

        return new Users(userList);
    }
    /////////////////////////////////////////

    // 실슴 2-2
    public User findByUserId(String userId) {
        if (userId == null) return null;

        for (int i = 0; i < size; i++) {
            if (userList[i] == null) continue;
            if (userList[i].equals(userId)) return userList[i];
        }
        return null;
    }

}
