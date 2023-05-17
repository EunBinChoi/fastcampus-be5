package me.day15.smartstore.customers;

import me.day15.smartstore.arrays.DArray;
import me.day15.smartstore.groups.Group;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Groups;
import me.day15.smartstore.groups.Parameter;

import java.util.Arrays;

public class Customers extends DArray<Customer> { // singleton

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

    public Customers() {
        arrays = new Customer[DEFAULT];
        capacity = DEFAULT;
    }

    public Customers(int initialCapacity) {
        arrays = new Customer[initialCapacity];
        capacity = initialCapacity;
    }

    public Customers(Customer[] customers) {
        this.arrays = customers;
        capacity = customers.length;
        size = customers.length;
    }

    public void setCustomers(Customer[] customers) {
        this.arrays = customers;
        capacity = customers.length;
        size = customers.length;
    }

    public Customer[] getCustomers() {
        return arrays;
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
            Customer cust = arrays[i];
            Group grp = groups.findGroupFor(cust);
            if (grp == null) {
                grp = groups.find(GroupType.NONE);
            }
            cust.setGroup(grp);
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (arrays[i] != null) {
                System.out.printf("No.  %4d => %s\n", (i + 1), arrays[i]);
            }
        }
    }

    public ClassifiedCustomersGroup classified() {
        ClassifiedCustomersGroup classifiedCusGroup = ClassifiedCustomersGroup.getInstance();

        for (int i = 0; i < allGroups.size(); i++) {
            Group grp = allGroups.get(i);
            Customers cusGrp = grp.getCustomers(allCustomers);
            cusGrp.trimToSize();

            Customer[] copy = Arrays.copyOf(cusGrp.getCustomers(), cusGrp.size);

            ClassifiedCustomers classifiedCustomers = new ClassifiedCustomers();
            classifiedCustomers.setGroup(grp);
            classifiedCustomers.setCustomers(copy);

            classifiedCusGroup.set(i, classifiedCustomers);
        }
        return classifiedCusGroup;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str = str + arrays[i].toString() + "\n";
        }

        return str;
    }
}
