package Calculator;

public class Calculator {
    protected double a;
    protected double b;

    //constructor
    public Calculator(){}

    //basic operations
    public double add(double a, double b){
        return a + b;
    }

    public double subtract(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        if(b == 0){
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    //scientific functions 
    public double square(double a){
        return a * a; 
    }

    public double squareRoot(double a){
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(a);
    }

    public double power(double base, double exponent){
        return Math.pow(base, exponent);
    }

    public double modulo(double a, double b){
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed");
        }
        return a % b;
    }

    //trigonometric functions
    public double sin(double angleInRadians) {
        return Math.sin(angleInRadians);
    }

    public double cos(double angleInRadians) {
        return Math.cos(angleInRadians);
    }

    public double tan(double angleInRadians) {
        // Check for undefined values
        double normalized = angleInRadians % Math.PI;
        if (Math.abs(normalized - Math.PI/2) < 1e-10) {
            throw new ArithmeticException("Tangent is undefined at π/2 + nπ");
        }
        return Math.tan(angleInRadians);
    }

    public double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot calculate logarithm of non-positive number");
        }
        return Math.log10(a);
    }

    public double ln(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot calculate natural logarithm of non-positive number");
        }
        return Math.log(a);
    }


}
