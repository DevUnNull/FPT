/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.Scanner;

/**
 *
 * @author Tuandz
 */
public class Validator {
    private Validator() {
    }

    /**
     *Return the valid integer value scanned from the input
     * 
     * @param messageInfo               the message to be printed instructing 
     * the user to input
     * @param messageErrorOutOfRange    the message to be printed if the String 
     * parse value is out of range
     * @param messageErrorInvalidNumber the message to be printed if the String
     * does not contain a parable integer
     * @param min                       minimum Limit value
     * @param max                       maximum Limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);
        //loop to re-enter until input is valid
        do {
            try {
                System.out.println(messageInfo);
                int number = scanner.nextInt();
                // Check number is in range
                if (number >= min && number <= max) {
                    return number;
                }
                // Number is out of range
                System.out.println(messageErrorOutOfRange);
            } catch (Exception e) {
                System.out.println(messageErrorInvalidNumber); // input is does't number
                scanner.nextLine();
            }
        } while (true);
    }
}

