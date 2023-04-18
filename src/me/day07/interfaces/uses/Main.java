package me.day07.interfaces.uses;

public class Main {
    public static void main(String[] args) {
//        DriveLicenseAble highStudent = new HighStudent();
        DriveLicenseAble univStudent = new UnivStudent();
        univStudent.renew();
        univStudent.defaultMethod();
        UnivStudent.staticMethod();
        DriveLicenseAble.staticMethod();
        System.out.println();

        DriveLicenseAble worker = new Worker();
        worker.renew();
        worker.defaultMethod();
        DriveLicenseAble.staticMethod();
        System.out.println();
    }
}
