package me.day14.junit_practice;

public enum COIN {
    KRW500(500), KRW100(100), KRW50(50), KRW10(10);
    private int value;
    COIN(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
