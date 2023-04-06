package me.day03.object.practice04;

public class Clazz {
    private int field = 0;
    public static Clazz instance = new Clazz();


    private Clazz() {} // 생성자는 외부에서 사용하지 않는다
    public static Clazz getInstance() {
        if (instance == null) {
            instance = new Clazz();
        }
        return instance;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "field=" + field +
                '}';
    }
}