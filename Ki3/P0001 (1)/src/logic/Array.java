/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Random;

/**
 *
 * @author UnNull
 */
public class Array {
    // create array 
    int[] array=null;
    // this a construc a random array
    public Array(int number){
        Random rand = new Random();
        // set length array equar number
        array = new int[number];
        // loop through each element in array
        for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(0, array.length);
        }
    }
    
    // This method is used to sort array
    public void bubbleSort(){
        //creat variable temp
        int temp;
        //loop through each element in array
        for(int i =0;i<array.length;i++){
            for(int j=0;j<array.length - i - 1;j++){
                // if the firt number is less than the secon number , then swap place
                if(array[j] < array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public String display(){
        String str = " [";
        for(int i=0;i<array.length;i++){
            str += array[i];
            if(i<array.length-1){
                str += ", ";
            }else{
                str += "]";
            }
        }
        return str;
    }
}
