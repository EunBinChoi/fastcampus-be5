package me.day03.review;

public enum Menu { // class Enum

    // static final int KIMBAB = 0; (ordinal)
    KIMBAB(2500, "김밥"),

    // static final int KIMBAB = 1;
    RAMEN(3000, "라면"),

    // static final int KIMBAB = 2;
    TTEOK_BOK_KI(4000, "떡볶이"),

    // static final int KIMBAB = 3;
    PORK_CUTLET(5000, "돈까스");

    private int price = 0;
    private String name = "";

    Menu(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int min() {
        int minValue = Menu.values()[0].price; // 2500
        for (int i = 1; i < Menu.values().length; i++) {
            if (minValue > Menu.values()[i].price) {
                minValue = Menu.values()[i].price;
            }
        }
        return minValue; // 300
    }

    public static void printMenu() {
        System.out.println("메뉴");
        System.out.println("==================");
        for (int i = 0; i < Menu.values().length; i++) {
            System.out.printf("%d. %s (%d)\n", i+1, Menu.values()[i].getName(), Menu.values()[i].getPrice());
        }
        System.out.println("==================");
    }

    @Override // Object 클래스에서 상속받음
    public String toString() {
        return "Menu{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
