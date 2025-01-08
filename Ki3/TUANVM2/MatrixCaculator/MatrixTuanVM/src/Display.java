/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Display {

    public void displayMenu() {
        System.out.println("======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public void displayMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Iterate through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Iterate through each column of the matrix
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, char option) {
        System.out.println("-------- Result --------");
        switch (option) {
            case '+':
                displayMatrix(matrix1);
                System.out.println("+");
                displayMatrix(matrix2);
                System.out.println("=");
                displayMatrix(result);
                break;
            case '-':
                displayMatrix(matrix1);
                System.out.println("-");
                displayMatrix(matrix2);
                System.out.println("=");
                displayMatrix(result);
                break;
            case '*':
                displayMatrix(matrix1);
                System.out.println("*");
                displayMatrix(matrix2);
                System.out.println("=");
                displayMatrix(result);
                break;
        }
    }
}
