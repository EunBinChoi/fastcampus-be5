package me.day15.smartstore.customers;

import me.day15.smartstore.groups.Group;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String userId;
    private String name;
    private Integer spentTime;
    private Integer totalPay;

    // @TODO: Group -> GroupType으로 변경
    private Group group;

    public Customer() {
    }

    public Customer(String name, String userId, int spentTime, int totalPay) {
        this.name = name;
        this.userId = userId;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Integer spentTime) {
        this.spentTime = spentTime;
    }

    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    @Override
    public int compareTo(Customer o) {
        if (name.compareTo(o.name) < 0) return -1;
        else if (name.compareTo(o.name) == 0) return userId.compareTo(o.userId);
        else return 1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(userId, customer.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", spentTime=" + spentTime +
                ", totalPay=" + totalPay +
                ", group=" + group.getType() +
                '}';
    }
}
