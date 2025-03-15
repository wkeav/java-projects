package Calculator;

import java.util.ArrayList;
import java.util.List;

public class HandleHistory extends Calculator {

    private double memory = 0;
    private List<String> history = new ArrayList<>();
    private static final int MAX_HISTORY = 10;

    //memory methods
    public void memoryClear() {
        memory = 0;
    }
    
    public void memoryStore(double value) {
        memory = value;
    }
    
    public double memoryRecall() {
        return memory;
    }
    
    public void memoryAdd(double value) {
        memory += value;
    }
    
    public void memorySubtract(double value) {
        memory -= value;
    }

    //history methods
    public void addToHistory(String operation, double result){
        history.add(operation + " = " + result);
        if(history.size() > MAX_HISTORY){
            history.remove(0);
        }
    }
    
    public List<String> getHistory(){
        return new ArrayList<>(history);
    }

    public void clearHistory(){
        history.clear();
    }

    //override calculator method to track history 
    @Override
    public double add(double a, double b){
        double result = super.add(a, b);
        addToHistory(a + " + " + b, result);
        return result;
    }

    @Override
    public double subtract(double a, double b){
        double result = super.subtract(a, b);
        addToHistory(a + " - " + b, result);
        return result;
    }

    @Override
    public double multiply(double a, double b){
        double result = super.multiply(a, b);
        addToHistory(a + " * " + b, result);
        return result;
    }

    @Override
    public double divide(double a, double b){
        if(b == 0){
            throw new ArithmeticException("Division by zero is not allowed");
        }
        double result = super.divide(a, b);
        addToHistory(a + " / " + b, result);
        return result;
    }

    //scientific operations
    @Override
    public double square(double a) {
        double result = super.square(a);
        addToHistory("square(" + a + ")", result);
        return result;
    }

    @Override
    public double squareRoot(double a) {
        double result = super.squareRoot(a);
        addToHistory("sqrt(" + a + ")", result);
        return result;
    }

    @Override
    public double power(double base, double exponent) {
        double result = super.power(base, exponent);
        addToHistory(base + "^" + exponent, result);
        return result;
    }

    @Override
    public double modulo(double a, double b) {
        double result = super.modulo(a, b);
        addToHistory(a + " % " + b, result);
        return result;
    }

    //Trigonometric functions
    @Override
    public double sin(double angleInRadians) {
        double result = super.sin(angleInRadians);
        addToHistory("sin(" + angleInRadians + ")", result);
        return result;
    }

    @Override
    public double cos(double angleInRadians) {
        double result = super.cos(angleInRadians);
        addToHistory("cos(" + angleInRadians + ")", result);
        return result;
    }

    @Override
    public double tan(double angleInRadians) {
        double result = super.tan(angleInRadians);
        addToHistory("tan(" + angleInRadians + ")", result);
        return result;
    }

    //logarithmic functions
    @Override
    public double log(double a) {
        double result = super.log(a);
        addToHistory("log10(" + a + ")", result);
        return result;
    }

    @Override
    public double ln(double a) {
        double result = super.ln(a);
        addToHistory("ln(" + a + ")", result);
        return result;
    }
}

