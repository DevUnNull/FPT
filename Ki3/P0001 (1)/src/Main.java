
import java.util.Scanner;
import logic.Validator;
import logic.Array;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author UnNull
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //step 1: Enter number of array
        int number  = Validator.getMessage("Input number: ", "Error out rage", "Error ivalid number", 0, Integer.MAX_VALUE);
        //step 2: Generate array
        Array array = new Array(number);
        //step 3: Display curren array
        System.out.println(array.display());
        //step 4: Sort array
        array.bubbleSort();
        //step 5: Display array affter sort
        System.out.println(array.display());
*/
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        scan.nextLine();
        System.out.println(n);
    }
}
