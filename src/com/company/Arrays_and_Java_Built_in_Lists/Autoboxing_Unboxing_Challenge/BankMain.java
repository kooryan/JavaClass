package company.Arrays_and_Java_Built_in_Lists.Autoboxing_Unboxing_Challenge;


public class BankMain {

    public static void main(String[] args) {
        Bank bank = new Bank("Bank of America");

        bank.addNewBranch("Minnesota");
        bank.addCustomer("Minnesota", "Ryan", 50.50);
        bank.addCustomer("Minnesota", "John", 123.40);
        bank.addCustomer("Minnesota", "Tim", 00.00);

        bank.addNewBranch("Wisconsin");
        bank.addCustomer("Wisconsin", "Mark", 0.00);
        bank.addCustomer("Wisconsin", "Luke", 346.0);

        bank.addCustomerTransaction("Minnesota", "Ryan", 60.00);
       // bank.addCustomerTransaction("Minnesota", "Tim", 60.00);
        bank.addCustomerTransaction("Wisconsin", "Mark", 60.00);

     //   bank.listCustomers("Minnesota", true);
        bank.listCustomers("Wisconsin", true);


    }
}
