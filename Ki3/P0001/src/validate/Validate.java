/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Validate {
    /*
        hien chu input
        hien chu nhap sai min max
        hien chu khong nhap
        min mx
     */
    public static int getInt(String messageInfo, String messageOutOfRange, String messageInvalidNumber, int min , int max){
        Scanner scan = new Scanner(System.in);
        do{
            try {
                System.err.println(messageInfo);
                int number = Integer.parseInt(scan.nextLine());;
                if(number >=min && number <=max){
                    return number;
                }
                System.err.println(messageOutOfRange);
            } catch (NumberFormatException e) {
                System.err.println(messageInvalidNumber);
            }
        }while(true);
    }  
}
