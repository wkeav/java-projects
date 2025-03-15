package Calculator;

public class HandleHistory extends Calculator {

    private double memory = 0;
    
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

}
