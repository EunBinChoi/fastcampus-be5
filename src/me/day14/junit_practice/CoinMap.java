package me.day14.junit_practice;

import java.util.*;


public class CoinMap {

    private Map<COIN, Integer> coinMap = new HashMap<>();

    public void put(COIN coin, int coinVal) {
        coinMap.put(coin, coinVal);
    }

    public Integer getValue(COIN coin) {
        return coinMap.get(coin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinMap coinMap1 = (CoinMap) o;
        return Objects.equals(coinMap, coinMap1.coinMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coinMap);
    }

    @Override
    public String toString() {
        return "CoinMap{" +
                "coinMap=" + coinMap +
                '}';
    }
}