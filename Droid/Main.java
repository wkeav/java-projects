package Droid;

import java.util.Scanner;

import Droid.models.AstromechDroid;
import Droid.models.MedicalDroid;
import Droid.models.ProtocolDroid;

public class Main {
    public static void main(String[] args){
        System.out.println("=== Welcome to Ultra Droid System! ===");

        // AstromechDroid r2d2 = new AstromechDroid("R2-D2-001", "R2-D2");

        //activate 
        // r2d2.activate();
        // System.out.println(r2d2); //toString method inheritance 
        // r2d2.performPrimaryFunction();
        // r2d2.plugIntoShip();
        // r2d2.repairSystem("Hyperdrive");
        // System.out.println(r2d2);
        // r2d2.getRepairSkill();

        AstromechDroid r2d2 = new AstromechDroid("R2-D2-001", "R2-D2");
        ProtocolDroid c3po = new ProtocolDroid("C-3PO-001", "C-3PO");
        MedicalDroid md60 = new MedicalDroid("MD-60-001", "MD-60");
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== DROID CONTROL MENU ===");
            System.out.println("1. Operate Astromech Droid (R2-D2)");
            System.out.println("2. Operate Protocol Droid (C-3PO)");
            System.out.println("3. Operate Medical Droid (MD-60)");
            System.out.println("4. Display All Droids Status");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    operateAstromechDroid(r2d2, scanner);
                    break;
                case 2:
                    operateProtocolDroid(c3po, scanner);
                    break;
                case 3:
                    operateMedicalDroid(md60, scanner);
                    break;
                case 4:
                    displayDroidStatus(r2d2, c3po, md60);
                    break;
                case 5:
                    running = false;
                    System.out.println("Shutting down droid control system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void operateAstromechDroid(AstromechDroid droid, Scanner scanner) {
        System.out.println("\n=== ASTROMECH DROID CONTROL ===");
        System.out.println("1. Activate/Deactivate");
        System.out.println("2. Perform Primary Function");
        System.out.println("3. Plug Into Ship");
        System.out.println("4. Navigate Starship");
        System.out.println("5. Repair System");
        System.out.println("6. Charge Battery");
        System.out.println("7. Return to Main Menu");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (choice) {
            case 1:
                if (droid.isActivated()) {
                    droid.deactivate();
                } else {
                    droid.activate();
                }
                break;
            case 2:
                droid.performPrimaryFunction();
                break;
            case 3:
                if (droid.isActivated()) {
                    droid.plugIntoShip();
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 4:
                droid.navigateStarship();
                break;
            case 5:
                if (droid.isActivated()) {
                    System.out.print("Enter system name to repair: ");
                    String system = scanner.nextLine();
                    droid.repairSystem(system);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 6:
                System.out.print("Enter charge amount (0-100): ");
                int amount = scanner.nextInt();
                droid.chargeBattery(amount);
                break;
            case 7:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void operateProtocolDroid(ProtocolDroid droid, Scanner scanner) {
        System.out.println("\n=== PROTOCOL DROID CONTROL ===");
        System.out.println("1. Activate/Deactivate");
        System.out.println("2. Perform Primary Function");
        System.out.println("3. Learn Language");
        System.out.println("4. Translate Message");
        System.out.println("5. Cultural Briefing");
        System.out.println("6. Study Diplomacy");
        System.out.println("7. Charge Battery");
        System.out.println("8. Return to Main Menu");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                if (droid.isActivated()) {
                    droid.deactivate();
                } else {
                    droid.activate();
                }
                break;
            case 2:
                droid.performPrimaryFunction();
                break;
            case 3:
                System.out.print("Enter language to learn: ");
                String language = scanner.nextLine();
                droid.learnLanguage(language);
                break;
            case 4:
                if (droid.isActivated()) {
                    System.out.print("From language: ");
                    String from = scanner.nextLine();
                    System.out.print("To language: ");
                    String to = scanner.nextLine();
                    System.out.print("Message: ");
                    String message = scanner.nextLine();
                    droid.translate(from, to, message);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 5:
                if (droid.isActivated()) {
                    System.out.print("Enter culture for briefing: ");
                    String culture = scanner.nextLine();
                    droid.culturalBriefing(culture);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 6:
                droid.studyDiplomacy();
                break;
            case 7:
                System.out.print("Enter charge amount (0-100): ");
                int amount = scanner.nextInt();
                droid.chargeBattery(amount);
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void operateMedicalDroid(MedicalDroid droid, Scanner scanner) {
        System.out.println("\n=== MEDICAL DROID CONTROL ===");
        System.out.println("1. Activate/Deactivate");
        System.out.println("2. Perform Primary Function");
        System.out.println("3. Patient Diagnosis");
        System.out.println("4. Perform Surgery");
        System.out.println("5. Administer Medication");
        System.out.println("6. Patient Monitoring");
        System.out.println("7. Upgrade Medical Database");
        System.out.println("8. Upgrade Surgery Program");
        System.out.println("9. Charge Battery");
        System.out.println("10. Return to Main Menu");
        
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (choice) {
            case 1:
                if (droid.isActivated()) {
                    droid.deactivate();
                } else {
                    droid.activate();
                }
                break;
            case 2:
                droid.performPrimaryFunction();
                break;
            case 3:
                if (droid.isActivated()) {
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    droid.patientDiagnosis(patientName);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 4:
                if (droid.isActivated()) {
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter procedure: ");
                    String procedure = scanner.nextLine();
                    droid.performSurgery(patientName, procedure);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 5:
                if (droid.isActivated()) {
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter medication: ");
                    String medication = scanner.nextLine();
                    droid.medicalAssistance(patientName, medication);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 6:
                if (droid.isActivated()) {
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    droid.patientMonitor(patientName);
                } else {
                    System.out.println("Droid must be activated first.");
                }
                break;
            case 7:
                droid.upgradeMedicalDatabase();
                break;
            case 8:
                droid.upgradeSurgeryProgram();
                break;
            case 9:
                System.out.print("Enter charge amount (0-100): ");
                int amount = scanner.nextInt();
                droid.chargeBattery(amount);
                break;
            case 10:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void displayDroidStatus(AstromechDroid astromech, ProtocolDroid protocol, MedicalDroid medical) {
        System.out.println("\n=== DROID STATUS REPORT ===");
        System.out.println("\nASTROMECH DROID:");
        System.out.println(astromech);
        
        System.out.println("\nPROTOCOL DROID:");
        System.out.println(protocol);
        
        System.out.println("\nMEDICAL DROID:");
        System.out.println(medical);

    }
}
