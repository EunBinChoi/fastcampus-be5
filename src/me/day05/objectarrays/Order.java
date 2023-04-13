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
    private String cardApprovalNumber;
    private Status orderStatus;

    private static int AUTO_GEN = 0;

    public Order() {
        AUTO_GEN++;
        orderNo = String.format("%08d", AUTO_GEN);
        orderTime = LocalDateTime.now(ZoneId.systemDefault());
        orderStatus = Status.PAY;
    }

    public Order(ShoppingCarts shoppingCarts, String cardApprovalNumber) {
        this();
        this.shoppingCarts = shoppingCarts;
        this.cardApprovalNumber = cardApprovalNumber;
    }

//    public Integer calculatePayment() {
//        int totalPayment = 0;
//        for (int i = 0; i < shoppingCarts.size(); i++) {
//            totalPayment += shoppingCarts.get(i).getShoppingItem().getPrice();
//        }
//        return totalPayment;
//    }

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

    public String getCardApprovalNumber() {
        return cardApprovalNumber;
    }

    public void setCardApprovalNumber(String cardApprovalNumber) {
        this.cardApprovalNumber = cardApprovalNumber;
    }

    public Status getorderStatus() {
        return orderStatus;
    }

    public void setorderStatus(Status orderStatus) {
        orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderNo, order.orderNo) && Objects.equals(shoppingCarts, order.shoppingCarts) && Objects.equals(orderTime, order.orderTime) && Objects.equals(payment, order.payment) && Objects.equals(cardApprovalNumber, order.cardApprovalNumber) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, shoppingCarts, orderTime, payment, cardApprovalNumber, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", shoppingCarts=" + shoppingCarts +
                ", orderTime=" + orderTime +
                ", payment=" + payment +
                ", cardApprovalNumber='" + cardApprovalNumber + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
