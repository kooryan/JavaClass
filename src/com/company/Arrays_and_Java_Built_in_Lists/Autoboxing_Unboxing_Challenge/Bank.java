package com.company.Arrays_and_Java_Built_in_Lists.Autoboxing_Unboxing_Challenge;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<>();
    }

    public Boolean addNewBranch(String branch) {
        if(findBranch(branch) == null) {
            this.branches.add(new Branch(branch));
            return true;
        } else
            System.out.println("Branch " + branch + " is already logged.");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addNewCustomer(customerName, initialAmount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double depositAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, depositAmount);
        }
        return false;
    }

    public Branch findBranch(String branch) {
        for (int i=0; i < branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getBranchName().equals(branch)) {
                return checkedBranch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "]  Amount "  + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
