/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Scanner;

/**
 *
 * @author UnNull
 */
public class Validator {
    /*
    messageInfo , the message to be printed instructing the user to input
    
    messageErrorOutRange , the message to be printed if the String parse value is
    out of range
    
    messageErrorInvalidNumber , the message to be printed if the String does no 
    contain a parable integer
    
    min max is minimum value and maximum value
    */
    public static int getMessage(String messageInfor,String messageErrorOutRage,String messageErrorIvalidNumber,int min, int max){
        Scanner scan = new Scanner(System.in);
        //loop to re-enter until input is valid
        do{
            try {
                System.out.print(messageInfor);
                int number = Integer.parseInt(scan.nextLine());
                // check number is in range
                if(number >= min && number <= max){
                    return number;
                }else{
                    System.out.println(messageErrorOutRage);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorIvalidNumber); // input is does't number
            }
        }while(true);
    }
        
}