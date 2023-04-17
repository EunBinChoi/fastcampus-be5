package me.day05.assignment02_review.practice04;

public class TeslaCar { // 테슬라 자동차만 만드는 공장
    private String ID;
    private String modelName;
    private String color;
    private static final String BRAND = "Tesla"; // static

    public TeslaCar() {}

    public TeslaCar(String ID, String modelName, String color) {
        this.ID = ID;
        this.modelName = modelName;
        this.color = color;
    }

    // static
    public static String getBrand() {
        return TeslaCar.BRAND;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TeslaCar{" +
                "ID='" + ID + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
