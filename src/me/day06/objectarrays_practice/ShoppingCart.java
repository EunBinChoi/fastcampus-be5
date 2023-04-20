package me.day06.objectarrays_practice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class ShoppingCart {
    private String shoppingCartNo;
    private ShoppingItem shoppingItem;
    private Integer quantity;
    private LocalDateTime shoppingTime;
    private Boolean isSelected;
    private Boolean isOrdered;

    private static int AUTO_GEN = 0; // auto-generator.

    public ShoppingCart() {
        AUTO_GEN++;
        shoppingCartNo = String.format("%08d", AUTO_GEN);
        shoppingTime = LocalDateTime.now(ZoneId.systemDefault());
        isSelected = true;
        isOrdered  = false;
    }

    public ShoppingCart(String shoppingCartNo) {
        this.shoppingCartNo = shoppingCartNo;
    }

    public ShoppingCart(ShoppingItem shoppingItem) {
        this();
        this.shoppingItem = shoppingItem;
        this.quantity = 1;
    }

    public ShoppingCart(ShoppingItem shoppingItem, Integer quantity) {
        this();
        this.shoppingItem = shoppingItem;
        this.quantity = quantity;
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

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Boolean getOrdered() {
        return isOrdered;
    }

    public void setOrdered(Boolean ordered) {
        isOrdered = ordered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(shoppingCartNo, that.shoppingCartNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartNo);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartNo='" + shoppingCartNo + '\'' +
                ", shoppingItem=" + shoppingItem +
                ", quantity=" + quantity +
                ", shoppingTime=" + shoppingTime +
                ", isSelected=" + isSelected +
                ", isOrdered=" + isOrdered +
                '}';
    }
}
