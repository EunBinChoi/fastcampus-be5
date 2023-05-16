package me.day14.junit_practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    public void 손님이_선택한_물품가격을_투입금액에서_차감한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        assertEquals(350, vm.getMoney(), "손님이 선택한 물품 가격을 투입 금액에서 차감한다");
    }

    @Test
    public void 손님이_구매하기위해_넣은금액을_확인한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        int money = vm.getMoney();

        assertNotNull(money);
    }

    @Test
    public void 손님이_넣은_금액이_0이하일수없다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(-1);
//        vm.setInputMoney(1000);

        assertTrue(vm.getMoney() > 0, "투입 금액은 0이하 일수 없다");
    }
}
