
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class GetInputData {

    Scanner sc = new Scanner(System.in);

    public int getInt(String msg, String msgErr, int min, int max) {
        Scanner sc = new Scanner(System.in);
        // Loop to re-enter input if invalid
        while (true) {
            System.out.print(msg);
            String inputString = sc.nextLine();
            //Check input is empty or not
            if (inputString.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else {
                try {
                    int input = Integer.parseInt(inputString);
                    //Check input is in range
                    if (input >= min && input <= max) {
                        return input;
                    } else {
                        System.out.println("Please enter in range " + min + " to " + max);
                    }
                } catch (Exception e) {
                    System.out.println(msgErr);
                }
            }
        }
    }

    public int[][] getMatrix1(char option) {
        switch (option) {
            case '+':
                System.out.println("-------- Addition --------");
                break;
            case '-':
                System.out.println("-------- Subtraction --------");
                break;
            case '*':
                System.out.println("-------- Multiplication --------");
                break;
        }
        int rows = getInt("Enter Rows Matrix 1:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
        int cols = getInt("Enter Columns Matrix 1:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[rows][cols];
        // Loop through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Loop through each column of the matrix
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getInt("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]:", "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    public int[][] getMatrix2(int[][] matrix1, char option) {
        int rowsOfMatrix1 = matrix1.length;
        int colsOfMatrix1 = matrix1[0].length;
        int rows, cols;
        int[][] matrix = null;
        switch (option) {
            case '+':
            case '-':
                // Loop to re-enter rows if invalid value
                while (true) {
                    rows = getInt("Enter Rows Matrix 2:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
                    // Check if rows of matrix2 are same as rows of matrix1 or not
                    if (rows == rowsOfMatrix1) {
                        break;
                    } else {
                        System.out.println("Number of rows in Matrix 2 must be the same as in Matrix 1");
                    }
                }
                // Loop to re-enter columns if invalid value
                while (true) {
                    cols = getInt("Enter Columns Matrix 2:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
                    // Check if columns of matrix2 are same as columns of matrix1
                    if (cols == colsOfMatrix1) {
                        break;
                    } else {
                        System.out.println("Number of columns in Matrix 2 must be the same as in Matrix 1");
                    }
                }
                matrix = new int[rows][cols];
                // Loop through each row of the matrix
                for (int i = 0; i < rows; i++) {
                    // Loop through each column of the matrix
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = getInt("Enter Matrix2[" + (i + 1) + "][" + (j + 1) + "]:", "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    }
                }
                break;
            case '*':
                // Loop to re-enter rows
                while (true) {
                    rows = getInt("Enter Rows Matrix 2:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
                    // Check if rows of matrix2 are same as columns of matrix1
                    if (rows == colsOfMatrix1) {
                        break;
                    } else {
                        System.out.println("Number of rows in Matrix 2 must be the same as number of columns in Matrix 1");
                    }
                }
                cols = getInt("Enter Columns for Matrix 2:", "Please enter a positive integer", 1, Integer.MAX_VALUE);
                matrix = new int[rows][cols];
                // Loop through each row of the matrix
                for (int i = 0; i < rows; i++) {
                    // Loop through each column of the matrix
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = getInt("Enter Matrix2[" + (i + 1) + "][" + (j + 1) + "]:", "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    }
                }
                break;
        }
        return matrix;
    }
}
