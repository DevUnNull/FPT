/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import array.Array;
import validate.Validate;

/**
 *
 * @author HainmnHe180056 
 */
public class Main {
    public  static void main(String[] args){
        int number = Validate.getInt("Enter number of array", "Enrror range (number > 0)", "Invalid", 1, Integer.MAX_VALUE);
        Array array = new Array(number);
        System.err.print("Unsorted array:");
        System.err.println(array.toString());
        try {
            array.BubbleSort(constant.Constant.DESC);
        } catch (Exception e) {
            System.err.println("Sort fail!");
            return;
        }
        System.err.print("Sorted array:");
        System.err.println(array.toString());
    }
}
