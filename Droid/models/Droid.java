package Droid.models;
/*
  * Parent of all droid classes
*/

public abstract class Droid {
    protected String name;
    protected String serialNumber; 
    protected int batteryLevel;
    protected int healthStatus;
    protected boolean isActivated;

    //abstract method that each droid must implement 
    public abstract void performPrimaryFunction();
  
    //constructor
    public Droid(String serialNumber, String name){
      this.serialNumber = serialNumber;
      this.name = name;
      this.batteryLevel = 100;
      this.healthStatus = 100;
      this.isActivated = false;
    }

    //droid operations
    public void activate(){
      isActivated = true;
      System.out.println(name + " has been activated.");

    }

    public void deactivate(){
      isActivated = false;
      System.out.println(name + " has been deactivated.");
    }

    public void chargeBattery(int amount){
      if (batteryLevel + amount > 100) {
        batteryLevel = 100;
      } else {
        batteryLevel += amount;
      }
      System.out.println(name + "'s battery charged to " + batteryLevel + "%");
    }

    public void consumeBattery(int amount){
      if(batteryLevel - amount < 0){
        batteryLevel = 0;
        deactivate();
        System.out.println(name + " has run out of battery and shut down.");
      }else {
        batteryLevel -= amount;
      }
    }

    public void repair(int amount){
      if (healthStatus + amount > 100){
        healthStatus = 100;
      }else {
        healthStatus +=amount;
      }
      System.out.println(name + " repaired to " + healthStatus + "% health");
    }
  
    //getter & setter
    public String getSerialNumber() {
      return serialNumber;
    }

    public String getName(){
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  
    public int getBatteryLevel() {
      return batteryLevel;
    }
  
    public int getHealthStatus() {
      return healthStatus;
    }
  
    public boolean isActivated() {
      return isActivated;
    }

    @Override
    public String toString(){
      return "Droid: " + name + "\n" +
      "Battery: " + batteryLevel + "%\n" +
      "Health Status: " + healthStatus + "%\n" +
      "Status: " + (isActivated ? "Activated" : "Deactivated");
    }
  
  
    
}
