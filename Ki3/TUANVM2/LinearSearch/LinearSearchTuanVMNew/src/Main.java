
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        //Step1: Enter number of array
        int numOfArr = getInt("Enter number of array:", "Please enter integer number > 0",
                "Please enter integer number", 1, Integer.MAX_VALUE);
        //Step2: Enter search value
        int searchNum = getInt("Enter search value:", "Out of range",
                "Please enter integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //Step3: Generate random array
        int[] randomArr = generateArr(numOfArr);
        //Step4: Display the array
        displayArr(randomArr);
        //Step5: Linear Search
        int indexOfSearchNum = linearSearch(randomArr, searchNum);
        //Step6: Display the index of search number in array
        displayIndex(indexOfSearchNum, searchNum);
    }

    public static int getInt(String mssInfo, String mssErrRange,
            String mssErrDataTye, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Loop until input valid number
        do {
            try {
                System.out.println(mssInfo);
                int number = Integer.parseInt(sc.nextLine());
                //Check number is in range
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(mssErrRange);
                }
            } catch (Exception e) {
                System.out.println(mssErrDataTye);
            }
        } while (true);
    }

    public static int[] generateArr(int length) {
        Random random = new Random();
        int[] array = new int[length];
        //Loop throught each element in array
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    public static void displayArr(int[] array) {
        System.out.println("The array: " + Arrays.toString(array));

    }

    public static int linearSearch(int[] array, int searchNum) {
        int index = -1;
        //Loop throught each element in array
        for (int i = 0; i < array.length; i++) {
            //Check key is in array or not
            if (array[i] == searchNum) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void displayIndex(int index, int searchNum) {
        //Check  index exist or not
        if (index != -1) {
            System.out.println("Found " + searchNum + " at index " + index);
        } else {
            System.out.println("Not found " + searchNum);
        }
    }
}
