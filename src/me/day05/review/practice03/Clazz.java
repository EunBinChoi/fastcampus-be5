package me.day05.review.practice03;

public class Clazz {
    private int a;
    private double b;
    private String s;

    /*
    * 1. 위의 `Main` 클래스에서 `Clazz` 클래스 객체 `cls`를 출력했을 때 `toSting()`에 정의된 내용물이 출력되지 않고 주소값이 나오는 이유를 설명하시오.
    * - 객체의 주소값이 아닌 내용물을 출력하고 싶을 때는 toString() 메소드를 재정의해야한다.
    * - toString() 메소드는 모든 클래스의 부모 클래스인 Object에 정의되어있다.
    *
    * 2. 위의 `Clazz` 클래스에서 `toSting()` 위에 `@Override` annotation을 정의해보고, 컴파일 오류가 생기는 이유가 무엇인지 설명하시오.
    * - Object 클래스에 toSting() 이라는 메소드가 없기 때문에 오류발생
    * - @Override는 해당 클래스의 부모 클래스에서 동일한 메소드가 있는지 확인하는데 Clazz 클래스 같은 경우 Object 클래스가 부모 클래스이고 Object 클래스에는 toSting()이 없기 떄문
    * */

//    @Override
    public String toSting() {
        return "Clazz{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", s='" + s + '\'' +
                '}';
    }
}