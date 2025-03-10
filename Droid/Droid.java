package Droid;

public class Droid {
    protected String name;
    protected int batteryLevel;
  
  
    public Droid(String droidName){
      this.name = droidName;
      this.batteryLevel = 100;
    }
  
    public String toString(){
      return "Name: " + name + "\n" +
      "Battery: " + batteryLevel;
    }
  
  
    public static void main(String[] args){
      Droid droid1 = new Droid("Codey");
      System.out.println(droid1);
    }
}
