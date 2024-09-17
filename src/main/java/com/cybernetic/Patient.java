package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class Patient
{

    //Attributes of Patient
    private String name;
    private int age;
    private String  medicalHistory;
    private CyberneticOrgan[] installedOrgans;
    private int organCount = 0; //Track the # of Organs installed

    //Constructor
    public Patient(String name, int age, String medicalHistory)

    {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        //This line determines capacity of CyberneticOrganList
        this.installedOrgans = new CyberneticOrgan[5];
    }

    //Method to add new Organs
    public void addOrgan(CyberneticOrgan organ)
    {
        //If else to check if capacity is reached
       if (organCount >= installedOrgans.length)
       {
           System.out.println("Too many orgsans installed! Cannot add more!");
       } else {
           installedOrgans[organCount] = organ;
           organCount++;
           System.out.println("Organ installed successfully: " + organ);
       }
    }

    //Return String
    public String getPatientInfo()
    {
        return "Name: " + name + "\nAge: " + age + "\nMedical History: " + medicalHistory;
    }


    public void getOrganList()
    {
        if (organCount == 0)
        {
            System.out.println("No installed organs!");
        } else {
        System.out.println("Installed Organs: ");
        //Enchanced For Loop
        for (CyberneticOrgan organ : installedOrgans)
        {
            System.out.println(organ);
        }
              }
    }
}
