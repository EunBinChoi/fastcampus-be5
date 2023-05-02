package me.day11.generic.nogeneric;

import java.util.Objects;

public class GiftBox { // RandomGiftBox
    private Object gift;

    public GiftBox() {
    }

    public GiftBox(Object gift) {
        this.gift = gift;
    }

    public Object getGift() {
        return gift;
    }

    public void setGift(Object gift) {
        this.gift = gift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftBox giftBox = (GiftBox) o;
        return Objects.equals(gift, giftBox.gift);
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