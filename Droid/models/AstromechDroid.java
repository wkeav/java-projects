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
    }

    @Override
    public void performScientificOperation(){
        
    }
}
