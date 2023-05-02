package me.day11.collection.use;

import me.day11.collection.use.gift.Note;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Gifts<Note> randomNotes = new Gifts<>();
        randomNotes.add(new Note("1001", "모닝글로리", true));
        randomNotes.add(new Note("2001", "바른손", false));
        randomNotes.add(new Note("3001", "바른손", true));
        randomNotes.add(new Note("4001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.set(3, new Note("8001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.set(1, new Note("2001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();


        randomNotes.add(2, new Note("5001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.add(2, new Note("1001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.add(-1, new Note("6001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.add(4, new Note("6001", "모닝글로리", false));
        randomNotes.print();
        System.out.println();

        randomNotes.pop();
        randomNotes.print();
        System.out.println();

        randomNotes.pop();
        randomNotes.print();
        System.out.println();

        randomNotes.remove(2);
        randomNotes.print();
        System.out.println();

        randomNotes.remove(-1);
        randomNotes.print();
        System.out.println();

        randomNotes.remove(5);
        randomNotes.print();
        System.out.println();

        randomNotes.remove(new Note("1001", "모닝글로리", true));
        randomNotes.print();
        System.out.println();

        randomNotes.trimToSize();
        randomNotes.print();
        System.out.println();

        randomNotes.clear();
        randomNotes.print();
        System.out.println();
    }
}