package me.day10.smartstore.group;

import java.util.Objects;

public class Parameter {
    private Integer minTime;
    private Integer minPay;


    public Parameter() {
    }

    public Parameter(Integer minTime, Integer minPay) {
        this.minTime = minTime;
        this.minPay = minPay;
    }

    public Integer getMinTime() {
        return minTime;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }

    public Integer getMinPay() {
        return minPay;
    }

    public void setMinPay(Integer minPay) {
        this.minPay = minPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(minTime, parameter.minTime) && Objects.equals(minPay, parameter.minPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minTime, minPay);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "minTime=" + minTime +
                ", minPay=" + minPay +
                '}';
    }
}
