package com.cybernetic;

import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class TransplantRecord {
    private String operationId;
    private String patientId;
    private String organId;
    private String surgeon;
    private String outcome;

    private TransplantRecord next; // Pointer to the next record

    // Constructor
    public TransplantRecord(String operationId, String patientId, String organId, String surgeon, String outcome) {
        this.operationId = operationId;
        this.patientId = patientId;
        this.organId = organId;
        this.surgeon = surgeon;
        this.outcome = outcome;

        this.next = null; // Initialize the next pointer
    }
}