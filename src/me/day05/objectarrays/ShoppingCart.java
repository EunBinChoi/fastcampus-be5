package me.day05.objectarrays;

import java.time.LocalDateTime;

public class ShoppingCart {

    private String shoppingCartNo; // auto-generated
    private ShoppingItem shoppingItem;
    private Integer quantity;
    private LocalDateTime shoppingTime;
    private Boolean isOrder;

    private static int AUTO_GEN = 0;

    public ShoppingCart() {
        AUTO_GEN++;
        shoppingCartNo = String.format("%08d", AUTO_GEN);
    }

    public ShoppingCart(String shoppingCartNo, ShoppingItem shoppingItem, Integer quantity, LocalDateTime shoppingTime, Boolean isOrder) {
        this();
        this.shoppingItem = shoppingItem;
        this.quantity = quantity;
        this.shoppingTime = shoppingTime;
        this.isOrder = isOrder;
    }

    public String getShoppingCartNo() {
        return shoppingCartNo;
    }

    public void setShoppingCartNo(String shoppingCartNo) {
        this.shoppingCartNo = shoppingCartNo;
    }

    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(LocalDateTime shoppingTime) {
        this.shoppingTime = shoppingTime;
    }

    public Boolean getOrder() {
        return isOrder;
    }

    public void setOrder(Boolean order) {
        isOrder = order;
    }
}
