package company.Arrays_and_Java_Built_in_Lists.LinkedLists;

import java.util.ArrayList;

public class LinkedLists_Main {
    public static void main(String[] args) {
        // Address example
        Customer customer = new Customer("Tim", 54.96);
        Customer customer1 = customer; // saving the memory address
        customer1.setBalance(12.18); // saved the value in the original location
//        System.out.println("Balance for customer | " + customer.getName() + ": " + customer1.getBalance() +
//                "\nBalance for customer1 | " + customer1.getName() + ": " + customer1.getBalance());

        //ArrayList inefficiency example
        ArrayList<Integer> inList = new ArrayList<>();
        inList.add(1);
        inList.add(3);
        inList.add(4);
        for (int i =0; i<inList.size();i++) {
            System.out.println(i + ": " +  inList.get(i));
        }
        inList.add(1, 2);

        for (int i =0; i<inList.size();i++) {
            System.out.println(i+ ": " + inList.get(i));
        }


    }
}
