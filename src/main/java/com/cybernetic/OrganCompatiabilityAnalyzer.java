package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganCompatiabilityAnalyzer {
    private List<Organ> organs; //New Organ & Patient List
    private List<Patient> patients;

    public OrganCompatiabilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


    public List<Organ> getCompatibleOrgans(Patient patient) {
        return organs.stream()//Reorganize the organ list by first
                .filter(organ -> isCompatible(organ, patient))  // Filtering out uncompatible organs
                .collect(Collectors.toList()); //Return all compatible organs to a readable list
    }


    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream() //reorganize the patient list
                .collect(Collectors.toMap( //Return all stream results to Map.
                        patient -> patient,  //The Key is the Patient,
                         patient -> organs.stream()
                                .map(organ -> calculateCompatibilityScore(organ, patient)) //The organs are compared to our patient values
                                .collect(Collectors.toList())
                ));
    }

    double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }


    private int calculateBloodTypeCompatibility(String donorType, String recipientType)
    {
        if (donorType.equals(recipientType))
        {
            return 1; // Perfect match
        }
        // Universal donor
        else if (donorType.equals("O"))
        {
            return 1; // O type can donate to any type
        }
        // AB can receive from any type
        else if (recipientType.equals("AB"))
        {
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
            return (int) 0; // Poor match (greater than 20%)
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

    private boolean isCompatible(Organ organ, Patient patient) {
        int bloodScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        int weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        int hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());

        return bloodScore > 0 && weightScore > 0 && hlaScore > 0;
    }
}

