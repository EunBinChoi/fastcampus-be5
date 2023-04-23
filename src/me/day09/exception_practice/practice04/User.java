package me.day09.exception_practice.practice04;

import me.day09.exception_practice.practice04.exception.InsufficientBalanceException;
import me.day09.exception_practice.practice04.exception.NonPositiveException;

public class User {
    private String userNo;
    private int original;
    private int change;
    private static int AUTO_GENERATOR = 0;

    public User() {
        AUTO_GENERATOR++;
        userNo = String.format("%04d", AUTO_GENERATOR);

    }
    public User(int original) {
        this();
        this.original = original;
        this.change = original;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
        setChange(original);
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void pay(int price) throws NonPositiveException, InsufficientBalanceException {
        if (price <= 0) throw new NonPositiveException();
        if (change < price) throw new InsufficientBalanceException();
        change -= price;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo='" + userNo + '\'' +
                ", original=" + original +
                ", change=" + change +
                '}';
    }
}
