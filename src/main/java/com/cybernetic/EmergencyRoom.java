package com.cybernetic;

import java.time.LocalTime;
import java.util.PriorityQueue;

public class EmergencyRoom {
    private final PriorityQueue<Patient> patientQueue;

    public EmergencyRoom(PatientComparator comparator) {
        patientQueue = new PriorityQueue<>(comparator);
    }

    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalTime.now());
        patientQueue.add(patient);
    }

    public Patient admit() {
        return patientQueue.poll();
    }
}

