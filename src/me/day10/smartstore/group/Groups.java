package me.day10.smartstore.group;

import me.day10.smartstore.arrays.DArray;
import me.day10.smartstore.customer.Customers;

public class Groups extends DArray<Group> {
    // singleton
    private static Groups allGroups;

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }

    private Groups() {}

    public Group find(GroupType groupType) {
        // NOTE: 오류나는 코드
        for (Group group: arrays) {
            if (group.getGroupType() == groupType) {
                return group;
            }
        }
        return null;


//        for (int i = 0; i < this.size; i++) {
//            if (this.get(i).getGroupType() == groupType) {
//                return this.get(i);
//            }
//        }
//
//        return null;
    }
}
