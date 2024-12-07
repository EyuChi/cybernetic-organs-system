package com.cybernetic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Patient {
    private final String name;
    private final LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    public Patient(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }
//Lombok didn't work so well with enumeration
    public LocalDate getDob() {
        return dob;
    }

    public Severity getSeverity() {
        return severity;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    //setters
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + "\nDOB=" + dob + "\nseverity=" + severity + "\narrivalTime=" + arrivalTime;
    }
}
