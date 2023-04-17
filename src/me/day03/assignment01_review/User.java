package me.day03.assignment01_review;

public class User {
    private String userNo;
    private int originalMoney;
    private int change;
    private static int AUTO_GENERATOR = 0;

    public User() {
        AUTO_GENERATOR++;
        userNo = String.format("%4d", AUTO_GENERATOR);

    }
    public User(int originalMoney) {
        this();
        this.originalMoney = originalMoney;
        this.change = originalMoney;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public int getOriginalMoney() {
        return originalMoney;
    }

    public void setOriginalMoney(int originalMoney) {
        this.originalMoney = originalMoney;
        setChange(originalMoney);
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void getPaid(int menuPrice) {
        this.change -= menuPrice;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo='" + userNo + '\'' +
                ", originalMoney=" + originalMoney +
                ", change=" + change +
                '}';
    }
}
