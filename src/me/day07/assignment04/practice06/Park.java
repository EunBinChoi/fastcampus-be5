package me.day07.assignment04.practice06;

import java.time.LocalTime;
import java.util.Objects;

public class Park {
    private String name;
    private Double fee;
    private LocalTime openTime;
    private LocalTime closeTime;

    public Park() {
    }

    public Park(String name, Double fee) {
        this.name = name;
        this.fee = fee;
    }

    public Park(String name, Double fee, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.fee = fee;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @TODO: write the code to get proper fee.
    // Person 클래스의 자식들은 모두 Park에 들어갈 수 있음
    // 각각의 자식들마다 할인율이 다름
    /*
     * Person (일반) -> 할인 없음
     * Worker (직장인) -> 할인 없음
     * Student (대학생, 고등학생) -> 기본 요금에서 30%
     * Kid (아이) -> 돈 받지 않음
     * */
    public Double getFee(Person person) {
        return 0.0;
    }


    public void setFee(Double fee) {
        this.fee = fee;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return Objects.equals(name, park.name) && Objects.equals(fee, park.fee) && Objects.equals(openTime, park.openTime) && Objects.equals(closeTime, park.closeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fee, openTime, closeTime);
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", fee=" + fee +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
