package me.day14.junit.annotation;

import java.time.LocalDateTime;

class MyClass {
    private Integer value;
    private String name;
    private LocalDateTime time;
    private boolean active;

    public MyClass(Integer value, String name, LocalDateTime time, boolean active) {
        this.value = value;
        this.name = name;
        this.time = time;
        this.active = active;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", active=" + active +
                '}';
    }
}
