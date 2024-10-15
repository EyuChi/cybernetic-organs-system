package com.cybernetic;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        Set<String> bloodTypes = new HashSet<>();
        organs.forEach(organ -> bloodTypes.add(organ.getBloodType()));
        patients.forEach(patient -> bloodTypes.add(patient.getBloodType()));
        return bloodTypes;
    }

    public Map<String, List<Patient>> groupPatientsByBloodType(List<Patient> patients) {
        return patients.stream()
                .collect(Collectors.groupingBy(Patient::getBloodType));
    }

    public List<Organ> sortOrgansByWeight(List<Organ> organs) {
        return organs.stream()
                .sorted(Comparator.comparingInt(Organ::getWeight))
                .collect(Collectors.toList());
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, List<Organ> organs, int n) {
        return organs.stream()
                .filter(organ -> isCompatible(organ, patient))
                .sorted((o1, o2) -> Double.compare(
                        calculateCompatibilityScore(o2, patient),
                        calculateCompatibilityScore(o1, patient)))
                .limit(n)
                .collect(Collectors.toList());
    }

    private boolean isCompatible(Organ organ, Patient patient) {
        return calculateCompatibilityScore(organ, patient) > 0;
    }

    // Helper Method: Calculate Compatibility Score
    private double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodScore = organ.getBloodType().equals(patient.getBloodType()) ? 1 : 0;
        double weightScore = (1.0 - Math.abs(organ.getWeight() - patient.getWeight()) / 100.0);
        double hlaScore = (organ.getHlaType().equals(patient.getHlaType())) ? 1 : 0;
        return (bloodScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }
}




