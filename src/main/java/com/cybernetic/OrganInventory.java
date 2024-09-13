package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class OrganInventory
{
    private final ArrayList<CyberneticOrgan> inventory;

    //Constructor for New Organ list
    public OrganInventory()
    {
        this.inventory = new ArrayList<CyberneticOrgan>();
    }

    // Method to get the list of all organs in the inventory
    public ArrayList<CyberneticOrgan> getOrganList() {
        return new ArrayList<>(inventory);
    }

    //Method to add New organs
    public void addOrgan(CyberneticOrgan organ)
    {
        inventory.add(organ);
        System.out.println("Organ added successfully: " + organ);
    }

    //method to remove an Organ by mnodel
    public String removeOrgan(String model)
    {
        boolean removed = inventory.removeIf(organ -> organ.getModel().equals(model));
        if (removed) {
            return "Organ with model " + model + " removed successfully.";
        } else {
            return "Organ with model " + model + " not found.";
        }
    }

    //Method to search for organs via functionality
    public ArrayList<CyberneticOrgan> searchOrgan(String functionality)
    {
        ArrayList<CyberneticOrgan> resultList = new ArrayList<>();

        for (CyberneticOrgan organ : inventory) {
            if (organ.getFunctionality().equalsIgnoreCase(functionality))
            {
                resultList.add(organ);
            }
        }
        return resultList;
    }

    //method to sort OrganInventory
    public void sortOrgan()
    {
        Collections.sort(inventory, (a, b) -> a.getModel().compareTo(b.getModel()));
    }

    //Method to get Organ, returning organ details, else return n/a
    public String getOrgan(String model)
    {
        //Enchanced for Loop
        for(CyberneticOrgan organ : inventory)
        {
            if (organ.getDetails().contains(model))
            {
                System.out.println("getOrgan: ");
                return organ.getDetails();
            }
        }
        return "Organ not found";
    }
}//End of OrganInventory
