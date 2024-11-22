package com.cybernetic;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EmergencyCase implements Comparable<EmergencyCase> {
    private String caseId;
    private Patient patient;
    private int severityLevel;  // Severity: 1-5
    private LocalDateTime registrationTime;

    // Constructor
    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        this.caseId = caseId;
        this.patient = patient;
        this.severityLevel = severityLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        return "EmergencyCase{" +
                "caseId='" + caseId + '\'' +
                ", patient=" + patient +
                ", severityLevel=" + severityLevel +
                ", registrationTime=" + registrationTime +
                '}';
    }

    @Override
    public int compareTo(EmergencyCase other) {
        if (this.severityLevel != other.severityLevel) {
            return Integer.compare(other.severityLevel, this.severityLevel);
        }
        return  this.registrationTime.compareTo(other.registrationTime);
    }

    public void updateSeverity(int newSeverity) {
        this.severityLevel = newSeverity;
    }

}
