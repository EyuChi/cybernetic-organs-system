package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    //Random example To CyberneticOrgan
    public static void main(String[] args) {
        System.out.println("Hello, I'm Batman!");

        Patient johnD = new Patient("John Doe", 30, "No known allergies");

        // Create sample organs
        CyberneticOrgan organ1 = new CyberneticOrgan("ORG001", "CyberHeartX1", "Pumps blood", "Type O");
        CyberneticOrgan organ2 = new CyberneticOrgan("ORG002", "CyberEyeV2", "Enhanced vision", "Type A");
        CyberneticOrgan organ3 = new CyberneticOrgan("ORG003", "CyberLungZ3", "Filters air", "Type B");
        CyberneticOrgan organ4 = new CyberneticOrgan("ORG004", "CyberLiverA5", "Detoxifies blood", "Type O");
        CyberneticOrgan organ5 = new CyberneticOrgan("ORG005", "CyberKidneyX4", "Regulates electrolytes", "Type AB");
        CyberneticOrgan organ6 = new CyberneticOrgan("ORG006", "CyberArmG7", "Enhanced strength", "Universal");

        //Start the list of the organs
        OrganInventory inventory = new OrganInventory();

        inventory.addOrgan(organ1);
        inventory.addOrgan(organ2);
        inventory.addOrgan(organ3);
        inventory.addOrgan(organ4);
        inventory.addOrgan(organ5);
        inventory.addOrgan(organ6);
        System.out.println(" \nEnd of Adding Organs \n ");

        // Add organs to the patient
        johnD.addOrgan(organ1);
        johnD.addOrgan(organ2);
        johnD.addOrgan(organ3);
        johnD.addOrgan(organ4);
        johnD.addOrgan(organ5);
       /*
       patient.addOrgan(organ6);// This should print "Too many organs installed! Cannot add more!"
        */

        System.out.println("\n End of Installing Organs \n");

        // Display patient info and organ list
        System.out.println(johnD.getPatientInfo());
        johnD.getOrganList();

        System.out.println("\n End of Patient Info \n");

        //Search For Organs with Functionality: Enhanced Vision
        ArrayList<CyberneticOrgan> foundOrgans = inventory.searchOrgan("Enhanced Vision");
        if (foundOrgans.isEmpty()) {
            System.out.println("No organs found with the specified functionality.");
        } else {
            for (CyberneticOrgan find : foundOrgans) {
                System.out.println(find.getDetails());
            }
        }
            System.out.println("\nEnd of Search \n ");


        //Sort OrganInventory by Model alphabetically
        inventory.sortOrgan();
        /*New term .unmodifiableList:
        Make it so the data cannot be access outside the OrganInventory Class
        To provide read-only access.
         */
        for (CyberneticOrgan organ : Collections.unmodifiableList(inventory.getOrganList()) )
            System.out.println(organ.getDetails());

        System.out.println("\nEnd of Sort \n ");

    }
}
