package me.day09.exception_practice.practice02;

abstract class Animal {
    protected abstract String getName();
}

class Mammal extends Animal {
    @Override
    protected String getName() {
        return "Mammal";
    }
}
class Amphibian extends Animal {
    @Override
    protected String getName() {
        return "Amphibian";
    }
}

class Dog extends Mammal {
    @Override
    protected String getName() {
        return "Dog";
    }
}
class Frog extends Amphibian {
    @Override
    protected String getName() {
        return "Frog";
    }
}

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        birth(new Dog());
        birth(new Frog());
        System.out.println("main exit ...");
    }
    public static void birth(Animal animal) {

        if (animal instanceof Mammal) {

            Mammal mammal = (Mammal) animal;
            System.out.println(mammal.getName() + " give birth to young");

        } else if (animal instanceof Amphibian) {

            Amphibian amphibian = (Amphibian) animal;
            System.out.println(amphibian.getName() + " lay eggs");

        }
//        try {
//            Mammal mammal = (Mammal) animal;
//            System.out.println(mammal.getName() + " give birth to young");
//        } catch (ClassCastException e) {
//            //System.out.println(e.getMessage());
//        }
//
//         try {
//             Amphibian amphibian = (Amphibian) animal;
//             System.out.println(amphibian.getName() + " lay eggs");
//         } catch (ClassCastException e) {
//             //System.out.println(e.getMessage());
//         }

    }
}
