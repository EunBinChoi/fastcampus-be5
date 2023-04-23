package me.day09.exception_practice.practice03;

import me.day09.exception_practice.practice03.exception.InsufficientBalanceException;
import me.day09.exception_practice.practice03.exception.NonPositiveException;

import java.math.BigDecimal;

public class ApplicationExceptionExample {
    public static void main(String[] args) {
        Account account = new Account("1111-222", "sally", new BigDecimal(1000000));

        // 1. deposit
        try {
            account.deposit(new BigDecimal(0));
            System.out.println("정상적으로 입금되었습니다.");
        } catch(NonPositiveException e) {
            System.out.println("입금할 금액이 잘못 입력되었습니다.");
        } catch(InsufficientBalanceException e) {
            System.out.println("잔고 금액이 부족합니다.");
            System.out.println(account + "의 현재 사용 가능한 금액은 " + account.getBalance() + " 입니다.");
        }
        System.out.println();

        // 2. withdraw
        try {
            account.withdraw(new BigDecimal(2000000));
            System.out.println("정상적으로 출금되었습니다.");
        } catch(NonPositiveException e) {
            System.out.println("출금할 금액이 잘못 입력되었습니다.");
        } catch(InsufficientBalanceException e) {
            System.out.println("잔고 금액이 부족합니다.");
            System.out.println(account + "의 현재 사용 가능한 금액은 " + account.getBalance() + " 입니다.");
        }
        System.out.println();
    }
}
