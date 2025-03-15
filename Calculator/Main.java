package Calculator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    HandleHistory calculator = new HandleHistory();
    Scanner scanner = new Scanner(System.in);
    
    boolean running = true;

    while(running){
        System.out.println("\n===== CALCULATOR MENU =====");
        System.out.println("1. Basic Operations");
        System.out.println("2. Scientific Operations");
        System.out.println("3. Logarithmic Functions" );
        System.out.println("4. Memory Functions");
        System.out.println("5. History");
        System.out.println("6. Exit");
        
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
                break;
            case 4: 
                performMemoryOperation(calculator, scanner);
                break;
            case 5:
                viewHistory(calculator,scanner);
                break;
            case 6:
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
    //memory operation helper
    private static void performMemoryOperation(HandleHistory calculator, Scanner scanner){
        System.out.println("\n--- Memory Operations ---");
        System.out.println("1. Store Value (MS)");
        System.out.println("2. Recall Value (MR)");
        System.out.println("3. Add to Memory (M+)");
        System.out.println("4. Subtract from Memory (M-)");
        System.out.println("5. Clear Memory (MC)");

        System.out.print("Enter operation: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                System.out.println("Enter value to store: ");
                calculator.memoryStore(scanner.nextDouble());
                System.out.println("Value has been stored in memory.");
                break;
            case 2:
                double result = calculator.memoryRecall();
                System.out.println("Memory value: " + result);
                break;
            case 3:
                System.out.println("Enter value to add to memory: ");
                calculator.memoryAdd(scanner.nextDouble());
                System.out.println("Value added to memory. New value: " + calculator.memoryRecall());
                break;
            case 4:
                System.out.print("Enter value to subtract from memory: ");
                calculator.memorySubtract(scanner.nextDouble());
                System.out.println("Value subtracted from memory. New value: " + calculator.memoryRecall());
                break;
            case 5:
                calculator.memoryClear();
                System.out.println("Memory cleared.");
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    private static void viewHistory(HandleHistory calcHistory, Scanner scanner){
        System.out.println("\n--- Calculation History ---");
        List<String> history = calcHistory.getHistory();

        if(history.isEmpty()){
            System.out.println("History is currently empty.");
        }else {
            for(int i = 0; i < history.size(); i++){
                System.out.println((i+1) + ": " + history.get(i));
            }

            System.out.println("\nOptions:");
            System.out.println("1. Clear History");
            System.out.println("2. Return to Main Menu");

            System.err.println("Enter your choice: ");
            int choice = scanner.nextInt();

            if(choice == 1){
                calcHistory.clearHistory();
                System.out.println("History cleared.");
            }
        }
    }
}

