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

    // Constructor 
    public ProtocolDroid(String serialNumber, String name){
        super(serialNumber, name);
        this.diplomacySkill = 70; 
        this.languageKnown = new ArrayList<>();

        //default languages 
        languageKnown.add("English");
        languageKnown.add("Vietnamese");
        languageKnown.add("French");

    }

    // Implement abstract method for this drone
    @Override
    public void performPrimaryFunction(){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " primary function is specializes in communication and cultural protocols");
        consumeBattery(5);
    }

    // Getter & setter
    public List<String> getLanguagesKnown(){
        return new ArrayList<>(languageKnown);
    }
    public int getDiplomacySkill() {
        return diplomacySkill;
    }
    
    public int getLanguageCount() {
        return languageKnown.size();
    }

    public void learnLanguage(String language){
        if(!languageKnown.contains(language)){
            languageKnown.add(language);
            System.out.println(name + " has learned " + language);
            consumeBattery(20); //consume 20% to learn a new language 
        }else {
            System.out.println(name + " already knows " + language);
        }
    }

    // Implement interface method
    @Override
    public void translate(String fromLanguage, String toLanguage, String message){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        
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

    // Skill advancement
    public void studyDiplomacy(){
        System.out.println(name + " is studying diplomatic protocols.");
        diplomacySkill += 10;
        if (diplomacySkill > 100) diplomacySkill = 100;
        System.out.println("Diplomacy skill has increased to " + diplomacySkill);
        consumeBattery(30);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            "Type: Protocol Droid\n" +
            "Languages Known: " + languageKnown.size() + "\n" +
            "Diplomacy Skill: " + diplomacySkill;
    }

}
