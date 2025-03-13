package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);
    
    boolean running = true;

    while(running){
        System.out.println("\n===== CALCULATOR MENU =====");
        System.out.println("1. Basic Operations");
        System.out.println("2. Scientific Operations");
        System.out.println("Exit");
        
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                performBasicOperation(calculator, scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //helper methods
    private static void performBasicOperation(Calculator calculator, Scanner scanner){
        System.out.println("\n--- Basic Operations ---");
        System.out.println("1. Addition (+) ");
        System.out.println("2. Subtraction (-) ");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.println("Enter your choice of operation: ");
        int choice = scanner.nextInt(); 

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        switch(choice){
            case 1: 
                System.out.println(calculator.add(num1,num2));
                break;
            case 2:
                System.out.println(calculator.subtract(num1, num2));
                break;
            case 3:
                System.out.println(calculator.multiply(num1, num2));
                break;
            case 4:
                try {
                    System.out.println("Result: " + calculator.divide(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation. Try again.");
        }
    }

        private static void performScientificOperation(Calculator calculator, Scanner scanner){
            System.out.println("\\n--- Scientific Operations ---");
            System.out.println("1. Modulo");
            System.out.println("2. Square");
            System.out.println("3. Square Root");
            System.out.println("4. Power");
            System.out.println("5. Sin/cos/tan");
            System.out.println("6. Log");
            System.out.println("7. Ln");

            System.out.println("Enter your choice of operation: ");
            int choice = scanner.nextInt();
            
            switch(choice){
                case 1: 
                    System.out.println("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double num2 = scanner.nextDouble();

                    System.out.println(calculator.modulo(num1, num2));
                    break;
                case 2:
                    System.out.println("Enter number: ");
                    double numSquare = scanner.nextDouble();
                    System.out.println(calculator.square(numSquare));
                    break;
                case 3:
                    System.out.println("Enter number: ");
                    double numDouble = scanner.nextDouble();
                    System.out.println(calculator.squareRoot(numDouble));
                case 4:
                    System.out.println("Enter first number: ");
                    double num1Power = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double num2Power= scanner.nextDouble();

                    System.out.println(calculator.power(num1Power,num2Power));
                    break;
                case 5:
                    System.out.println("Choose operations");
                    System.out.println("1. Sin");
                    System.out.println("2. Cos");
                    System.out.println("3. Tan");

                    int choice2 = scanner.nextInt();

            }

        }
}

