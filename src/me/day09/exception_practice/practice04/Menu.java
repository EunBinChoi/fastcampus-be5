package me.day09.exception_practice.practice04;

public enum Menu {
    KIMBAB(2500, "김밥"),
    RAMEN(3000, "라면"),
    TTEOK_BOK_KI(4000, "떡볶이"),
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
        int minValue = Menu.values()[0].price;

        for (int i = 1; i < Menu.values().length; i++) {
            if (minValue > Menu.values()[i].price) {
                minValue = Menu.values()[i].price;
            }
        }
        return minValue;
    }

    public static void printMenus() {
        System.out.println("\n메뉴");
        System.out.println("==================");
        int i = 0;
        for (i = 0; i < Menu.values().length; i++) {
            System.out.printf("%d. %s (%d)\n", i+1, Menu.values()[i].getName(), Menu.values()[i].getPrice());
        }
        System.out.printf("%d. %s\n", i+1, "종료");
        System.out.println("==================");
    }

    @Override
    public String toString() {
        return "Menu{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
