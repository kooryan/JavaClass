package com.company.Arrays_and_Java_Built_in_Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Arrays_Challenge {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer[] myIntegers = getIntegers(5);

        System.out.println("Values from highest to lowest: " + Arrays.toString(sortArrays(myIntegers)));
    }

    public static Integer[] getIntegers(Integer number) {
        System.out.println("Enter " + number + " values:\r");
        Integer[] values = new Integer[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        return values;
    }

    public static Integer[] sortArrays(Integer[] sortedArrays) {

        /* more efficient, method 1 way of sorting the integers */
        Arrays.sort(sortedArrays, Collections.reverseOrder());

        /* less efficient, method 2 more complex way of sorting the integers */
//         Integer[] sortedArray = new Integer[arrays.length];
//        for (int i = 0; i<arrays.length; i++) {
//            sortedArray[i] = arrays[i];
//      }
//
//        or
//
//      int[] sortedArray = Arrays.copyOf(arrays, arrays.length);
//        boolean flag = true;
////        int temp;
////        while (flag) {
////            flag = false;
////            for (int i = 0; i <sortedArray.length -1; i++) {
////                if (sortedArray[i] < sortedArray[i+1]) {
////                    temp = sortedArray[i];
////                    sortedArray[i] = sortedArray[i+1];
////                    sortedArray[i+1] = temp;
////                    flag = true;
////                }
////            }
////        }
        return sortedArrays;
    }

}
