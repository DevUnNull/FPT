/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Matrix;
import utils.Validator;

/**
 *
 * @author admin
 */
public class MatrixInputer {

    private Matrix matrix;

    public MatrixInputer() {
        matrix = new Matrix();
    }

    public Matrix input(String messInfo, int row, int col) {
        matrix.setRows(row);
        matrix.setCols(col);
        int[][] data = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = Validator.getInt(messInfo + String.format("[%d][%d]:", i + 1, j + 1),
                        "Error range", "Values of matrix must be the number", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        matrix.setData(data);
        return matrix;
    }
}
