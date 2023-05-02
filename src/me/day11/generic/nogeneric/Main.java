package me.day11.generic.nogeneric;

public class Main {
    public static void main(String[] args) {
        GiftBox randomGiftBox1 = new GiftBox();
        randomGiftBox1.setGift(new Tablet(12, "IPAD4-PRO"));
        if (randomGiftBox1.getGift() instanceof Tablet) {
            Tablet tablet = (Tablet) randomGiftBox1.getGift(); // Object -> Tablet
            System.out.println(tablet);

            ((Tablet) (randomGiftBox1.getGift())).setInch(14);
            System.out.println(tablet);
        } else {
            System.out.println("Can't Cast");
        }
        System.out.println();


        ////////////////////////////////////////////////////////////////////
        GiftBox randomGiftBox2 = new GiftBox();
        randomGiftBox2.setGift(new SmartPhone("IPHONE14-PRO"));
        if (randomGiftBox2.getGift() instanceof SmartPhone) {
            SmartPhone smartPhone = (SmartPhone) randomGiftBox2.getGift(); // Object -> SmartPhone
            System.out.println(smartPhone);

            ((SmartPhone) (randomGiftBox2.getGift())).setModelName("IPHONE14-MAX");
            System.out.println(smartPhone);
        } else {
            System.out.println("Can't Cast");
        }
    }
}
