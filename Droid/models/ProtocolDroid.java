package Droid.models;

import java.util.ArrayList;
import java.util.List;

import Droid.interfaces.Protocol;

/*
 * Provides optimal communication and cultural protocols 
 */
public class ProtocolDroid extends Droid implements Protocol {
    private List<String> languageKnown;
    private int diplomacySkill;

    //constructor 
    public ProtocolDroid(String serialNumber, String name){
        super(serialNumber, name);
        this.diplomacySkill = 70; 
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

    //getters 
    public List<String> getLanguagesKnown(){
        return new ArrayList<>(languageKnown);
    }
    public int getDiplomacySkill() {
        return diplomacySkill;
    }
    
    public int getLanguageCount() {
        return languageKnown.size();
    }

    //language method
    public void learnLanguage(String language){
        if(!languageKnown.contains(language)){
            languageKnown.add(language);
            System.out.println(name + " has learned " + language);
            consumeBattery(20); //consume 20% to learn a new language 
        }else {
            System.out.println(name + " already knows " + language);
        }
    }

    //implement interface method
    @Override
    public void translate(String fromLanguage, String toLanguage, String message){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        
        //have to know both language to translate
        if(languageKnown.contains(fromLanguage) && languageKnown.contains(toLanguage)){
            System.out.println(name + " translates from " + fromLanguage + " to " + toLanguage + ":");
            System.out.println("Original: " + message);
            System.out.println("Translated: [" + message + " in " + toLanguage + "]");
            consumeBattery(20); //consume 20% to translate 
        }else{
            System.out.println(name + " cannot translate. Missing language knowledge.");
            System.out.println("Known languages: " + String.join(", ", languageKnown));
        }
    }

    @Override
    public void culturalBriefing(String culture){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " is providing cultural briefing on " + culture);
        System.out.println("Cultural protocol data accessed...");
        consumeBattery(10);
    }

    //to string method
    @Override
    public String toString() {
        return super.toString() + "\n" +
            "Type: Protocol Droid\n" +
            "Languages Known: " + languageKnown.size() + "\n" +
            "Diplomacy Skill: " + diplomacySkill;
    }

}
