package me.day15.smartstore.customers;

import me.day15.smartstore.groups.Group;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Groups;

import java.util.Arrays;

public class Customers { // singleton

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static Customers allCustomers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////

    private final Groups allGroups = Groups.getInstance();

    protected static int DEFAULT_SIZE = 10;
    protected int capacity;
    protected int size;
    protected Customer[] customers;

    public Customers() {
        customers = new Customer[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public Customers(int initialCapacity) {
        customers = new Customer[initialCapacity];
        capacity = initialCapacity;
    }

    public Customers(Customer[] customers) {
        this.customers = customers;
        capacity = customers.length;
        size = customers.length;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Customer[] getRealCustomers() {
        int real = 0;
        for (int i = 0; i < size; i++) {
            if (customers[i] != null) real++;
        }
        size = real;
        return Arrays.copyOf(customers, real);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() { return capacity; }
    public int size() {
        return size;
    }

    private boolean isNull() {
        return customers == null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, Customer customer) { // i 번째 원소를 customer 로 수정
        if (!(index >= 0 && index < size)) return;
        if (customer == null) return;

        customers[index] = customer;
    }

    public Customer get(int index) { // i 번째 원소 반환
        if (!(index >= 0 && index < size)) return null;

        return customers[index];
    }

    public int indexOf(Customer customer) { // customer 원소 인덱스 반환
        if (customer == null) return -1; // 객체를 찾지 못함

        for (int i = 0; i < size; i++) {
            if (customers[i] == null) continue;
            if (customers[i].equals(customer)) return i;
        }
        return -1; // 객체를 찾지 못함
    }

    public void add(Customer customer) {
        if (customer == null) return;

        if (size < capacity) {
            customers[size] = customer;
            size++;
        } else {
            grow();
            add(customer);
        }

    }

    public void add(int index, Customer customer) {
        if (!(index >= 0 && index <= size)) return;
        if (customer == null) return;

        if (size < capacity) {

            for (int i = customers.length - 1; i >= index; i--) {
                customers[i + 1] = customers[i];
            }

            customers[index] = customer;
            size++;
        } else {
            grow();
            add(index, customer);
        }
    }

    public void grow() {
        Customer[] copy = Arrays.copyOf(customers, customers.length);
        capacity *= 2;
        customers = new Customer[capacity];

        System.arraycopy(copy, 0, customers, 0, copy.length);

        size = copy.length;
    }

    public void pop(int index) {
        if (size == 0) return;
        if (!(index >= 0 && index < size)) return;

        customers[index] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = index + 1; j < size; j++) {
            customers[j - 1] = customers[j];
        }

        customers[size - 1] = null;
        size--;
    }

    public void pop() {
        if (size == 0) return;

        customers[size - 1] = null;
        size--;
    }

    public void pop(Customer customer) {
        if (size == 0) return;
        if (customer == null) return;

        pop(indexOf(customer));
    }

    public Customers trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        Customer[] newCustomers = new Customer[size];
        System.arraycopy(customers, 0, newCustomers, 0, size);

        customers = newCustomers;
        capacity = size;

        return new Customers(newCustomers);
    }

    public Customers findCustomers(GroupType type) {
        Customers custs = new Customers();

        for(int i = 0; i < size; ++i) {
            Customer cust = get(i);
            if (cust == null) return null;

            Group grp = cust.getGroup();
            if (type == GroupType.NONE) { // Customer Group == null =>
                if (grp == null || grp.getType() == null || grp.getType() == GroupType.NONE) {
                    custs.add(cust);
                }
            } else if (grp != null && grp.getType() == type) {
                custs.add(cust);
            }

        }

        return custs;
    }

    public Customers findCustomers(Group grp) {
        if (grp != null) {
            if (grp.getType() != null) {
                return findCustomers(grp.getType());
            } else {
                System.out.println("Customers.findCustomers() Error : No group type.");
                return null;
            }
        } else {
            System.out.println("Customers.findCustomers() Error : No group.");
            return null;
        }
    }

    public void refresh(Groups groups) {
        if (groups == null) return;

        for (int i = 0; i < size; i++) {
            Customer cust = customers[i];
            cust.setGroup(groups.findGroupFor(cust));
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (customers[i] != null) {
                System.out.printf("No.  %4d => %s\n", (i + 1), customers[i]);
            }
        }
    }

    public ClassifiedCustomersGroup classified() {
        ClassifiedCustomersGroup classifiedCusGroup = ClassifiedCustomersGroup.getInstance();

        for (int i = 0; i < allGroups.size(); i++) {
            Group grp = allGroups.get(i);

            Customer[] customers = grp.getCustomers(allCustomers).trimToSize().getCustomers();
            Customer[] copy = Arrays.copyOf(customers, customers.length);

            ClassifiedCustomers classifiedCustomers = new ClassifiedCustomers();
            classifiedCustomers.setGroup(grp);
            classifiedCustomers.setSize(copy.length);
            classifiedCustomers.setCustomers(copy);

            classifiedCusGroup.set(i, classifiedCustomers);
        }
        return classifiedCusGroup;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str = str + customers[i].toString() + "\n";
        }

        return str;
    }
}
