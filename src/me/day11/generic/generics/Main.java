package me.day11.generic.generics;

public class Main {
    public static void main(String[] args) {
        GiftBox<Tablet> randomGiftBox1 = new GiftBox<>(); // 컴파일러가 문맥을 통해 확인
        randomGiftBox1.setGift(new Tablet(12, "IPAD4-PRO"));
        Tablet tablet = randomGiftBox1.getGift();
        System.out.println(tablet);

        randomGiftBox1.getGift().setInch(14);
        System.out.println(tablet);
        System.out.println();

        ////////////////////////////////////////////////////////////////////
        GiftBox<SmartPhone> randomGiftBox2 = new GiftBox<>();
        randomGiftBox2.setGift(new SmartPhone("IPHONE14-PRO"));
        SmartPhone smartPhone = randomGiftBox2.getGift();
        System.out.println(smartPhone);

        randomGiftBox2.getGift().setModelName("IPHONE14-MAX");
        System.out.println(smartPhone);

    }
}
