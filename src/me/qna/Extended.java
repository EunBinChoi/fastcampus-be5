package me.qna;

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
    public Super aSuper = new Super();

    @Override
    public String toString() {
        return "Sub{" +
                "aSuper=" + aSuper +
                '}';
    }
}


public class Extended {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.aSuper);
    }
}
