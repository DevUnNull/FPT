/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Random;

/**
 *
 * @author User
 */
public class List {
    
    public static void creatList(int number){
        LinkedList<Integer> ll = new LinkedList<>();
        Random ran = new Random();
        for(int i=0;i<number;i++){
            ll.addLast(ran.nextInt(0, number));
        }
        ll.traverse();
        
    }
    
}
