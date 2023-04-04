package me.day03.review;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("얼마 가지고 있니? ");
        int totalMoney = scanner.nextInt();
        final int minPrice = Menu.min(); // 상수 (이후에는 배열로 계산하는 것이 좋음)

        if (totalMoney < minPrice) {
            System.out.println("입구컷,,,");
            return;
        }

        int num = 0; // 선택해서 주문 가능한 메뉴의 개수
        while(true) {
            Menu.printMenu();
            System.out.print("메뉴 주문 번호: ");
            int choice = scanner.nextInt(); // 메뉴 선택 번호
            if (choice == 5) {
                System.out.println("프로그램 종료.");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("메뉴 선택오류. 1 ~ 5번 사이의 메뉴를 입력하세요.");
                continue;
            }

            Menu choiceMenu = Menu.values()[choice-1];


//            if (choice == 1) {
//                choiceMenu = Menu.KIMBAB;
//                menuPrice = 2500;
//                menuName = "김밥";
//            } else if (choice == 2) {
//                choiceMenu = Menu.RAMEN;
//                menuPrice = 3000;
//                menuName = "라면";
//            } else if (choice == 3) {
//                choiceMenu = Menu.TBK;
//                menuPrice = 4000;
//                menuName = "떡볶이";
//            } else if (choice == 4) {
//                choiceMenu = Menu.DKS;
//                menuPrice = 5000;
//                menuName = "돈까스";
//            } else

            if (totalMoney < choiceMenu.getPrice()) {
                System.out.println("돈이 부족하여 메뉴를 선택할 수 없습니다.");
            } else {
                num++;
                totalMoney -= choiceMenu.getPrice();
                System.out.println("선택한 메뉴는 " + choiceMenu.getName() + " 입니다.");
                System.out.println("잔돈은 " + totalMoney + " 입니다.");
            }

            if (totalMoney < minPrice) {
                System.out.println("더 이상 메뉴를 선택할 수 없습니다. 프로그램 종료");
                break;
            }
         }

        if (num > 0) {
            System.out.println("지금까지 선택하신 식사 주문이 완료되었습니다.");
        }
    }

}
