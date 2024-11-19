package com.cybernetic;
import java.util.Arrays;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class Patient {
    private String id;
    private String name;
    private String bloodType;
    private int age;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    private static final Set<String> VALID_BLOOD_TYPES = new HashSet<>(Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
    private static final Set<String> VALID_ORGAN_TYPES = new HashSet<>(Arrays.asList("HEART", "LUNG", "KIDNEY", "LIVER"));
    private static final String VALID_STATUS = "WAITING";

    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status)
    {
        this.id = id;
        this.name = name;
        //Stop People from breaking the World Record
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Age must be between 1 and 119: " + age);
        }
        this.age = age;
        //Check for Valid blood types, and not Other programming langauges like C+
        if (!VALID_BLOOD_TYPES.contains(bloodType)) {
            throw new IllegalArgumentException("Invalid blood type: " + bloodType);
        }
        this.bloodType = bloodType;
        if(!VALID_ORGAN_TYPES.contains(organNeeded)){
            throw new IllegalArgumentException("NO BRAINS HERE, ZOMBIE MAN! WE HAVE COCO PEBBLES FOR BRAINS!");
        }
        this.organNeeded = organNeeded;
        if (urgencyLevel <=0 || urgencyLevel >= 10){
            throw new IllegalArgumentException("Urgency Level must be between 1 and 10. Current Urgency: " + urgencyLevel);
        }
        this.urgencyLevel = urgencyLevel;
        this.registrationDate =registrationDate;
        this.status= status;
    }


}

