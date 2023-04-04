package me.day03.object.practice04;

public class Clazz {
    private int field = 0;
    private static Clazz instance = null;

    private Clazz() {}
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