package com.cybernetic;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

private TransplantRecord next;
@Getter
@Data
public class TransplantRecord {
    private String operationId;
    private String patientId;
    private String organId;
    private String surgeon;
    private String outcome;
   // Pointer to the next record in the linked list

    // Constructor
    public TransplantRecord(String operationId, String patientId, String organId, String surgeon, String outcome, LocalDate transplantDate) {
        this.operationId = operationId;
        this.patientId = patientId;
        this.organId = organId;
        this.surgeon = surgeon;
        this.outcome = outcome;
       // The next pointer is initially null (end of the list)
    }
}