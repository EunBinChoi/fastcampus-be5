package me.day15.smartstore.groups;


import me.day15.smartstore.arrays.DArray;
import me.day15.smartstore.customers.Customer;
import me.day15.smartstore.util.Util;


public class Groups extends DArray<Group> { // singleton

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static Groups allGroups;

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////

    public Groups() {
        arrays = new Group[] {
                new Group( GroupType.NONE, null),
                new Group( GroupType.GENERAL, null),
                new Group( GroupType.VIP, null),
                new Group( GroupType.VVIP, null)};
        size = arrays.length;
        capacity = arrays.length;
    }

    public void setGroups(Group[] groups) {
        this.arrays = groups;
        capacity = groups.length;
        size = groups.length;
    }

    public Group[] getGroups() {
        return arrays;
    }


    public void update(Group group) {
        Group grp = find(group.getType());
        if (grp != null) {
            grp.setParam(group.getParam());
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (arrays[i] != null) {
                System.out.println(arrays[i]);
            }
        }
    }

    public Group find(GroupType groupType) {
        for (int i = 0; i < size; i++) {
            if (arrays[i].getType() == groupType)
                return arrays[i];
        }

        return null;
    }

    public Group findGroupFor(Customer customer) {
        if (arrays == null) return null;
        if (Util.isAnyNUll(customer, customer.getSpentTime(), customer.getTotalPay())) return null;

        for (int i = size - 1; i >= 0; i--) {
            if (Util.isAnyNUll(arrays[i], arrays[i].getParam())) continue;

            Parameter param = arrays[i].getParam();
            if (Util.isAnyNUll(param, param.getMinimumSpentTime(), param.getMinimumTotalPay())) continue;

            if (customer.getSpentTime() >= param.getMinimumSpentTime()
                    && customer.getTotalPay() >= param.getMinimumTotalPay()) {
                return arrays[i];
            }
        }
        return null;
    }


    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i < size; ++i) {
            str = str + " " + arrays[i] + "\n";
        }

        return str;
    }
}
