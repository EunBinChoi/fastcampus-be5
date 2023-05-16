package me.day15.smartstore.menu;

import me.day15.smartstore.customers.ClassifiedCustomersGroup;
import me.day15.smartstore.customers.Customer;
import me.day15.smartstore.customers.Customers;
import me.day15.smartstore.exception.InputEmptyException;
import me.day15.smartstore.exception.InputEndException;
import me.day15.smartstore.exception.InputRangeException;
import me.day15.smartstore.util.Message;

import java.util.Comparator;


public class SummaryMenu implements Menu {

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static SummaryMenu summarizedMenu;

    public static SummaryMenu getInstance() {
        if (summarizedMenu == null) {
            summarizedMenu = new SummaryMenu();
        }
        return summarizedMenu;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////

    private Customers allCustomers = Customers.getInstance();

    private ClassifiedCustomersGroup classifiedCusGroup = ClassifiedCustomersGroup.getInstance();


    @Override
    public void manage() { // customer set group => classified by group
        classifiedCusGroup = allCustomers.classified();
        //System.out.println("Arrays.toString(classifiedCusGroup.getClassifiedCustomers()) = " + Arrays.toString(classifiedCusGroup.getClassifiedCustomers()));

        while ( true ) {
            int choice = chooseMenu(
                    new String[]{"Summary",
                    "Summary (Sorted By Name)",
                    "Summary (Sorted By Spent Time)",
                    "Summary (Sorted By Total Payment)",
                    "Back"});

            if (choice == 1) dispSummary();
            else if (choice == 2) {
                manageSort(Comparator
                        .comparing(Customer::getName)
                        .thenComparing(Customer::getUserId));
            } else if (choice == 3) {
                manageSort(Comparator
                        .comparing(Customer::getSpentTime)
                        .thenComparing(Customer::getName));
            } else if (choice == 4) {
                manageSort(Comparator
                        .comparing(Customer::getTotalPay)
                        .thenComparing(Customer::getName));
            } else if (choice == 5) return;
//            else System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
        }
    }


    public void dispSummary() {
        if (classifiedCusGroup == null) {
            System.out.println(Message.ERR_MSG_INVALID_INPUT_NULL);
            return;
        }
        classifiedCusGroup.print();
    }

    public void manageSort(Comparator<Customer> comparator) {
        while ( true ) {
            String strOrder = chooseSortOrder();
            if (strOrder == null) return;
            if (strOrder.equals(Message.END_MSG)) return;

            try {
                OrderType orderType = OrderType.valueOf(strOrder).replaceFullName();
                if (orderType == OrderType.ASCENDING) classifiedCusGroup.sort(comparator);
                else if (orderType == OrderType.DESCENDING) classifiedCusGroup.sort(comparator.reversed());
                else throw new InputRangeException();

            } catch (IllegalArgumentException | InputRangeException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
            }

            dispSummary();
        }
    }

    public String chooseSortOrder() {
        while ( true ) {
            try {
                System.out.print("Which order (ASCENDING (A), DESCENDING (D))? ");
                String choice = nextLine(Message.END_MSG);

                if (choice.equals("")) throw new InputEmptyException();
                //if (choice.equals(Message.END_MSG)) return choice;

                try {
                    OrderType orderType = OrderType.valueOf(choice).replaceFullName();
                    for (int i = 0; i < OrderType.size(); i++) {
                        if (orderType == OrderType.values()[i]) {
                            return choice;
                        }
                    }
                    throw new InputRangeException();
                } catch (IllegalArgumentException e) {
                    System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
                }
            } catch (InputEmptyException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_NULL);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            } catch (InputEndException e) {
                System.out.println(Message.ERR_MSG_INPUT_END);
                return null;
            }
        }
    }
}
