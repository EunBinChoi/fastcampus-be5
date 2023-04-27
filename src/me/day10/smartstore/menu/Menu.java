package me.day10.smartstore.menu;

import me.day09.exception_practice.practice04.exception.InputRangeException;
import me.day10.smartstore.exception.InputEndException;
import me.day10.smartstore.util.Message;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {
    Scanner scanner = new Scanner(System.in);

    default String nextLine() { // 하나의 프로그램 상에서 nextLine() 함수를 통해서 사용자 입력을 받음
        return scanner.nextLine().toUpperCase();
    }

    default String nextLine(String end) {
        System.out.println("** Press 'end', if you want to exit! **");
        String str = scanner.nextLine().toUpperCase();
        if (str.equals(end)) throw new InputEndException();
        return str;
    }

    default int chooseMenu(String[] menus) {
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

    void manage(); // 각 서브메뉴들을 관리하는 함수 (각 서브메뉴의 최상위 메뉴)
}
