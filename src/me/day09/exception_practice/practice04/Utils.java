package me.day09.exception_practice.practice04;

import me.day09.exception_practice.practice04.exception.InputRangeException;
import me.day09.exception_practice.practice04.exception.OutOfBoundsPossibleTriesException;
import me.day09.exception_practice.practice04.exception.ProgramExitException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static int chooseMenu(String message) throws OutOfBoundsPossibleTriesException, ProgramExitException {
        int choiceError = 0;
        final int possibleTries = 5;
        Menu.printMenus();

        int choice = 0;
        while(true) {
            if (choiceError == possibleTries) throw new OutOfBoundsPossibleTriesException();

            System.out.print(message);
            try {
                choice = scanner.nextInt();
                if (choice == 5) throw new ProgramExitException();
                if (choice < 1 || choice > Menu.values().length) throw new InputRangeException();
                break;
            } catch (InputMismatchException e) {
                choiceError++;
                scanner.next();
                System.out.println("입력오류. 숫자를 입력하시오.\n");
            } catch (InputRangeException e) {
                choiceError++;
                System.out.println("메뉴 선택오류. 1 ~ 5번 사이의 메뉴를 입력하세요.\n");
            }
        }
        return choice;
    }

}
