package Calculator;

public class Calculator {
    protected double a;
    protected double b;

    //constructor
    public Calculator(){}

    //basic functions
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
        return a/b; 
    }

    //scientific functions 
    public double modulo(double a, double b){
        return a % b;
    }

    public double square(double a){
        return a * a; 
    }

    public double squareRoot(double a){
        return Math.sqrt(a);
    }

    public double power(double base, double exponent){
        return Math.pow(base, exponent);
    }

    //sin,tan,log,ln fxn 
    public double sin(double angleInRadians) {
        return Math.sin(angleInRadians);
    }

    public double cos(double angleInRadians) {
        return Math.cos(angleInRadians);
    }

    public double tan(double angleInRadians) {
        return Math.tan(angleInRadians);
    }

    public double log(double a) {
        return Math.log10(a);
    }

    public double ln(double a) {
        return Math.log(a);
    }


}
