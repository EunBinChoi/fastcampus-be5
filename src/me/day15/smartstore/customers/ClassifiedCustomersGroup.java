package me.day15.smartstore.customers;


import me.day15.smartstore.arrays.DArray;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Parameter;
import me.day15.smartstore.util.Message;

import java.util.Arrays;
import java.util.Comparator;

public class ClassifiedCustomersGroup extends DArray<ClassifiedCustomers> {

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static ClassifiedCustomersGroup classifiedCustomersGroup;

    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////


    public ClassifiedCustomersGroup() {
        arrays = new ClassifiedCustomers[GroupType.size()];

        for (int i = 0; i < GroupType.size(); i++) {
            arrays[i] = new ClassifiedCustomers();
        }

        size = GroupType.size();
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("\n==============================");

            if (arrays[i] == null) continue;

            GroupType groupType = arrays[i].getGroup().getType();
            Parameter parameter = arrays[i].getGroup().getParam();

            System.out.printf("Group : %s ( Time : %d, Pay : %d )\n",
                    groupType,
                    parameter != null ? parameter.getMinimumSpentTime() : null,
                    parameter != null ? parameter.getMinimumTotalPay() : null);
            System.out.println("==============================");

            if (arrays[i].isEmpty()) {
                System.out.println("Null.");
                continue;
            }
            arrays[i].print();
            System.out.println("==============================\n");
        }

    }

    public void sort(Comparator<Customer> comparator) {

        for (int i = 0; i < classifiedCustomersGroup.size(); i++) {
            Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();

            try {
                if (comparator == null) Arrays.sort(customers);
                else Arrays.sort(customers, comparator);

                classifiedCustomersGroup.get(i).setCustomers(customers);
            } catch (NullPointerException e) {
                System.out.println(Message.ERR_MSG_NULL_ARR_ELEMENT);
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedCustomersGroup that = (ClassifiedCustomersGroup) o;
        return Arrays.equals(arrays, that.arrays);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrays);
    }

    @Override
    public String toString() {
        return "ClassifiedCustomersGroup{" +
                "classifiedCustomers=" + Arrays.toString(arrays) +
                '}';
    }
}
