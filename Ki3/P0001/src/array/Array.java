/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

import constant.Constant;
import java.util.Random;

/**
 *
 * @author User
 */
public class Array {
    int [] array=null;

    public Array(int number){
        array = new int[number];
        Random rand = new Random();
        for(int i=0;i<number; i++){
            array[i] = rand.nextInt(number);
        }
    }
    
    @Override
    public String toString() {
        String str = " [";
        for(int i =0;i<array.length;i++){
            str += array[i];
            if(i<array.length -1){
                str +=", ";
            }else{
                str +="]";
            }
        }
        return str;
    }
    
    
    
    public void BubbleSort(final String SortType){
        int temp;
        switch (SortType) {
            case Constant.ASC:
                for(int i=0;i<array.length-1;i++){
                    for(int j=0;j<array.length -1 -i ;j++){
                        if(array[j]>array[j+1]){
                            temp = array[j];
                            array[j]=array[j+1];
                            array[j+1]=temp;
                        }
                    }
                }
                break;
            case Constant.DESC:
                for(int i=0;i<array.length-1;i++){
                    for(int j=0;j<array.length -1 -i ;j++){
                        if(array[j]<array[j+1]){
                            temp = array[j];
                            array[j]=array[j+1];
                            array[j+1]=temp;
                        }
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
