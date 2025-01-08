/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public Matrix addition(Matrix other) throws Exception {
        if (rows != other.rows && cols != other.cols) {
            throw new Exception("Rows and cols of two matrix must be equal");
        }
        Matrix result = new Matrix();
        int[][] dataResult = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        return result;
    }

    public Matrix subtraction(Matrix other) throws Exception {
        if (rows != other.rows && cols != other.cols) {
            throw new Exception("Rows and cols of two matrix must be equal");
        }
        Matrix result = new Matrix();
        int[][] dataResult = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        return result;
    }

    public Matrix multiplication(Matrix other) throws Exception {
        if (cols != other.rows) {
            throw new Exception("Rows of matrix 1 must be equal cols of matrix 2");
        }
        Matrix result = new Matrix();
        int[][] dataResult = new int[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dataResult[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        result.setRows(rows);
        result.setCols(other.cols);
        result.setData(dataResult);
        return result;
    }

    public String display() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += String.format("[%d]", data[i][j]);
            }
            str += "\n";
        }
        return str;
    }
}
