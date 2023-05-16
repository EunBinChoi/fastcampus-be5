package me.day14.junit_practice;

import me.day14.junit_practice.exception.NullArgumentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    ChangeModule cm;
    VendingMachine vm;


    @BeforeEach
    void 테스트_객체_생성() throws Exception {
        cm = new ChangeModule();
        vm = new VendingMachine(cm);
    }

    @AfterEach
    void 테스트_소멸_생성() throws Exception {
        cm = null;
        vm = null;
    }

    @Test
    void 투입_금액_널_테스트() throws Exception {
        assertThrows(NullArgumentException.class, () -> vm.setInputMoney(null));
    }

    @Test
    void 투입_금액_부족_테스트() throws Exception {
        vm.setInputMoney(1000);
        vm.selectedDrinks.add(new Drink("게토레이", 600));
        vm.selectedDrinks.add(new Drink("생수", 1000));
        assertThrows(RuntimeException.class, () -> vm.pay());
    }

    @Test
    void 선택한_물품_널_테스트() throws Exception {
        vm.setInputMoney(1000);
        assertThrows(RuntimeException.class, () -> vm.pay());
    }

    @Test
    void 잔돈_모듈_정상_테스트() throws Exception {
        vm.setInputMoney(2500);
        vm.selectedDrinks.add(new Drink("게토레이", 600));
        vm.selectedDrinks.add(new Drink("생수", 1000));
        vm.pay();
        CoinMap coinMap = vm.change();
        System.out.println(coinMap);
        assertEquals(coinMap.getValue(COIN.KRW500), 1);
        assertEquals(coinMap.getValue(COIN.KRW100), 4);
    }
}
