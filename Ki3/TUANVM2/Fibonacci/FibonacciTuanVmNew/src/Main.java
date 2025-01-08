/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Step1: Generate Fibonacci sequence
        int[] array = generateFibonacci(45);
        // Step2: Display Fibonacci sequence
        displayFibonacci(array);
    }

    public static int[] generateFibonacci(int length) {
        int[] array = new int[length];
        addNumbersFibonacci(array, 0);
        return array;
    }

    public static void addNumbersFibonacci(int[] array, int index) {
        //Check is First or second number 
        if (index == 0 || index == 1) {
            array[index] = index;
        } // Next number
        else {
            array[index] = array[index - 1] + array[index - 2];
        }
        index++;
        //Check array is full or not
        if (index == array.length) {
            return;
        }
        addNumbersFibonacci(array, index);
    }

    public static void displayFibonacci(int[] array) {
        System.out.println("The " + array.length + " sequence fibonacci:");
        // Loop through each element in array
        for (int i = 0; i < array.length; i++) {
            // Check is last element or not
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + ".");
            }
        }
        //Test value
        for (int i = 0; i < array.length; i++) {
            System.out.println("Number " + (i + 1) + ": " + array[i]);
        }
    }
}
