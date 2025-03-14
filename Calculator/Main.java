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
        System.out.println("3. Trigonometric Functions" );
        System.out.println("4. Logarithmic Functions"); 
        System.out.println("5. Exit");
        
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                performBasicOperation(calculator, scanner);
                break;
            case 2:
                performScientificOperation(calculator, scanner);
                break;
            case 3:
                performLogarithmicOperation(calculator, scanner);
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
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
        System.out.println("\n--- Scientific Operations ---");
        System.out.println("1. Square");
        System.out.println("2. Square Root");
        System.out.println("3. Power");
        System.out.println("4. Modulo");
        
        System.out.print("Enter operation: ");
        int choice = scanner.nextInt();
        
        try {
            switch(choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result: " + calculator.square(num));
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    System.out.println("Result: " + calculator.squareRoot(num));
                    break;
                case 3:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + calculator.power(base, exponent));
                    break;
                case 4:
                    System.out.print("Enter dividend: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter divisor: ");
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + calculator.modulo(a, b));
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performLogarithmicOperation(Calculator calculator, Scanner scanner){
        System.out.println("\n--- Logarithmic Operations ---");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. Logarithm (base 10)");
        System.out.println("5. Natural Logarithm");

        int choice = scanner.nextInt();
        try{

            switch(choice){
                case 1:
                    System.out.print("Enter angle (in radians): ");
                    double angle = scanner.nextDouble();
                    System.out.println("Result: " + calculator.sin(angle));
                    break;
                case 2:
                    System.out.print("Enter angle (in radians): ");
                    angle = scanner.nextDouble();
                    System.out.println("Result: " + calculator.cos(angle));
                    break;
                case 3:
                    System.out.print("Enter angle (in radians): ");
                    angle = scanner.nextDouble();
                    System.out.println("Result: " + calculator.tan(angle));
                    break;
                case 4:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result: " + calculator.log(num));
                    break;
                case 5:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    System.out.println("Result: " + calculator.ln(num));
                    break;
                default:
                    System.out.println("Invalid operation.");
                }
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
        }
    }
}

