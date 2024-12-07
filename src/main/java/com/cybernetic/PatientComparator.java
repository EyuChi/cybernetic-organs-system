package com.cybernetic;

import java.util.Comparator;


public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient p1, Patient p2) {
        //compare severity
        int severityCompare = p2.getSeverity().compareTo(p1.getSeverity());
        if (severityCompare != 0) {
            return severityCompare;
        }

        //compare age (older patient first)
        int ageCompare = p1.getDob().compareTo(p2.getDob());
        if (ageCompare != 0) {
            return ageCompare;
        }

        //compare arrival time (earlier arrival first)
        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}
