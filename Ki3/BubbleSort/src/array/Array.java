/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import constant.Constant;
import java.util.Random;

/**
 *
 * @author Tuandz
 */
public class Array {
    //create array
    private int array[] = null;

    /**
     * This construct a random array.
     *
     * @param number -length of array
     */
    public Array(int number) {
        Random rand = new Random();
        // array length = number
        array = new int[number];
        // loop assign random values ​​to each array element
        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(number);
        }
    }

    /**
     * This method is used to display Arrays on the screen.
     * @return 
     */
    @Override
    public String toString() {
        String str=" [";
        for (int i = 0; i < array.length; i++) {
            str+=array[i];
            if (i < array.length - 1) {
                str+=", ";
            } else {
                str+="]";
            }
        }
        return str;
    }

    /**
     * This method is used to sort array by bubble sort
     *
     * @param SORT_TYPE
     */
    public void bubbleSort(final String SORT_TYPE) {
        //creat variable temp
        int temp;
        // switch will select ASC or DESC 
        switch (SORT_TYPE) {
            // if sort_type = asc
            case Constant.ASC:
                // loop through each element in array
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        // if array[j] > array[j+1] these two elements will swap places.
                        if (array[j] > array[j + 1]) {
                            temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                break;
            // if sort_type = desc  
            case Constant.DESC:
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] < array[j + 1]) {
                            temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
