/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Validater {
    public static int getInfor(String messageInfor){
        int number;
        Scanner scan = new Scanner(System.in);
        System.err.print(messageInfor);
        number = scan.nextInt();
        
        return number;
    }
}
