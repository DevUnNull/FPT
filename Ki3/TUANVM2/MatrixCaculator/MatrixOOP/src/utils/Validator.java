/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Validator(){
    }
    
    public static int getInt(String messageInfo, String messageErrorOutOfRange,
            String messageErrorNumber, int min, int max){          
        do {            
            try {
                System.out.print(messageInfo);
                int number= Integer.parseInt(SCANNER.nextLine());
                if(number >=min && number <=max){
                    return number;
                }else{
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (Exception e) {
                System.out.println(messageErrorNumber);            
            }
        } while (true);
    }
     
}
        

