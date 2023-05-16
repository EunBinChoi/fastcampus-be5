package me.day15.smartstore.customers;


import me.day15.smartstore.groups.Group;

import java.util.Arrays;
import java.util.Objects;

public class ClassifiedCustomers extends Customers {
    private Group group;

    public ClassifiedCustomers() {}

    public ClassifiedCustomers(Group group) {
        this.group = group;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedCustomers that = (ClassifiedCustomers) o;
        return Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }

    @Override
    public String toString() {
        return "ClassifiedCustomers{" +
                "group=" + group +
                ", size=" + size +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }
}
