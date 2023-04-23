package me.day09.exception_practice.practice04;

import me.day07.assignment04.practice06.Person;
import me.day09.exception_practice.practice04.exception.*;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Kiosk {

    private static Kiosk kiosk;
    private static boolean[] selectedMenus;
    private static int[] selectedQuant;
    private static int menuLength = Menu.values().length;

    // singleton
    public static Kiosk getInstance() {
        if (kiosk == null) {
            kiosk = new Kiosk();
        }
        return kiosk;
    }

    private Kiosk() {
        selectedMenus = new boolean[menuLength];
        selectedQuant = new int[menuLength];
    }


    public void run(User user) {
        System.out.println("\n\n입장 전: " + user);
        chooseMenus();
        payOrders(user);

        reviseMenus();
        payOrders(user);
        System.out.println("\n\n입장 후: " + user);
    }

    public void payOrders(User user) {
        try {
            displayOrders();
            user.pay(getTotalPrice());
            System.out.println("결제 완료.");
        } catch (NonPositiveException e) {
            System.out.println("지불할 금액 오류.");
        } catch (InsufficientBalanceException e) {
            System.out.println("사용자 금액 부족.");
        }
    }

    public void chooseMenus() {
        while(true) {
            int choice = 0;
            try {
                choice = Utils.chooseMenu("메뉴 주문 번호: ");
            } catch (OutOfBoundsPossibleTriesException e) {
                System.out.println("입력오류. 입력가능한 횟수를 초과하였습니다.\n");
                break;
            } catch (ProgramExitException e) {
                System.out.println("프로그램 종료.\n");
                break;
            }

            try {
                selectedMenus[choice-1] = true;
                selectedQuant[choice-1]++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("인덱스 오류.\n");
            }
        }
    }


    public void reviseMenus() {
        while(true) {
            int choice = 0;
            try {
                choice = Utils.chooseMenu("취소할 메뉴 입력: ");
                displayOrder(choice-1);

                selectedMenus[choice-1] = false;
                selectedQuant[choice-1] = 0;

                System.out.println("취소 완료.");
                displayOrders();

            } catch (OutOfBoundsPossibleTriesException e) {
                System.out.println("입력오류. 입력가능한 횟수를 초과하였습니다.\n");
                break;
            } catch (ProgramExitException e) {
                System.out.println("프로그램 종료.\n");
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("인덱스 오류.\n");
            }
        }
    }

    public boolean isEmptyOrders() {
        for (int i = 0; i < selectedMenus.length; i++) {
            if (selectedMenus[i]) return false;
        }
        return true;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < selectedMenus.length; i++) {
            if (selectedMenus[i]) {
                total += (Menu.values()[i].getPrice() * selectedQuant[i]);
            }
        }
        return total;
    }


    public void displayOrder(int menuIndex) {
        System.out.println("\n주문내역");
        System.out.println("===================");
        if (selectedMenus[menuIndex]) {
            System.out.printf("%5s %5s\n", "이름", "개수");
            System.out.println("===================");
            System.out.printf("%5s %5d\n", Menu.values()[menuIndex].getName(), selectedQuant[menuIndex]);
        } else {
            System.out.println("주문한 내역이 없습니다.");
        }
        System.out.println("===================");
    }
    public void displayOrders() {
        if (isEmptyOrders()) {
            System.out.println("주문한 내역이 없습니다.");
            return;
        }

        System.out.println("\n주문내역");
        System.out.println("================================");
        for (int i = 0; i < menuLength; i++) {
            if (selectedMenus[i]) System.out.printf("%5s\t", Menu.values()[i].getName());

        }
        System.out.println("\n================================");
        for (int i = 0; i < menuLength; i++) {
            if (selectedMenus[i]) System.out.printf("%5d\t", selectedQuant[i]);
        }
        System.out.println("\n================================");
        System.out.printf(">> 주문한 금액: %s\n", NumberFormat.getCurrencyInstance(Locale.KOREA).format(getTotalPrice()));
    }
}
