/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import bo.MatrixInputer;
import entity.Matrix;
import utils.Validator;

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

        MatrixInputer inputer1 = new MatrixInputer();
        MatrixInputer inputer2 = new MatrixInputer();
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix result = new Matrix();
        while (true) {
            // Display menu
            int choice = Validator.getInt("========Calculator program========\n"
                    + "1. Addition Matrix\n"
                    + "2. Subtraction Matrix\n"
                    + "3. Multiplication Matrix\n"
                    + "4. Quit\n"
                    + "Your choice: ",
                    "Just be 1->4", "Please enter integer number", 1, 4);

            // Enter an option
            switch (choice) {
                case 1:
                    System.out.println("-------- Addition --------");
                    // Enter matrix1
                    int rows = Validator.getInt("Enter Row Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    int cols = Validator.getInt("Enter Column Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    // Enter matrix2
                    rows = Validator.getInt("Enter Row Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    cols = Validator.getInt("Enter Column Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    // Display 
                    System.out.println("-------- Result --------");
                    System.out.print(matrix1.display());
                    System.out.println("+");
                    System.out.print(matrix2.display());
                    System.out.println("=");
                    try {
                        result = matrix1.addition(matrix2);
                        System.out.println(result.display());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("-------- Subtraction --------");
                    // Enter matrix1
                    rows = Validator.getInt("Enter Row Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    cols = Validator.getInt("Enter Column Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    // Enter matrix2
                    rows = Validator.getInt("Enter Row Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    cols = Validator.getInt("Enter Column Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    // Display 
                    System.out.println("-------- Result --------");
                    System.out.print(matrix1.display());
                    System.out.println("-");
                    System.out.print(matrix2.display());
                    System.out.println("=");
                    try {
                        result = matrix1.subtraction(matrix2);
                        System.out.println(result.display());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("-------- Multiplication --------");
                    // Enter matrix1
                    rows = Validator.getInt("Enter Row Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    cols = Validator.getInt("Enter Column Matrix 1: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    // Enter matrix2
                    rows = Validator.getInt("Enter Row Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    cols = Validator.getInt("Enter Column Matrix 2: ", "Just be >0", "Please enter integer number", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    // Display 
                    System.out.println("-------- Result --------");
                    System.out.print(matrix1.display());
                    System.out.println("*");
                    System.out.print(matrix2.display());
                    System.out.println("=");
                    try {
                        result = matrix1.multiplication(matrix2);
                        System.out.println(result.display());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
            
        }
        
    }
    
}
