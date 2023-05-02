package me.day11.generic.generics;

public class SmartPhone {
    private String modelName;

    public SmartPhone() {
    }

    public SmartPhone(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "modelName='" + modelName + '\'' +
                '}';
    }
}
