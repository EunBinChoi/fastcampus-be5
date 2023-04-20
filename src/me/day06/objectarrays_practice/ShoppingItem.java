package me.day06.objectarrays_practice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class ShoppingItem {
    enum Category {OUTDOOR, TOP, BOTTOM, INNER, ACCESSORY}
    private String itemId; // sequential generated
    private String itemName;
    private Category category;
    private Integer price;
    private String details;

    private LocalDateTime registerTime;
    private static int AUTO_GEN = 0;

    private void autoGenerator() {
        AUTO_GEN++;
    }

    private ShoppingItem() {
        autoGenerator();
        itemId = String.format("%08d", AUTO_GEN);
        registerTime = LocalDateTime.now(ZoneId.systemDefault());
    }

    public ShoppingItem(String itemId) {
        this.itemId = itemId;
    }

    public ShoppingItem(String itemName, Category category, Integer price) {
        this();
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public ShoppingItem(String itemName, Category category, Integer price, String details) {
        this();
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.details = details;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItem that = (ShoppingItem) o;
        return Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
