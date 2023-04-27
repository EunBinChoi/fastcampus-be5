package me.day10.smartstore.menu;

import me.day09.exception_practice.practice04.exception.InputRangeException;
import me.day10.smartstore.util.Message;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // singleton
    private static Menu menu;
    public Scanner scanner = new Scanner(System.in);

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    private Menu() {}

    public String nextLine() { // 하나의 프로그램 상에서 nextLine() 함수를 통해서 사용자 입력을 받음
        String str = scanner.nextLine().toUpperCase();
        return str;
    }

    public int dispMenu(String[] menus) {
        while ( true ) { // 예외 복구 while
            try {
                System.out.println("===============================");
                for (int i = 0; i < menus.length; i++) {
                    System.out.printf(" %d. %s\n", i + 1, menus[i]);
                }
                System.out.println("===============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(nextLine());
                if (choice >= 1 && choice <= menus.length) return choice;
                throw new InputRangeException(); // choice 가 범위에 벗어남

            } catch (InputMismatchException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_FORMAT);

            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);

            }
        }
    }
}
