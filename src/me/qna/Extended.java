package me.qna;


// https://stackoverflow.com/questions/4716040/do-subclasses-inherit-private-fields
class Super {
    private int privateField;
    public int publicField;

    @Override
    public String toString() {
        return "Super{" +
                "privateField=" + privateField +
                ", publicField=" + publicField +
                '}';
    }
}

class Sub extends Super {
}


public class Extended {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}
