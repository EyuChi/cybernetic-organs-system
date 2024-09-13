package com.cybernetic;

public class CyberneticOrgan
{

    //Attributes
    private String id;
    private String model;
    private String functionality;
    private String compatibility;

    //Constructor
    public CyberneticOrgan(String id, String model, String functionality, String compatibility)
    {
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        this.compatibility = compatibility;
    }

    //Method to return String
    public String getDetails()
    {
        return "ID: " + id + "\nModel: " + model + "\nFunctionality: " + functionality + "\nCompatibility: " + compatibility;
    }

    //getter methods just in case
    public String getFunctionality()
    {
        return this.functionality;
    }

    public String getModel()
    {
        return this.model;
    }
    public String getId()
    {
        return this.id;
    }
    public String getCompatibility()
    {
        return this.compatibility;
    }

    //Method to check organ compatibility
    public boolean isCompatible(String patientCompatibility)
    {
        return this.compatibility.equals(patientCompatibility);
    }

    //StringTo
    @Override
    public String toString()
    {
        return "CyberneticOrgan{" +
                "\nid='" + id + '\'' +
                ", model='" + model + '\'' +
                ", functionality='" + functionality + '\'' +
                ", compatibility='" + compatibility + '\'' +
                '}';
    }

}//end of CyberneticOrgan Class
