package me.day15.smartstore.menu;

import me.day15.smartstore.customers.Customers;
import me.day15.smartstore.exception.InputEmptyException;
import me.day15.smartstore.exception.InputEndException;
import me.day15.smartstore.exception.InputRangeException;
import me.day15.smartstore.groups.Group;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Groups;
import me.day15.smartstore.groups.Parameter;
import me.day15.smartstore.util.Message;

public class GroupMenu implements Menu {

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static GroupMenu groupMenu;

    public static GroupMenu getInstance() {
        if (groupMenu == null) {
            groupMenu = new GroupMenu();
        }
        return groupMenu;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////


    Groups allGroups = Groups.getInstance();
    Customers allCustomers = Customers.getInstance();


    public String chooseGroup() {
        while ( true ) {
            try {
                System.out.print("Which group (GENERAL (G), VIP (V), VVIP (VV))? ");
                String choice = nextLine(Message.END_MSG);

                if (choice.equals("")) throw new InputEmptyException();
                return choice;

            } catch (InputEmptyException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_NULL);
            } catch (IllegalArgumentException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            } catch (InputEndException e) {
                System.out.println(Message.ERR_MSG_INPUT_END);
                return null;
            }
        }
    }

    @Override
    public void manage() {
        while ( true ) {
            int choice = chooseMenu(
                    new String[]{"Set Parameter", "View Parameter", "Update Parameter", "Back"});

            if (choice == 1) {
                setParameter();
            } else if (choice == 2) {
                viewParameter();
            } else if (choice == 3) {
                updateParameter();
            } else if (choice == 4) {
                break;
            }
        }
    }

    public void setParameter() {
        while ( true ) {
            String strGroup = chooseGroup(); // "V", "VIP" (string) => GroupType.VIP
            if (strGroup == null) return;

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                continue;
            }

            Group grp = allGroups.find(groupType);
            if (grp != null && grp.getParam() != null) {
                System.out.println("\n" + grp.getType() + " group already exists.");
                System.out.println("\n" + grp);
            } else {
                Parameter param = new Parameter();

                while ( true ) {
                    int choice = chooseMenu(new String[]{"Minimum Spent Time", "Minimum Total Pay", "Back"});
                    if (choice == 1) {
                        setParameterMinimumSpentTime(param);
                    } else if (choice == 2) {
                        setParameterMinimumTotalPay(param);
                    } else if (choice == 3) break;
//                    else System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                }

                allGroups.add(new Group(groupType, param));
                allCustomers.refresh(allGroups);
                System.out.println("\n" + grp);
            }
        }
    }

    public void viewParameter() {
        while ( true ) {
            String strGroup = chooseGroup();
            if (strGroup == null) return;

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
                continue;
            }

            Group grp = allGroups.find(groupType);
            System.out.println();
            System.out.println(grp);
        }
    }

    public void updateParameter() {
        while ( true ) {
            String strGroup = chooseGroup();
            if (strGroup == null) return;

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                return;
            }

            Group grp = allGroups.find(groupType);
            if (grp.getParam() == null) {
                System.out.println("\nNo parameter. Set the parameter first.");
                return;
            }

            System.out.println("\n" + grp);
            Parameter param = grp.getParam();

            while ( true ) {
                int choice = chooseMenu(new String[]{"Minimum Spent Time", "Minimum Total Pay", "Back"});
                if (choice == 1) {
                    setParameterMinimumSpentTime(param);
                } else if (choice == 2) {
                    setParameterMinimumTotalPay(param);
                } else if (choice == 3) {
                    break;
                }
            }

            allGroups.update(new Group(groupType, param));
            allCustomers.refresh(allGroups);
            System.out.println("\n" + grp);

        }
    }

    public void setParameterMinimumSpentTime(Parameter param) {
        while ( true ) {
            try {
                System.out.print("\nInput Minimum Spent Time: ");
                int minimumSpentTime = Integer.parseInt(nextLine(Message.END_MSG));
                if (minimumSpentTime < 0) throw new InputRangeException();

                param.setMinimumSpentTime(minimumSpentTime);
                return;
            } catch (NumberFormatException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            } catch (InputEndException e) {
                System.out.println(Message.ERR_MSG_INPUT_END);
                return;
            }
        }
    }


    public void setParameterMinimumTotalPay(Parameter param) {

        while ( true ) {
            try {
                System.out.print("\nInput Minimum Total Pay: ");
                int minimumTotalPay = Integer.parseInt(nextLine(Message.END_MSG));
                if (minimumTotalPay < 0) throw new InputRangeException();
                param.setMinimumTotalPay(minimumTotalPay);
                return;
            } catch (NumberFormatException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            } catch (InputEndException e) {
                System.out.println(Message.ERR_MSG_INPUT_END);
                return;
            }
        }
    }
}
