package com.cybernetic;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {


        public static void main(String[] args) {
            List<Organ> organs = Arrays.asList(
                    new Organ("H1", "Heart", "A+", 300, generateRandomHLAType()),
                    new Organ("K1", "Kidney", "B-", 150, generateRandomHLAType()),
                    new Organ("L1", "Liver", "O+", 1500, generateRandomHLAType())
            );

            List<Patient> patients = Arrays.asList(
                    new Patient("P1", "John Doe", "A+", 70, generateRandomHLAType()),
                    new Patient("P2", "Jane Smith", "B-", 65, generateRandomHLAType()),
                    new Patient("P3", "Bob Johnson", "O+", 80, generateRandomHLAType())
            );

            //intialize the organmgt system with organs and patients
            OrganManagementSystem system = new OrganManagementSystem(organs, patients);
            OrganCompatiabilityAnalyzer analyzer = new OrganCompatiabilityAnalyzer();

            //add oragns and the patients to the compatibility analyzer
            organs.forEach(analyzer::addOrgan);
            patients.forEach(analyzer::addPatient);

            // Output as per assignment requirements & Prints out all available organs
            System.out.println("Available Organs:");
            organs.forEach(o -> System.out.println(o.getId() + ". " + o.getName() + " (" + o.getBloodType() + ", " + o.getWeight() + "g)"));

            //prints all patients
            System.out.println("\nPatients:");
            patients.forEach(p -> System.out.println(p.getId() + ". " + p.getName() + " (" + p.getBloodType() + ", " + p.getWeight() + "kg)"));

            //print out the unique blood types in the systemn
            System.out.println("\nUnique Blood Types: " + system.getUniqueBloodTypes());

            //Group and output by patient's blood type
            System.out.println("\nPatients Grouped by Blood Type:");
            system.groupPatientsByBloodType(system.getPatients()).forEach((bloodType, patientList) ->
                    System.out.println(bloodType + ": " + patientList.stream()
                            .map(Patient::getName)
                            .collect(Collectors.toList()))
            );

            //Sort and output organs by weight
            System.out.println("\nOrgans Sorted by Weight:");
            system.sortOrgansByWeight(system.getOrgans()).forEach(o ->
                    System.out.println(o.getName() + " (" + o.getBloodType() + ", " + o.getWeight() + "g)")
            );

            //calculate and display compatibility scores for each patient
            System.out.println("\nCompatibility Scores:");
            Map<Patient, List<Double>> scores = analyzer.calculateCompatibilityScores();
            scores.forEach((patient, scoreList) -> {
                for (int i = 0; i < organs.size(); i++) {
                    System.out.println(patient.getName() + " - " + organs.get(i).getName() + ": " + String.format("%.2f", scoreList.get(i)));
                }
            });

            //Get and print
            Patient patient = patients.get(0);
            System.out.println("\nTop 3 Compatible Organs for: " + patient.getName());
            List<Organ> topOrgans = system.getTopCompatibleOrgans(patient,organs,3);
            for (int i = 0; i < topOrgans.size(); i++) {
                Organ organ = topOrgans.get(i);
                double score = analyzer.calculateCompatibilityScore(organ, patient);
                System.out.println((i + 1) + ". " + organ.getName() + " (" + organ.getBloodType() + ", " + organ.getWeight() + "g) - Score: " + String.format("%.2f", score));
            }
        }

        private static String generateRandomHLAType() {
            Random random = new Random();
            return random.ints(1, 10)
                    .limit(6)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("-"));
        }
    }
