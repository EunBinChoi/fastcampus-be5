package me.day09.assignment05.practice05;

import me.day09.assignment05.practice05.Person;

import java.util.Arrays;
import java.util.Objects;

public class Clazz implements Cloneable {
    private int intVariable;
    private String strVariable;
    private Person[] personArray; // deep copy

    public Clazz() {}

    public Clazz(int intVariable, String strVariable, Person[] personArray) {
        this.intVariable = intVariable;
        this.strVariable = strVariable;
        this.personArray = personArray;
    }


    public int getIntVariable() {
        return intVariable;
    }

    public void setIntVariable(int intVariable) {
        this.intVariable = intVariable;
    }

    public String getStrVariable() {
        return strVariable;
    }

    public void setStrVariable(String strVariable) {
        this.strVariable = strVariable;
    }

    public Person[] getPersonArray() {
        return personArray;
    }

    public void setPersonArray(Person[] personArray) {
        this.personArray = personArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz that = (Clazz) o;
        return intVariable == that.intVariable && Objects.equals(strVariable, that.strVariable) && Arrays.equals(personArray, that.personArray);
    }

    @Override
    public String toString() {
        return "ObjectCopyExample{" +
                "intVariable=" + intVariable +
                ", strVariable='" + strVariable + '\'' +
                ", personArray=" + Arrays.toString(personArray) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(intVariable, strVariable);
        result = 31 * result + Arrays.hashCode(personArray);
        return result;
    }


    @Override // Object class (Native OS clone() 시스템에 의존적인 메소드)
    public Clazz clone() throws CloneNotSupportedException {
        Clazz objectCopyExample = (Clazz) super.clone(); // shallow copy

        objectCopyExample.personArray = new Person[personArray.length]; // 배열 객체인 경우 deep copy
        for (int i = 0; i < objectCopyExample.personArray.length; i++) {
            objectCopyExample.personArray[i] = new Person();
            objectCopyExample.personArray[i].setName(personArray[i].getName());
            objectCopyExample.personArray[i].setGender(personArray[i].getGender());
            objectCopyExample.personArray[i].setBirthdate(personArray[i].getBirthdate());
            objectCopyExample.personArray[i].setRegistrationNumber(personArray[i].getRegistrationNumber());
        }
        return objectCopyExample;
    }
}
