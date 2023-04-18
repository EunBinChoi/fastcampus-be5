package me.day07.interfaces.defaults.diamond;

public class Car implements Driveable, Sleepable {
    // default 는 재정의할 필요가 없지만
    // 두 인터페이스에서 제공하는 함수 이름이 중복될 경우에
    // 두 개의 함수 중에서 어떤 함수를 사용할 건지 재정의를 해줘야 할 때도 있음 (**)
    @Override
    public void on() {
        Driveable.super.on();
    }

    @Override
    public void off() {
        Driveable.super.off();
    }
}
