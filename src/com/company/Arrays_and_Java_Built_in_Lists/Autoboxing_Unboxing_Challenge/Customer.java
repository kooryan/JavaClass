package company.Arrays_and_Java_Built_in_Lists.Autoboxing_Unboxing_Challenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addMoney(initialAmount);
    }

    public void addMoney(double deposit) {
        transactions.add(deposit);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }


}
