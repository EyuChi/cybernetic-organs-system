package com.cybernetic;

public class OrganCompatiabilityAnalyzer {

    //Start of week 8
    //(Requirement 3.1) DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    public Patient findCompatiblePatient(Organ organ, WaitingList waitingList) {
        waitingListNode current = waitingList.getHead(); //Starts reading the head of the list (should be the highest priority)
        //Read the list out or to check if the list is empty.
        while (current != null) {
            Patient patient = current.getPatient();
            if (isCompatible(organ, patient)) {
                return patient; // Return the first compatible patient found
            }
            current = current.getNext();  //Move to the next patient in the list
        }
        return null;  //else return no compatible patient found
    }



    private boolean isCompatible(Organ organ, Patient patient) {
        int bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        int weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        int hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        //debug
        System.out.println("Checking compatibility for patient: " + patient.getName());
        System.out.println("Blood Type Score: " + bloodTypeScore);
        System.out.println("Weight Score: " + weightScore);
        System.out.println("HLA Score: " + hlaScore);

        return bloodTypeScore > 0 && weightScore > 0 && hlaScore > 0;


    }



    //Week 7 (Don't Remove)
    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        if (donorType.equals(recipientType)) {
            return 1; // Perfect match
        }
        // Universal donor
        else if (donorType.equals("O")) {
            return 1; // O type can donate to any type
        }
        // AB can receive from any type
        else if (recipientType.equals("AB")) {
            return 1; // AB can receive from any type
        }
        return 0; // Not compatible
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        int weightDifference = Math.abs(organWeight - patientWeight);

        // Determine score based on how close the weights are
        if (weightDifference == 0) {
            return 3; // Perfect match
        } else if (weightDifference <= patientWeight * 0.1) {
            return 2; // Close match (within 10%)
        } else if (weightDifference <= patientWeight * 0.2) {
            return 1; // Moderate match (within 20%)
        } else {
            return 0; // Poor match (greater than 20%)
        }
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        // Split the HLA types into arrays for easier comparison
        String[] organMarkers = organHla.split(",");
        String[] patientMarkers = patientHla.split(",");

        int matchCount = 0;

        // Compare each organ marker with patient markers
        for (String organMarker : organMarkers) { //readout all organs
            for (String patientMarker : patientMarkers) { //readout all patients
                if (organMarker.trim().equals(patientMarker.trim())) { //if the organ matches the patient then..
                    matchCount++;
                    break; //..Stop after the first match to avoid duplicate counting
                }
            }
        }

        // Assign a score based on the number of matches
        if (matchCount == organMarkers.length) {
            return 3; // Perfect match
        } else if (matchCount > 0) {
            return 2; // Partial match
        } else {
            return 0; // No match
        }
    }
}

