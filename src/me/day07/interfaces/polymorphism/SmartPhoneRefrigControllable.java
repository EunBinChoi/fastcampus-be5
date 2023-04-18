package me.day07.interfaces.polymorphism;

public interface SmartPhoneRefrigControllable extends SmartPhoneControllable {
    void showGroceries();
    // Groceries에 대한 정보는 SmartRefrig에 들어가야 앎
    // 객체에 대한 정보가 필요한 경우에는 디폴트 메소드로 만들 수 없음
    // 추상 메소드로 만들어서 SmartRefrig에서 재정의 해야 함
}
