package com.company.Arrays_and_Java_Built_in_Lists.Autoboxing_Unboxing_Challenge;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;


    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();

    }

    public boolean addNewCustomer(String customer, double initialAmount) {
        Customer existingCustomer = findCustomer(customer);

        if (existingCustomer == null) {
            this.customers.add(new Customer(customer, initialAmount));
            return true;
        } else {
            System.out.println("Customer: " + customer + " is already logged in the database.");
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null ) { // customer is on file
            existingCustomer.addMoney(amount);
            return true;
        } else
            System.out.println("Customer is not on file.");
        return false;
    }

    private Customer findCustomer(String customer) {
        for(int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customer)) {
                return checkedCustomer;
            }
        }
        return null;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
