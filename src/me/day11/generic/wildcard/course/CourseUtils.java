package me.day11.generic.wildcard.course;


import me.day11.generic.wildcard.course.register.Animal;
import me.day11.generic.wildcard.course.register.Person;

public interface CourseUtils {
    // @TODO: wildcard 안 쓰는 함수로 바꿔보기

    static <T extends Person> void registerPersonCourse(Course<T> course) {
        System.out.println(course + " is registered successfully.\n\n");
    }

    static <T extends Animal> void registerAnimalCourse(Course<T> course) {
        System.out.println(course + " is registered successfully.\n\n");
    }

//    static void registerPersonCourse(Course<? extends Person> course) {
//        System.out.println(course + " is registered successfully.\n\n");
//    }
//    static void registerAnimalCourse(Course<? extends Animal> course) {
//        System.out.println(course + " is registered successfully.\n\n");
//    }

}
