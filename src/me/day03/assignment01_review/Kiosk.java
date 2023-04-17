package me.day03.assignment01_review;

public class Kiosk {

    private static Kiosk kiosk;
    private static Menu[] selectedMenus;
    private static final int DEFAULT = 100;
    private static int numOfChoice = 0;

    // singleton
    public static Kiosk getInstance() {
        if (kiosk == null) {
            kiosk = new Kiosk();
        }
        return kiosk;
    }

    public Kiosk() {
        selectedMenus = new Menu[DEFAULT];
    }


    public void order(User user) {
        if (user.getOriginalMoney() < Menu.min()) {
            System.out.println("돈이 부족하여 김밥천국에 들어갈 수 없습니다.\n");
            return;
        }
        while(true) {
            Menu.printMenu();
            int choice = Utils.input("메뉴 주문 번호: ");

            if (choice == 5) {
                System.out.println("프로그램 종료.\n");
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("메뉴 선택오류. 1 ~ 5번 사이의 메뉴를 입력하세요.\n");
                continue;
            }

            Menu choiceMenu = Menu.values()[choice-1];

            if (user.getChange() < choiceMenu.getPrice()) {
                System.out.println("돈이 부족하여 메뉴를 선택할 수 없습니다.\n");
            } else {
                numOfChoice++;
                selectedMenus[numOfChoice-1] = choiceMenu;

                user.getPaid(choiceMenu.getPrice());
                System.out.println("선택한 메뉴는 " + choiceMenu.getName() + " 입니다.");
                System.out.println("잔돈은 " + user.getChange() + " 입니다.\n");
            }

            if (user.getChange() < Menu.min()) {
                System.out.println("더 이상 메뉴를 선택할 수 없습니다. 프로그램이 자동 종료 되었습니다.\n");
                break;
            }
        }

        summarizeOrders();
    }

    public void summarizeOrders() {
        if (numOfChoice > 0) {
            System.out.println("지금까지 선택하신 식사 주문이 완료되었습니다: ");

            int totalOrderPrice = 0;
            System.out.println("주문 내역");
            System.out.println("==================");
            for (int i = 0; i < numOfChoice; i++) {
                System.out.printf("%d. %s (%d)\n", i+1, selectedMenus[i].getName(), selectedMenus[i].getPrice());
                totalOrderPrice += selectedMenus[i].getPrice();
            }
            System.out.println("==================");
            System.out.println("총합: " + totalOrderPrice);

        }
    }
}
