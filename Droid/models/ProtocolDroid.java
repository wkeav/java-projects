package Droid.models;

import java.util.ArrayList;
import java.util.List;

import Droid.interfaces.Protocol;

/*
 * Provides optimal communication and cultural protocols 
 */
public class ProtocolDroid extends Droid implements Protocol {
    private List<String> languageKnown;
    private int diplomacySKill;

    //constructor 
    public ProtocolDroid(String serialNumber, String name){
        super(serialNumber, name);
        this.diplomacySKill = 70; 
        this.languageKnown = new ArrayList<>();

        //default languages 
        languageKnown.add("English");
        languageKnown.add("Vietnamese");
        languageKnown.add("French");

    }

    //implement abstract method for this drone
    @Override
    public void performPrimaryFunction(){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " primary function is specializes in communication and cultural protocols");
        consumeBattery(5);
    }

    //language method
    


}
