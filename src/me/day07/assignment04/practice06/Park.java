package me.day07.assignment04.practice06;

import me.day09.assignment04_review.practice06.Kid;
import me.day09.assignment04_review.practice06.Person;
import me.day09.assignment04_review.practice06.Student;

import java.time.LocalTime;
import java.util.Objects;

public class Park {
    private String name;
    private Double fee;
    /*
    * Person (일반) -> 할인 없음
    * Worker (직장인) -> 할인 없음
    * Student (대학생, 고등학생) -> 기본 요금에서 30%
    * Kid (아이) -> 돈 받지 않음
    * */
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

    public Double getFee(Person person) {
        if (person instanceof Kid) {
            return fee * (1 - ((Kid) person).rate());
        } else if (person instanceof Student) {
            return fee * (1 - ((Student) person).rate());
        }
        return fee;
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
