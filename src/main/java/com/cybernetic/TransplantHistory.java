package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {

private TransplantRecord head;

    public TransplantHistory() {
        this.head = null; //The plans for the tower
    }

    //Requirement 1.1 Add the new records to our linkedlist
    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        record.setNext(head);  // Set the new record's next to point to the current head
        head = record;         // Update the head to the new record
    }

    //Requirement 1.2 Find Transplant based on patient ID
    public TransplantRecord findTransplantByPatient(String patientId) {
        TransplantRecord current = head; // Start at the head of the list
        while (current != null) {
            if (current.getPatientId().equals(patientId)) {
                return current; // Found the record with the matching patientId
            }
            current = current.getNext(); // Move to the next record
        }
        return null; // Return null if no matching record is found
    }


    //Requirement 1.3 Get the number of recent transport records based on the count
    public List<TransplantRecord> getRecentTransplants(int count) {
        List<TransplantRecord> recentRecords = new ArrayList<>();
        TransplantRecord current = head;

        //Traverse the list to get the recent 'count' records
        int i = 0;
        while (current != null && i < count) {
            recentRecords.add(current);
            current = current.getNext();
            i++;
        }
        return recentRecords;
    }

    public void printAllTransplantRecords() {
        TransplantRecord current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }


}
