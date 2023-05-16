package me.day14.junit_practice;

public class ChangeModule {

    public CoinMap getChangeCoinSet(int changeAmount) {
        CoinMap coinMap = new CoinMap();
        int remainChangeAmount = changeAmount;
        for (int i = 0; i < COIN.values().length; i++) {
            remainChangeAmount = addCoinsToCoinSet(remainChangeAmount, coinMap, COIN.values()[i], COIN.values()[i].getValue());
        }
        return coinMap;
    }

    private int addCoinsToCoinSet(int remainChangeAmount, CoinMap coinMap, COIN coin, int coinVal) {
        int count = 0;
        while (remainChangeAmount >= coinVal) {
            count++;
            remainChangeAmount -= coinVal;
            coinMap.put(coin, count);
        }
        return remainChangeAmount;
    }
}
