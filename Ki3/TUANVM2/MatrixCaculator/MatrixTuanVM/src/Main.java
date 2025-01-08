
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
        Display display = new Display();
        GetInputData getInputData = new GetInputData();
        Calculator calculator = new Calculator();

        // Loop util eser choose exit
        while (true) {
            //Step1: Display menu
            display.displayMenu();
            //Step2: Enter option
            int option = getInputData.getInt("Your choice: ", "Enter positive integer number", 1, 4);
            switch (option) {
                //Option1: Addition matrixes
                case 1:
                    calculator.additionMatrix();
                    break;
                //Option2: Subtraction matrixes
                case 2:
                    calculator.subtractionMatrix();
                    break;
                //Option3: Multiplication matrixes
                case 3:
                    calculator.multiplication();
                    break;
                //Option4: Exit
                case 4:
                    System.exit(0);
            }
        }
    }

}
