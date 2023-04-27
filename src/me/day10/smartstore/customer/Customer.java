package me.day10.smartstore.customer;

import me.day10.smartstore.group.Group;

import java.util.Objects;

public class Customer {
    private String cusName;
    private String cusId;
    private Integer cusTotalTime;
    private Integer cusTotalPay;
    private Group group; // 현재 분류 기준에 의해 각 고객을 분류된 결과

    public Customer() {
    }

    public Customer(String cusId) {
        this.cusId = cusId;
    }

    public Customer(String cusName, String cusId) {
        this.cusName = cusName;
        this.cusId = cusId;
    }

    public Customer(String cusName, String cusId, Integer cusTotalTime, Integer cusTotalPay) {
        this.cusName = cusName;
        this.cusId = cusId;
        this.cusTotalTime = cusTotalTime;
        this.cusTotalPay = cusTotalPay;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public Integer getCusTotalTime() {
        return cusTotalTime;
    }

    public void setCusTotalTime(Integer cusTotalTime) {
        this.cusTotalTime = cusTotalTime;
    }

    public Integer getCusTotalPay() {
        return cusTotalPay;
    }

    public void setCusTotalPay(Integer cusTotalPay) {
        this.cusTotalPay = cusTotalPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cusId, customer.cusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusName='" + cusName + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cusTotalTime=" + cusTotalTime +
                ", cusTotalPay=" + cusTotalPay +
                '}';
    }
}
