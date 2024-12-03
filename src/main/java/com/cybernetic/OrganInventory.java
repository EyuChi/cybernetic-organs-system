package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganInventory {
    private final List<Organ> inventory;

    public OrganInventory() {
        inventory = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        inventory.add(organ);
    }

    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
    }
    public List<Organ> getInventory() {
        return inventory;
    }
    //Step 1: ability to sort by multiple properties in order. name, model, compatibility using built-in sort
    public List<Organ> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        // Comparator to compare by name, model, and compatibility
        Comparator<Organ> organComparator = Comparator
                .comparing(Organ::getName)
                .thenComparing(Organ::getModel)
                .thenComparing(Organ::getCompatibility);

        // Sort the inventory using Collections.sort
        Collections.sort(inventory, organComparator);

        return inventory;
    }
    //ability to sort by multiple properties in order. name, model, compatibility using quicksort
    public List<Organ> quickSortOrganByNameModelAndCompatibility(List<Organ> unmodifiableOrganList) {
        quickSort(unmodifiableOrganList, 0, unmodifiableOrganList.size() - 1);
        return unmodifiableOrganList;
    }

    private void quickSort(List<Organ> list, int low, int high) {
        if (low < high) {
            // Find the pivot element such that elements smaller than pivot are on the left, and greater ones are on the right
            int pivotIndex = partition(list, low, high);

            // Recursively sort the two sublists
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(List<Organ> list, int low, int high) {
        Organ pivot = list.get(high); // Pivot is the last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Compare each organ with the pivot (first by name, then by model, then by compatibility)
            if (compareOrgans(list.get(j), pivot) < 0) {
                i++;
                // Swap elements at i and j
                Organ temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // Swap pivot element with the element at i + 1
        Organ temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1; // Return the pivot index
    }

    // Comparison logic: First compare by name, then model, then compatibility
    private int compareOrgans(Organ organ1, Organ organ2) {
        int nameCompare = organ1.getName().compareTo(organ2.getName());
        if (nameCompare != 0) return nameCompare;

        int modelCompare = organ1.getModel().compareTo(organ2.getModel());
        if (modelCompare != 0) return modelCompare;

        return organ1.getCompatibility().compareTo(organ2.getCompatibility());
    }

}

