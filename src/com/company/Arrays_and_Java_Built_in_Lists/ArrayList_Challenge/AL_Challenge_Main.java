package company.Arrays_and_Java_Built_in_Lists.ArrayList_Challenge;

import java.util.Scanner;

public class AL_Challenge_Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123 456 7890");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Shutting down. . .");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;

            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNum = sc.nextLine();
        Contacts newContact = Contacts.createContact(name, phoneNum);
        if (mobilePhone.createContact(newContact)) {
            System.out.println("New contact: " + name + ", " + phoneNum + " was created!");
        } else {
            System.out.println("Contact could not be created!");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Enter new contact name: ");
            String newName = sc.nextLine();
            System.out.println("Enter new contact phone number: ");
            String newNumber = sc.nextLine();
            if (mobilePhone.queryContact(newName) == null) {
                Contacts newContact = Contacts.createContact(newName, newNumber);
                mobilePhone.updateContact(existingContact, newContact);
            } else {
                System.out.println("A contact with that name already exists!");
            }

        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
        }

        mobilePhone.removeContact(existingContact);
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(existingContact.getName() + " was found in your contacts with phone number: " + existingContact.getPhoneNumber());
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone. . .");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

}
