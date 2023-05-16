package me.day14.junit_practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeMoneyTest {
    @Test
    public void 손님에게_거스름돈을_반환한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        ChangeMoney cm = new ChangeMoney();
        cm.setChangeMoney(vm.getMoney());

        // 350 => 100 * 3 + 50 * 1
        int[] money = cm.getChangeMoney();
        assertEquals(0, money[0], "손님에게 반환 할 500원의 개수");
        assertEquals(3, money[1], "손님에게 반환 할 100원의 개수");
        assertEquals(1, money[2], "손님에게 반환 할 50원의 개수");
        assertEquals(0, money[3], "손님에게 반환 할 10원의 개수");
    }
}
