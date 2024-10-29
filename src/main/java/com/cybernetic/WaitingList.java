/*package com.cybernetic;

import lombok.Getter;

@Getter
public class WaitingList {
    private waitingListNode head;

    //Do not insert @getter here as this is the constructor not the class/
    public WaitingList() {
        this.head = null;
    }


    //Add a new patient to the waitinglist. (Requirement 2.1)
    public void addPatient(Patient patient, int priority) {
        waitingListNode newNode = new waitingListNode(patient, priority);

        //Condtional To check if the head is empty.
        if (head == null || newNode.getPriority() > head.getPriority()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            //Sets up for the While Loop below
            waitingListNode current = head;
            waitingListNode previous = null;

            //To list the patients by priority, checks priority of both, Eventually moving across the list.
            while (current != null && current.getPriority() >= newNode.getPriority()) {
                previous = current;
                current = current.getNext();
            }

            //Insert the new node between the nodes if they check out.
            previous.setNext(newNode);
            newNode.setNext(current);
        }
    }

    //(Requirment 2.2) Remove the highest priority patient
    public Patient removeHighestPriority() {
        if (head == null) return null;
        Patient highestPriorityPatient = head.getPatient();
        head = head.getNext();
        return highestPriorityPatient;
    }

    //(Requirement 2.3) Update the Priority of an exisiting patient (needs: 2.6)
    void updatePriority(String patientId, int newPriority) {
    Patient patient = findPatientById(patientId);
    if (patient != null) {
        removePatient(patientId);
        addPatient(patient, newPriority);
    }
}

private Patient findPatientById(String patientId) {
    waitingListNode current = head;
    while (current != null) {
        if (current.getPatient().getId().equals(patientId)) {
            return current.getPatient();
        }
        current = current.getNext();
    }
    return null; //If Given patient id doesn't exist
}*/

    /*Straight from the takehome quiz, 'nearly'. Basically traverses across the linked list and prints out all info, then uses .next to traverse
    (Requirement 2.4)*/
/*public void displayWaitingList() {
    waitingListNode current = head;

    while (current != null) {
        System.out.println(current.getPatient());
        current =current.getNext();
    }
}

//(Requirement 2.5) Get Position of patient
    public int getPosition(String patientId) {
    waitingListNode current = head;
    int position = 1;
    while (current != null) {
        if (current.getPatient().getId().equals(patientId)) {
            return position;
        }
        current = current.getNext();
        position++;
        }
    return -1;
    }

//(Requirement 2.6) Remove patients
    public void removePatient(String patientId) {
    if (head == null) return; // Handle empty list

    // If the head needs to be removed
    if (head.getPatient().getId().equals(patientId)) {
        head = head.getNext();
        return;
    }

    // Traverse the list to find the patient
    waitingListNode current = head;
    while (current.getNext() != null) {
        if (current.getNext().getPatient().getId().equals(patientId)) {
            current.setNext(current.getNext().getNext()); // Remove the patient
            return;
        }
        current = current.getNext();
    }
}

}*/
