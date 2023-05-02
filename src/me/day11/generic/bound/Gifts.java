package me.day11.generic.bound;//package me.day11.generic.bound;
//
//import me.day20.generic.bound.item.Item;
//
//import java.util.Arrays;
//import java.util.Objects;
//
//public class Gifts<T extends Item> {
//
//    private static final int DEFAULT_SIZE = 2;
//    private int capacity;
//
//    private T[] gifts;
//    private int size;
//
//    public Gifts() {
//        gifts = (T[]) new Item[DEFAULT_SIZE];
//        this.capacity = DEFAULT_SIZE;
//    }
//
//    public Gifts(int capacity) {
//        gifts = (T[]) new Item[capacity];
//        this.capacity = capacity;
//    }
//
//    public void trimToSize() {
//        gifts = Arrays.copyOf(gifts, size);
//    }
//
//    public void print() {
//        if (size == 0) {
//            System.out.println("Nothing to print in array.");
//            return;
//        }
//
//        for (int i = 0; i < size; i++) {
//            System.out.println(gifts[i]);
//        }
//    }
//
//    private boolean isNull(T element) { // 인자로 들어온 객체가 null 인지 확인
//        return (element == null);
//    }
//
//    public boolean isEmpty() { // 현재 배열의 길이가 0인지 확인
//        return (size == 0);
//    }
//
//    private int checkDuplicatedKey(T element) {
//        for (int i = 0; i < size; i++) {
//            if (gifts[i] == null) continue;
//            if (gifts[i].getProductNo() == null) continue;;
//
//            if (gifts[i].getProductNo().equals(element.getProductNo())) {
//                return i;
//            }
//
//        }
//        return -1;
//    }
//
//    private boolean checkRangeForAdd(int i) {
//        return (i >= 0 && i <= size);
//    }
//
//    private boolean checkRange(int i) {
//        return (i >= 0 && i < size);
//    }
//
//
//    public T get(int i) {
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return null;
//        }
//
//        if (!checkRange(i)) {
//            System.out.println("Input index [" + i + "] is too small or large." );
//            return null;
//        }
//
//        return gifts[i];
//
//    }
//
//    public void set(int i, T element) {
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return;
//        }
//
//        if (!checkRange(i)) {
//            System.out.println("Input index [" + i + "] is too small or large." );
//            return;
//        }
//
//        if (isNull(element)) {
//            System.out.println("Input element null. " + element);
//            return;
//        }
//
//        int duplicatedIdx = checkDuplicatedKey(element);
//        if (duplicatedIdx != -1) {
//            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
//            return;
//        }
//
//        gifts[i] = element;
//    }
//
//
//    public T add(T element) {
//        if (isNull(element)) {
//            System.out.println("Input element null. " + element);
//            return null;
//        }
//
//        int duplicatedIdx = checkDuplicatedKey(element);
//        if (duplicatedIdx != -1) {
//            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
//            return null;
//        }
//
//        if (size < capacity) {
//            gifts[size] = element;
//            size++;
//        } else {
//            T[] origin = Arrays.copyOf(gifts, size);
//            capacity *= 2;
//            gifts = Arrays.copyOf(origin, capacity);
//            add(element);
//        }
//        return element;
//    }
//
//    public T add(int i, T element) {
//        if (!checkRangeForAdd(i)) {
//            System.out.println("Input index [" + i + "] is too small or large." );
//            return null;
//        }
//
//        if (isNull(element)) {
//            System.out.println("Input element null. " + element);
//            return null;
//        }
//
//        int duplicatedIdx = checkDuplicatedKey(element);
//        if (duplicatedIdx != -1) {
//            System.out.println("Duplicated productNo. Duplicated element => " + gifts[duplicatedIdx]);
//            return null;
//        }
//
//        if (size  < capacity) {
//            for (int j = size; j > i; j--) {
//                gifts[j] = gifts[j-1];
//            }
//            gifts[i] = element;
//            size++;
//
//        } else {
//            T[] origin = Arrays.copyOf(gifts, size);
//            capacity *= 2;
//            gifts = Arrays.copyOf(origin, capacity);
//            add(i, element);
//        }
//        return element;
//    }
//
//    public void clear() {
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return;
//        }
//
//        Arrays.fill(gifts, null);
//        size = 0;
//    }
//
//    public T pop() {
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return null;
//        }
//
//        T popNode = gifts[size-1];
//        gifts[size-1] = null;
//        size--;
//        return popNode;
//    }
//
//    public T remove(int i) {
//
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return null;
//        }
//
//        if (!checkRange(i)) {
//            System.out.println("Input index [" + i + "] is too small or large." );
//            return null;
//        }
//
//        T removeNode = gifts[i];
//        gifts[i] = null;
//        for (int j = i + 1; j < size; j++) {
//            gifts[j - 1] = gifts[j];
//        }
//        gifts[size-1] = null;
//        size--;
//        return removeNode;
//    }
//
//    public T remove(T element) {
//        if (isEmpty()) {
//            System.out.println("Array is Empty.");
//            return null;
//        }
//
//        if (isNull(element)) {
//            System.out.println("Input element null. " + element);
//            return null;
//        }
//
//        int elementIndex = -1;
//        for (int i = 0; i < size; i++) {
//            if (gifts[i] != null) {
//                if (gifts[i].equals(element)) {
//                    elementIndex = i;
//                }
//            }
//        }
//        if (elementIndex == -1) {
//            System.out.println(element + " can't be found.");
//        } else {
//            gifts[elementIndex] = null;
//            for (int i = elementIndex+1; i < size; i++) {
//                gifts[i-1] = gifts[i];
//            }
//            gifts[size-1] = null;
//            size--;
//
//            System.out.println(element + " removed successfully.");
//        }
//        return element;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public T[] getGifts() {
//        return gifts;
//    }
//
//    public void setGifts(T[] gifts) {
//        this.gifts = gifts;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Gifts<?> gifts1 = (Gifts<?>) o;
//        return capacity == gifts1.capacity && size == gifts1.size && Arrays.equals(gifts, gifts1.gifts);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(capacity, size);
//        result = 31 * result + Arrays.hashCode(gifts);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "RandomGiftBox{" +
//                "capacity=" + capacity +
//                ", gifts=" + Arrays.toString(Arrays.copyOf(gifts, size)) +
//                ", size=" + size +
//                '}';
//    }
//}
