
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Step1: Enter number of array
//        int number = getInt("Enter number of array:", "Please enter number > 0",
//                "Please enter integer number", 1, Integer.MAX_VALUE);
        //Step2: Enter search value
        int searchValue = getInt("Enter search value:", "Error range",
                "Please enter integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //Step3: Generate array
//        int[] array = generateRandomArray(number);
        int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
        //Step4: Sort array
        sortArray(array);
        //Step5: Display sort array
        displaySortArray(array);
        //Step6: Binary Search
        int index = BinarySearch(array, searchValue, true);
            //Step7: Display index of search value
        displayIndexOfSearchValue(array, searchValue, index);

    }

    public static int getInt(String mssInfo, String mssErrRange, String mssErrDataType, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Loop to re-enter util input is valid
        do {
            try {
                System.out.println(mssInfo);
                int number = Integer.parseInt(sc.nextLine());
                //Check number is in range
                if (number >= min && number <= max) {
                    return number;
                }// Number is out of range
                else {
                    System.out.println(mssErrRange);
                }
            } catch (Exception e) {
                System.out.println(mssErrDataType);
            }
        } while (true);
    }

    public static int[] generateRandomArray(int number) {
        int[] array = new int[number];
        Random random = new Random();
        //Loop for random integer is assigned from first to last element in array
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(number);
        }
        return array;
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static void displaySortArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static int BinarySearch(int[] array, int searchValue, boolean test) {
        int left = 0;
        int right = array.length - 1;
        int step = 1;

        //Loop until search array is empty
        while (left <= right) {
            int mid = (left + right) / 2;
            //Check if mid element equal to search value
            if (array[mid] == searchValue) {
                //Test
                if (test) {
                    System.out.print("Step " + step + " (middle element is " + array[mid]);
                    System.out.print(" == " + searchValue + "): [");
                    // Interate array to print elements
                    for (int i = 0; i < array.length; i++) {
                        // Check element in search range or not
                        if (i >= left && i <= right) {
                            System.out.print(array[i]);
                        } else {
                            System.out.print(" ");
                        }
                        // Check is last element or not
                        if (i < array.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
                return mid;
            }
            //Check Search value is in left or right
            if (array[mid] < searchValue) {
                //Test
                if (test) {
                    System.out.print("Step " + step + " (middle element is " + array[mid]);
                    System.out.print(" < " + searchValue + "): [");
                    // Loop through each element in array
                    for (int i = 0; i < array.length; i++) {
                        // Check element in search range or not
                        if (i >= left && i <= right) {
                            System.out.print(array[i]);
                        } else {
                            System.out.print(" ");
                        }
                        // Check is last element or not
                        if (i < array.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
                left = mid + 1;
                step++;
            } else {
                //Test
                if (test) {
                    System.out.print("Step " + step + " (middle element is " + array[mid]);
                    System.out.print(" > " + searchValue + "): [");
                    // Loop through each element in array
                    for (int i = 0; i < array.length; i++) {
                        // Check element in search range or not
                        if (i >= left && i <= right) {
                            System.out.print(array[i]);
                        } else {
                            System.out.print(" ");
                        }
                        // Check is last element or not
                        if (i < array.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
                right = mid - 1;
                step++;
            }

        }
        if (test) {
            System.out.print("Step " + step + " (searched value is absent): [ ");
            // Loop through each element in array 
            for (int i = 0; i < array.length; i++) {
                // Check is last element or not
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        return -1;
    }

    public static void displayIndexOfSearchValue(int[] array, int searchValue, int index) {
        Scanner sc = new Scanner(System.in);
        // Check search value exist or not
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println("Not found " + searchValue);
        }
    }

}
