package com.cybernetic;

import java.util.LinkedList;
import java.util.Queue;


public class PatientWaitingList {
    /*
    A queue follows a ticketed system FIFO, First in, First Out, Like any business,
    first to grab a ticket will be the first to be served.
    .add is to add elements to the queue
    .poll is to remove elements
    .peek for queues, will look at the front of the queue and return it.
     */
    private Queue<Patient> waitingList;

    /*[Requirement 1.1]*/
    public PatientWaitingList() {
        waitingList = new LinkedList<Patient>();
    }

    /**[Requirement 2.1]
     * Add a new patient to the end of the waiting list.
     * @param patient The patient to be added to the waiting list.
     */
    public void addPatient(Patient patient) {
        waitingList.add(patient);
    }

    /**[Requirement 2.2]
     * Remove and return the next patient from the front of the waiting list.
     * @return The next patient in the waiting list.
     */
    public Patient removeNextPatient() {
        if (!waitingList.isEmpty()) {
            return waitingList.poll();
        } else {
            System.out.println("No Patients in Waiting List.");
            return null;
        }
    }

    /**[Requirement 2.3]
     * Check if the patient waiting list is empty.
     * @return True if the waiting list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    /**[Requirement 3.1]
     * Print the current state of the patient waiting list.
     */
    public void printWaitingList() {
        for (Patient patient : waitingList) {
            System.out.println(patient);
        }
    }
}
