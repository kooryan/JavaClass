package company.Arrays_and_Java_Built_in_Lists.LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesVisit = new LinkedList<>();
        inOrder("Sydney", placesVisit);
        inOrder("Melbourne", placesVisit);
        inOrder("Brisbane", placesVisit);
        inOrder("Perth", placesVisit);
        inOrder("Canberra", placesVisit);
        inOrder("Darwin", placesVisit);
        inOrder("Adelaide", placesVisit);
        printList(placesVisit);

        inOrder("Alice Springs", placesVisit);
        inOrder("Darwin", placesVisit);
        printList(placesVisit);
        visit(placesVisit);
//        placesVisit.add(1, "Alice Springs"); | adding Alice Springs in element position 1, or directly after Sydney
//        printList(placesVisit);
//
//        placesVisit.remove(4); |  Brisbane is now pointing to Canberra instead of Perth
//        printList(placesVisit);

    }

    public static void printList(LinkedList<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) { // while an element in the linked list is pointing to something else execute the following
            System.out.println("Now visiting: " + i.next()); // we're showing the next record in the LinkedList
        }
        System.out.println("=========================================");
    }

    // method to put cities in alphabetical order
    private static boolean inOrder(String newCity, LinkedList<String> linkedList) {
        ListIterator<String> listIterator = linkedList.listIterator(); // on creation, will automatically go to the first entry
        while (listIterator.hasNext()) {
            int comparison = listIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // same city found, no actions executed
                System.out.println(newCity + " already included as a destination.");
                return false;
            } else if (comparison > 0) {
                // new city comes BEFORE this one
                // Brisbane -> Adelaide (being added) outputs comparison as greater than 0
                listIterator.previous(); //goes back to the Brisbane record
                listIterator.add(newCity);
                return true;
            } else if (comparison < 0) ;
            // Move onto next city
            // Adelaide -> Brisbane (being added)
        }
        listIterator.add(newCity);
        return true;
    }

    static void visit(LinkedList<String> cities) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean goingForward = true; // tracking direction so we are not stuck on 1 element in the .previous() part
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting: " + listIterator.next()); // gets the very first city
            printMenu();
        }

        while (!exit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Trip is over.");
                    exit = true;
                    break;
                case 1:
                    if (!goingForward) { // if the user has selected to go forward and we are not going forward, we can check to see whether there is an entry to go forward to
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next()); // going to next entry
                    } else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false; // end of the list
                    }
                    break;
                case 2: // there is no "current position" in the ListIterator, so we are sort in an infinite loop
                    if (goingForward) { // similarly to case 1,
                        if (listIterator.hasPrevious()) {
                            listIterator.previous(); // extra .previous() to prevent from printing an element twice.
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) { // going to the previous entry in the LinkedList
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true; // only direction we can go is forward
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }


    }

    static void printMenu() {
        System.out.println("Available actions:\n press:");
        System.out.println("0 - to quit.");
        System.out.println("1 - to next city.");
        System.out.println("2 - to previous city");
        System.out.println("3 - print menu.");
    }


}
