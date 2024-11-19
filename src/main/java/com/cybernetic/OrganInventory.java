package com.cybernetic;

import lombok.Getter;

import java.time.LocalDate;
import  java.util.ArrayList;


@Getter
public class OrganInventory {
    private ArrayList<CyberneticOrgan> organs; // To store CyberneticOrgan objects
    private int maxCapacity;


    public OrganInventory() {
        this.organs = new ArrayList<>();
        this.maxCapacity = 1000;
    }
//Requirement 1A add Organs
    public boolean addOrgan(CyberneticOrgan organ) {
        // Check if the organ ID is unique
        for (CyberneticOrgan existingOrgan : this.organs) {
            if (existingOrgan.getId().equals(organ.getId())) {
                throw new IllegalArgumentException("Duplicate organ ID: " + organ.getId());
            }
        }

        /*Validate the manufactureDate (cannot be a future date)
        I think the expected output shouldn't validate organ 6, I see in the CSV file you put "# Invalid: Future date"
        But in the pdf, it does validate 6, since it doesn't mention its error. Its a Good catch, before I turn this in :D
         */
        if (organ.getManufactureDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Manufacture date cannot be in the future: " + organ.getManufactureDate());
        }
        if (organ.getCompatibilityScore() < 0 || organ.getCompatibilityScore() > 1) {
            throw new IllegalArgumentException("Compatibiility Score must be 0 and 1. Current: " + organ.getCompatibilityScore());
        }

        /* Validate the power level (must be between 1 and 100)
        Same here, the expected output lets organ 7 pass but the power must be within 1 to 100,
        so it should've caught organ 7 with a powerlevel of 120
         */
        if (organ.getPowerLevel() < 1 || organ.getPowerLevel() > 100) {
            throw new IllegalArgumentException("Power level must be between 1 and 100: " + organ.getPowerLevel());
        }

        // Validate organ type (must be one of the specified types)
        if (!organ.getType().equals("HEART") && !organ.getType().equals("LUNG") &&
                !organ.getType().equals("KIDNEY") && !organ.getType().equals("LIVER")) {
            throw new IllegalArgumentException("Invalid organ type: " + organ.getType());
        }

        // Add organ to the list
        this.organs.add(organ);
        return true;
    }
//Requirement 1B Removal
    public boolean removeOrgan(String organId, String removalReason) {
        // Find the organ by ID
        for (CyberneticOrgan organ : this.organs) {
            if (organ.getId().equals(organId)) {
                // Only AVAILABLE organs can be removed
                if (organ.getStatus().equals("AVAILABLE")) {
                    // Log the removal reason (you can log it or store in a separate list)
                    System.out.println("Removing organ: " + organId + " Reason: " + removalReason);
                    this.organs.remove(organ);
                    return true;
                } else {
                    throw new IllegalArgumentException("Only AVAILABLE organs can be removed.");
                }
            }
        }
        throw new IllegalArgumentException("Organ with ID " + organId + " not found.");
    }
//Requirement 1C.1
    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<>(this.organs);
        quickSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    private void quickSort(ArrayList<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<CyberneticOrgan> list, int low, int high) {
        int pivot = list.get(high).getPowerLevel(); //Luck based, Roll High, get a balanced list hopefully
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getPowerLevel() < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(ArrayList<CyberneticOrgan> list, int i, int j) {
        CyberneticOrgan temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    //REquirement 1C2
    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<>(this.organs);
        mergeSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    //Seperate the Smarties into indivdual pieces
    private void mergeSort(ArrayList<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(list, low, mid);
            mergeSort(list, mid + 1, high);
            merge(list, low, mid, high);
        }
    }
    //Bring the smarties back together into sorted order.
    private void merge(ArrayList<CyberneticOrgan> list, int low, int mid, int high) {
        ArrayList<CyberneticOrgan> left = new ArrayList<>(list.subList(low, mid + 1));
        ArrayList<CyberneticOrgan> right = new ArrayList<>(list.subList(mid + 1, high + 1));

        int i = 0, j = 0, k = low;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getManufactureDate().isBefore(right.get(j).getManufactureDate())) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    //Requirement 1C3
    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<>(this.organs);
        bubbleSort(sortedList);
        return sortedList;
    }

    private void bubbleSort(ArrayList<CyberneticOrgan> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getCompatibilityScore() > list.get(j + 1).getCompatibilityScore()) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

}