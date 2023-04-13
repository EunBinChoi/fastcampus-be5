package me.day05.objectarrays;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class Order {
    enum Status {PAY, READY_TO_DELIVERY, DELIVERY, FINISH_DELIVERY, EXCHANGE, REFUND}
    private String orderNo; // auto-generated
    private ShoppingCarts shoppingCarts;
    private LocalDateTime orderTime;
    private Integer payment; // with tax
    private Status orderStatus;

    private static int AUTO_GEN = 0;

    private Order() {
        AUTO_GEN++;
        orderNo = String.format("%08d", AUTO_GEN);
        shoppingCarts = ShoppingCarts.copyShoppingCartsOfSelected();
        orderTime = LocalDateTime.now(ZoneId.systemDefault());
        payment = shoppingCarts.getTotalPaymentOfSelected();
        orderStatus = Status.PAY;
    }

    public Order(ShoppingCarts shoppingCarts) {
        this();
        this.shoppingCarts = shoppingCarts;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ShoppingCarts getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ShoppingCarts shoppingCarts) {
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
        return Objects.equals(orderNo, order.orderNo) && Objects.equals(shoppingCarts, order.shoppingCarts) && Objects.equals(orderTime, order.orderTime) && Objects.equals(payment, order.payment) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, shoppingCarts, orderTime, payment, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", shoppingCarts=" + shoppingCarts +
                ", orderTime=" + orderTime +
                ", payment=" + payment +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
