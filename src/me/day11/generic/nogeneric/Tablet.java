package me.day11.generic.nogeneric;

public class Tablet {
    private Integer inch;
    private String modelName;

    public Tablet() {
    }

    public Tablet(Integer inch, String modelName) {
        this.inch = inch;
        this.modelName = modelName;
    }

    public Integer getInch() {
        return inch;
    }

    public void setInch(Integer inch) {
        this.inch = inch;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "inch=" + inch +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
