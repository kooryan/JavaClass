package com.company.Arrays_and_Java_Built_in_Lists.ArrayList_Challenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumbers) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public void printContacts() {
        if (myContacts.size() == 0) {
            System.out.println("No contacts found!");
        } else {
        for (int i =0; i<this.myContacts.size(); i++) {
                System.out.println((i + 1) + "." +
                        this.myContacts.get(i).getName() + " " + this.myContacts.get(i).getPhoneNumber());
            }
        }
    }

    public boolean createContact(Contacts contacts) {
        if (findContact(contacts.getName()) >= 0) { //if an entry exists in the array list, it will return a number ZERO or Greater.
            System.out.println("Contact " + contacts.getName() + " is already on file!");
            return false;
        } else
            myContacts.add(contacts);
        return true; //successfully added the record
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found in your contacts!");
            return false;
        } else {
            this.myContacts.set(position, newContact);
            System.out.println("Contact " + oldContact.getName() + " was updated to the following: " + newContact.getName());
            return true;
        }
    }

    public boolean removeContact(Contacts contacts) {
        int position = findContact(contacts);
        if (position < 0) {
            System.out.println(contacts.getName() + " was not found in your contacts!");
            return false;
        } else {
            this.myContacts.remove(contacts);
            System.out.println("Contact " + contacts.getName() + " was removed from your contacts list.");
            return true;
        }
    }

    private int findContact(Contacts contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i; //returning the array position number in the Array List that we found this record in
            }
        }
        return -1;
    }

    public Contacts queryContact (String name) {
        int position = findContact(name);
        if (position >=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public String queryContact(Contacts contacts) { // calling on the top findContacts method
        if (findContact(contacts) >= 0) {
            System.out.println("Contact " + contacts.getName() + " was found.");
            return contacts.getName();
        } else
            System.out.println("Contact " + contacts.getName() + " was not found.");
        return null;
    }


}
