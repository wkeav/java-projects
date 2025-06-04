package Droid.models;
import Droid.interfaces.Medical;
/*
 * Provide medical assistance and healthcare 
 * Can upgrade medical/surgery skill to actual program & database instead of doing those skills - because its medical 
 */
public class MedicalDroid extends Droid implements Medical {
    private int surgerySkill; 
    private int medicalSkill; 

    // Constructor
    public MedicalDroid(String serialNumber, String name){
        super(serialNumber, name);
        //default skill set
        this.surgerySkill = 35;
        this.medicalSkill = 70;
    }

    // Implement abstract method for this drone
    @Override
    public void performPrimaryFunction(){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " primary function is to provide medical assistance.");
        consumeBattery(5); // Consume 5% when give its primary function 
    }

    public int getSurgerySkill(){
        return surgerySkill;
    }

    public int getMedicalSkill(){
        return medicalSkill;
    }

    public void patientMonitor(String patientName){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " is monitoring vital signs for patient: " + patientName);
        System.out.println("Continuous monitoring mode activated.");
        consumeBattery(3); //consume 3% battery for monitoring
    }

    public void performSurgery(String patientName, String procedure){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        // Requirement
        if (surgerySkill < 30) {
            System.out.println(name + " does not have sufficient surgery skill for this procedure.");
            return;
        }
        System.out.println(name + " is performing " + procedure + " on patient: " + patientName);
        System.out.println("Surgery in progress...");
        consumeBattery(30);

    }

    // Implement medical interface 
    @Override
    public void patientDiagnosis(String patientName){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }
        
        System.out.println(name + " is diagnosing patient: " + patientName);
        System.out.println("Running medical scans...");
        consumeBattery(10); //consume 10% battery 
    }

    @Override
    public void medicalAssistance(String patientName, String medication){
        if (!isActivated) {
            System.out.println(name + " is not activated.");
            return;
        }

        System.out.println(name + " is administering " + medication + " to patient: " + patientName);
        consumeBattery(15); //consume 15% battery 
    }

    // Updating medical & surgery skill bases on the latest program 
    public void upgradeMedicalDatabase(){
        System.out.println(name + " is upgrading its medical database with latest treatments.");
        medicalSkill += 5;
        if (medicalSkill > 100) medicalSkill = 100;
        System.out.println("Medical skill increased to " + medicalSkill);
    }

    public void upgradeSurgeryProgram(){
        System.out.println(name + " is upgrading its surgery protocols.");
        surgerySkill += 5;
        if (surgerySkill > 100) surgerySkill = 100;
        System.out.println("Surgery skill increased to " + surgerySkill);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: Medical Droid\n" +
                "Medical Skill: " + medicalSkill + "\n" +
                "Surgery Skill: " + surgerySkill;
    }



}
