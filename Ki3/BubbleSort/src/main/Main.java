/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import array.Array;
import constant.Constant;
import validate.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Enter number of array
        int number = Validator.getInt("Enter number of array:",
                "Error range(number>0)", "Invalid!",
                1, Integer.MAX_VALUE);
        //Step 2: Generate array 
        Array array = new Array(number);
        //Step 3: Display current array
        System.out.print("Unsorted array:");
        System.out.println(array.toString());
        try {
            //Step 4: Sort array
            array.bubbleSort(Constant.DESC);
        } catch (IllegalArgumentException e) {
            System.err.println("SORT FAIL!");
            return;
        }
        //Step 5: Display array affter Sort
        System.out.print("Sorted array:");
        System.out.println(array.toString());
    }
}
