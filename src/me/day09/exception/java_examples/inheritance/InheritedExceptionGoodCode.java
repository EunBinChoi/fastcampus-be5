package me.day09.exception.java_examples.inheritance;

public class InheritedExceptionGoodCode {
    public static void main(String[] args) {
        try {
            throw new ExceptionC();
        } catch (ExceptionC e) {
            System.out.println(ExceptionC.class.getName() + " catch");
        } catch (ExceptionB e) {
            System.out.println(ExceptionB.class.getName() + " catch");
        } catch (ExceptionA e) {
            System.out.println(ExceptionA.class.getName() + " catch");
        }
    }
}
