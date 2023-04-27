package me.day10.smartstore.customer;

import java.util.Objects;

public class Customer {
    private String cName;
    private String cId;
    private Integer totalTime;
    private Integer totalPay;

    public Customer() {
    }

    public Customer(String cName, String cId) {
        this.cName = cName;
        this.cId = cId;
    }

    public Customer(String cName, String cId, Integer totalTime, Integer totalPay) {
        this.cName = cName;
        this.cId = cId;
        this.totalTime = totalTime;
        this.totalPay = totalPay;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cId, customer.cId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cName='" + cName + '\'' +
                ", cId='" + cId + '\'' +
                ", totalTime=" + totalTime +
                ", totalPay=" + totalPay +
                '}';
    }
}
