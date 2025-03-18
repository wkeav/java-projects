package Droid;

import Droid.models.AstromechDroid;

public class Main {
    public static void main(String[] args){
        System.out.println("=== Welcome to Ultra Droid System! ===")

        AstromechDroid r2d2 = new AstromechDroid("R2-D2-001", "R2-D2");

        //activate 
        r2d2.activate();

    }
}
