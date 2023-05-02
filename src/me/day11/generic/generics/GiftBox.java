package me.day11.generic.generics;

import java.util.Objects;

public class GiftBox<T> { // T: type, E: element, K - V: key-value
    private T gift;

    public GiftBox() {}

    public GiftBox(T gift) {
        this.gift = gift;
    }

    public T getGift() {
        return gift;
    }

    public void setGift(T gift) {
        this.gift = gift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftBox that = (GiftBox) o;
        return gift.equals(that.gift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gift);
    }

    @Override
    public String toString() {
        return "RandomGiftBox{" +
                "gift=" + gift +
                '}';
    }
}