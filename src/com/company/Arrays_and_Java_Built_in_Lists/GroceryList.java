package company.Arrays_and_Java_Built_in_Lists;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have: " + groceryList.size() + " items in your grocery list.");
        for (int i =0; i <groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i)); //gets item number i and returns its contents, add 1 to i since arrays start at 0
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem); //checking to see if the current item is in the file, if it is then passing the new item.
        if (position >= 0 ) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        String theItem = groceryList.get(position+1);
        groceryList.set(position+1, newItem);
        System.out.println("Grocery item " + theItem + " has been modified");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0 ) { // determine if item is actually in the array list
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Item " + theItem + " has been removed from the grocery list.");
    }

    private int findItem(String searchItem) { // making this private so we can keep these functions internal
        return groceryList.indexOf(searchItem);
        //        boolean exists = groceryList.contains(searchItem);
//        if (exists) {
//            return searchItem + " found in grocery list.";
//        }
//        return searchItem + " not found in grocery list.";
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >= 0) {
            return true;
        } else
            return false;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
