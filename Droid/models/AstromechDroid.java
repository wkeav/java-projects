package Droid.models;

import Droid.interfaces.Repairable;

/*
 * Represents utility droid specialize in ship repair & navigation
 */
public class AstromechDroid extends Droid implements Repairable{
    private int navigateSkill;
    private int repairSkill; 
    private boolean isPluggedIntoShip; 

    //constructor
    public AstromechDroid(String serialNumber, String name){
        super(serialNumber, name);
        this.isPluggedIntoShip = false;
        //default skill set
        this.navigateSkill = 70; 
        this.repairSkill = 70; 
    }

    //implement abstract method
    @Override
    public void performPrimaryFunction(){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        System.out.println(name + " primary function is ship diagnostics and repairs.");
        consumeBattery(5); // lose 5% battery automatically when perform its primary function
    }

    public void plugIntoShip(){
        isPluggedIntoShip = true;
        System.out.println(name + " has been plugged into the ship.");
    }

    public void navigateStarship(){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        if (!isPluggedIntoShip){
            System.out.println(name + " needs to be plug into the ship's system.");
            return;
        }

        System.out.println(name + " is calculating hyperspace jump coordinates.");
        consumeBattery(15); // consume 15% battery each time for navigate ship
        this.navigateSkill += 5;
    }

    public void unplugFromShip(){
        isPluggedIntoShip = false;
        System.out.println(name + " has been unplugged from the ship.");
    }

    public int getNavigateSkill(){
        return navigateSkill;
    }

    public int getRepairSkill(){
        return repairSkill;
    }

    //implement interface methods
    @Override
    public void repairSystem(String systemName){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        if (!isPluggedIntoShip){
            System.out.println(name + " needs to be plug into the ship's system.");
            return;
        }

        System.out.println(name + " is repairing the " + systemName + " system.");
        consumeBattery(20); //consume 15% battery each time to repair
        this.repairSkill += 5;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: Astromech Droid\n" +
                "Navigation Skill: " + navigateSkill + "\n" +
                "Repair Skill: " + repairSkill;
    }


}
