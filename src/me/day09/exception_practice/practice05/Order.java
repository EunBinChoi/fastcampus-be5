package me.day09.exception_practice.practice05;

import me.day10.smartstore.arrays.DArray;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class Order {
    enum Status {PAY, READY_TO_DELIVERY, DELIVERY, FINISH_DELIVERY, EXCHANGE, REFUND}
    private String orderNo;
    private String orderAddress;

    private DArray<ShoppingCart> shoppingCarts;
    private LocalDateTime orderTime;
    private Integer payment; // with tax
    private Status orderStatus;

    private static int AUTO_GEN = 0;

    private Order() {
        AUTO_GEN++;
        orderNo = String.format("%08d", AUTO_GEN);
        orderTime = LocalDateTime.now(ZoneId.systemDefault());
        orderStatus = Status.PAY;
    }

    public Order(String orderAddress) {
        this();
        this.orderAddress = orderAddress;
    }

    public Order(DArray<ShoppingCart> shoppingCarts) {
        this();
        this.shoppingCarts = shoppingCarts;
    }

    public Order(String orderAddress, DArray<ShoppingCart> shoppingCarts) {
        this();
        this.orderAddress = orderAddress;
        this.shoppingCarts = shoppingCarts;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public DArray<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(DArray<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderNo, order.orderNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", shoppingCarts=" + shoppingCarts +
                ", orderTime=" + orderTime +
                ", payment=" + payment +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
