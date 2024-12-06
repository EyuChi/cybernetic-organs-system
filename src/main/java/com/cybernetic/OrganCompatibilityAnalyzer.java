package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

    public class OrganCompatibilityAnalyzer {
        private List<Organ> organs;
        private List<Patient> patients;

        public OrganCompatibilityAnalyzer() {
            organs = new ArrayList<>();
            patients = new ArrayList<>();
        }

        public void addOrgan(Organ organ) {
            organs.add(organ);
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public int[][] createCompatibilityMatrix() {
            int[][] matrix = new int[organs.size()][patients.size() * 3];
            for (int i = 0; i < organs.size(); i++) {
                Organ organ = organs.get(i);
                for (int j = 0; j < patients.size(); j++) {
                    Patient patient = patients.get(j);

                    // Calculate compatibility for each factor
                    int bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
                    int weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
                    int hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());

                    // Populate the matrix
                    matrix[i][j * 3] = bloodTypeScore;        // Blood type compatibility
                    matrix[i][j * 3 + 1] = weightScore;      // Weight compatibility
                    matrix[i][j * 3 + 2] = hlaScore;         // HLA compatibility
                }
            }

            return matrix;
        }


        private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
            // Define rules for blood type compatibility
            if (donorType.equals("O-")) return 100; // Universal donor
            if (recipientType.equals("AB+")) return 100; // Universal recipient
            if (donorType.equals(recipientType)) return 100; // Exact match
            return 0; // Incompatible
        }

        private int calculateWeightCompatibility(int organWeight, int patientWeight) {
            // Calculate percentage difference
            double diff = Math.abs(organWeight - patientWeight) / (double) patientWeight;
            if (diff <= 0.1) return 100; // Within 10% difference
            if (diff <= 0.2) return 50; // Within 20% difference
            return 0; // Too large a difference
        }

        private int calculateHlaCompatibility(String organHla, String patientHla) {
            // Split HLA strings into components and count matches
            String[] donorHlas = organHla.split("-");
            String[] recipientHlas = patientHla.split("-");
            int matches = 0;
            for (String hla : donorHlas) {
                for (String recHla : recipientHlas) {
                    if (hla.equals(recHla)) {
                        matches++;
                        break;
                    }
                }
            }
            return matches * 10;
        }

        public double[][] calculateWeightedCompatibility(double[] weights) {
            int[][] compatibilityMatrix = createCompatibilityMatrix();
            double[][] resultMatrix = new double[organs.size()][patients.size()];
            for (int i = 0; i < organs.size(); i++) {
                for (int j = 0; j < patients.size(); j++) {
                    int bloodIndex = j * 3;      // Start index for blood compatibility
                    int weightIndex = bloodIndex + 1; // Next column for weight
                    int hlaIndex = bloodIndex + 2;    // Next column for HLA

                    // Weighted score for this organ-patient pair
                    double weightedScore =
                            (compatibilityMatrix[i][bloodIndex] * weights[0]) +
                                    (compatibilityMatrix[i][weightIndex] * weights[1]) +
                                    (compatibilityMatrix[i][hlaIndex] * weights[2]);

                    resultMatrix[i][j] = weightedScore;
                }
            }

            return resultMatrix;
        }


        public void displayMatrix(int[][] matrix) {
            System.out.println("Initial Compatibility Matrix:");
            System.out.print("        ");
            for (int j = 0; j < patients.size(); j++) {
                System.out.printf("%-10s%-10s%-10s", patients.get(j).getId() + "-Blood",
                        patients.get(j).getId() + "-Weight",
                        patients.get(j).getId() + "-HLA");
            }
            System.out.println();

            // Print matrix rows
            for (int i = 0; i < matrix.length; i++) {
                System.out.printf("%-8s", organs.get(i).getName()); // Print organ name
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.printf("%-10d", matrix[i][j]); // Print each compatibility score
                }
                System.out.println();
            }
        }

        public void displayWeightMatrix(double[] weights) {
            System.out.println("\nWeight Matrix:");
            for (double weight : weights) {
                System.out.printf("%.2f  ", weight);
            }
            System.out.println();
        }

        public void displayWeightedMatrix(double[][] matrix) {
            System.out.println("\nFinal Weighted Compatibility Matrix:");
            System.out.print("     ");
            //TODO: complete the displayWeightedMatrix method to display the final weighted compatibility matrix
        }

    }

