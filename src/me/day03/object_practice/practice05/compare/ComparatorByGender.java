package me.day03.object_practice.practice05.compare;

import java.util.Comparator;

public class ComparatorByGender implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
