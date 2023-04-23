package me.day09.exception.java_examples.inheritance;

public class InheritedExceptionBadCode {
    public static void main(String[] args) {
        try {
            throw new ExceptionC(); // ExceptionA/ExceptionB/ExceptionC e = new ExceptionC()
        } catch (ExceptionA e) { // 부모 클래스가 자식 예외도 다 잡음 (다형성)
            // log ("exception a occurs ...") // 세밀한 예외의 이유를 알 수 없음
            System.out.println(ExceptionA.class.getName() + " catch");
//        } catch (ExceptionB e) { // 도달하지 않음 (컴파일 오류)
//            System.out.println(ExceptionB.class.getName() + " catch");
//        } catch (ExceptionC e) { // 도달하지 않음 (컴파일 오류)
//            System.out.println(ExceptionC.class.getName() + " catch");
        }
    }
}
