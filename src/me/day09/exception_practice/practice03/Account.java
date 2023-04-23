package me.day09.exception_practice.practice03;

import me.day09.exception_practice.practice03.exception.BankingException;
import me.day09.exception_practice.practice03.exception.InsufficientBalanceException;
import me.day09.exception_practice.practice03.exception.NonPositiveException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private String accountNumber;
    private String owner;
    private BigDecimal balance; // 실수

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(String accountNumber, String owner, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBalance() {
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(balance);
    }

    public void setBalance(BigDecimal balance) throws NonPositiveException {
        if (balance.compareTo(BigDecimal.ONE) <= 0) throw new NonPositiveException();
        this.balance = balance;
    }

    public void deposit(BigDecimal depositMoney) throws NonPositiveException {
        if (depositMoney.compareTo(BigDecimal.ZERO) <= 0) throw new NonPositiveException();
        balance.add(depositMoney);
    }

    public void withdraw(BigDecimal withdrawMoney) throws NonPositiveException, InsufficientBalanceException {
        if (withdrawMoney.compareTo(BigDecimal.ZERO) <= 0) throw new NonPositiveException();
        if (balance.compareTo(withdrawMoney) < 0) throw new InsufficientBalanceException();
        balance.subtract(withdrawMoney);
    }

    @Override
    public String toString() {
        return "{계좌번호='" + accountNumber + '\'' +
                ", 소유자='" + owner + '\'' + '}';
    }
}
