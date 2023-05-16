package me.day15.smartstore.groups;

import java.util.Objects;

public class Parameter {
    private Integer minimumSpentTime;
    private Integer minimumTotalPay;

    public Parameter() {
    }

    public Parameter(Integer minimumSpentTime, Integer minimumTotalPay) {
        this.minimumSpentTime = minimumSpentTime;
        this.minimumTotalPay = minimumTotalPay;
    }

    public Integer getMinimumSpentTime() {
        return minimumSpentTime;
    }

    public void setMinimumSpentTime(Integer minimumSpentTime) {
        this.minimumSpentTime = minimumSpentTime;
    }

    public Integer getMinimumTotalPay() {
        return minimumTotalPay;
    }

    public void setMinimumTotalPay(Integer minimumTotalPay) {
        this.minimumTotalPay = minimumTotalPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return minimumSpentTime == parameter.minimumSpentTime && minimumTotalPay == parameter.minimumTotalPay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumSpentTime, minimumTotalPay);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "minimumSpentTime=" + minimumSpentTime +
                ", minimumTotalPay=" + minimumTotalPay +
                '}';
    }
}
