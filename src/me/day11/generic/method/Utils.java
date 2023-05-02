package me.day11.generic.method;//package me.day11.generic.method;
//
//import me.day20.generic.method.decoration.Decorations;
//
//public interface Utils {
//
//    /*
//    * 정적 메소드는 객체의 데이터타입이 아직 결정되지 않을 때도 (객체가 없이도) 사용이 가능해야 함
//    * 각 정적 메소드에 독립적으로 타입 파라미터를 선언함 (interface Utils<T> (X))
//    * */
//    static <T> Box<T> boxing(T item) {
//        Box<T> box = new Box<>();
//        box.setItem(item);
//        return box;
//    }
//
//    static <T> void decoration(Box<T> box, Decorations decoration) {
//        System.out.println(box + " is decorated with "+ decoration);
//    }
//
//    static <T> T unboxing(Box<T> box) {
//        T item = box.getItem();
//        return item;
//    }
//}
