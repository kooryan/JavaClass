package com.company.Arrays_and_Java_Built_in_Lists;

import java.util.Scanner;

public class Arrays {

    /* Use 1 of arrays */
//    public static void main(String[] args) {
//
//        // int[] myIntArray = 50; this is illegal
//
//        int[] myIntArray = new int[25];
////                int[] myIntArray = {1,2,3,4,5,6,7,8,9,10};
////        System.out.println(myIntArray[0]);
////        System.out.println(myIntArray[6]);
//
//        printArray(myIntArray);
//
//    }
//
//    public static void printArray(int[] array) {
//        for(int i = 0; i < array.length; i++) {
//            array[i] = i*10;
//            System.out.println("Element " + i + " is " + array[i]);
//        }
//    }

    /* Use 2 of arrays (real life example) */

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);

        for(int i = 0; i<myIntegers.length; i++) {
            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }

        System.out.println("The average is " + getAverage(myIntegers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values:\t");
        int[] values = new int[number];

        for(int i = 0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i<array.length; i++) {
            sum += array[i]; // this retrieves the value inside element [i] e.g: if the number 5 is stored in element 1 (i = 1) we would be adding 5 to the sum value.
        }
        return (double) sum / (double) array.length;
    }
}
