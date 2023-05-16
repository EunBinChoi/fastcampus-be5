package me.day14.junit_practice;

public class VendingMachine {
    private int money;
    private int selectedProduct;

    public VendingMachine() {
    }

    public int getMoney() {
        return money;
    }

    public void setInputMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("투입 금액은 0보다 커야 합니다. : " + money);
        }
        this.money += money;
    }

    public void setSelectedProduct(int selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getSelectedProduct() {
        return selectedProduct;
    }

    public int inputMoneyAndProductDeduct() {
        money -= selectedProduct;
        return money;
    }

}