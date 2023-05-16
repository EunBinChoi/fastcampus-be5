package me.day14.junit_practice;

import me.day14.junit_practice.exception.NullArgumentException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    static Scanner scanner = new Scanner(System.in);

    Integer inputMoney = 0;
    List<Drink> selectedDrinks = new LinkedList<>();
    ChangeModule changeModule;


    public VendingMachine(ChangeModule changeModule) {
        this.changeModule = changeModule;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(Integer inputMoney) {
        if (inputMoney == null) {
            throw new NullArgumentException("투입 금액은 널일 수 없습니다.");
        }
        if (inputMoney < 0) {
            throw new IllegalArgumentException(String.format("투입 금액 (%d)은 0보다 커야 합니다.", inputMoney));
        }
        this.inputMoney += inputMoney;
    }

    public Integer totalPrice() {
        if (selectedDrinks.size() == 0) {
            throw new RuntimeException("선택한 물건이 없습니다.");
        }
        return selectedDrinks.stream().mapToInt(Drink::getPrice).sum();
    }

    public void pay() {
        Integer total = totalPrice();
        if (inputMoney < total) {
            throw new RuntimeException(String.format("총 선택한 음료 금액 (%d)은 투입 금액 (%d)보다 작거나 같아야합니다.", total, inputMoney));
        }
        inputMoney -= total;
    }

    public CoinMap change() {
        return changeModule.getChangeCoinSet(inputMoney);
    }
}