/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Calculator {

    GetInputData getInputData = new GetInputData();
    Display display = new Display();

    public void additionMatrix() {
        int[][] matrix1 = getInputData.getMatrix1('+');
        int[][] matrix2 = getInputData.getMatrix2(matrix1, '+');
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        //Loop through each element of row
        for (int i = 0; i < rows; i++) {
            // Loop through each element of column
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        display.displayResult(matrix1, matrix2, result, '+');
    }

    public void subtractionMatrix() {
        int[][] matrix1 = getInputData.getMatrix1('-');
        int[][] matrix2 = getInputData.getMatrix2(matrix1, '-');
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        //Loop through each element of row
        for (int i = 0; i < rows; i++) {
            // Loop through each element of column
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        display.displayResult(matrix1, matrix2, result, '-');
    }

    public void multiplication() {
        int[][] matrix1 = getInputData.getMatrix1('*');
        int[][] matrix2 = getInputData.getMatrix2(matrix1, '*');
        int rowsOfMatrix1 = matrix1.length;
        int colsOfMatrix1 = matrix1[0].length;
        int colsOfMatrix2 = matrix2[0].length;
        int[][] result = new int[rowsOfMatrix1][colsOfMatrix2];
        // Loop through each element of row of matrix1
        for (int i = 0; i < rowsOfMatrix1; i++) {
            //Loop through each lement of column of matrix2
            for (int j = 0; j < colsOfMatrix2; j++) {
                //Loop through each element of the current row of matrix1 and the current column of matrix2
                for (int k = 0; k < colsOfMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        display.displayResult(matrix1, matrix2, result, '*');
    }
}
