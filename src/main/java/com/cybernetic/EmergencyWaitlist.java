package com.cybernetic;

import java.util.PriorityQueue;

public class EmergencyWaitlist {
    private PriorityQueue<EmergencyCase> priorityQueue;
    private BST<EmergencyCase> bst;


    // Constructor
    public EmergencyWaitlist() {
        // Initialize the priority queue with a comparator based on the EmergencyCase's compareTo method
        this.priorityQueue = new PriorityQueue<>();
        this.bst = new BST<>(); // Assuming you have a BST implementation
    }

    //Requirement 3.1 Add the emergency case to the adjusting queue
    public void addEmergencyCase(EmergencyCase emergencyCase) {
        priorityQueue.add(emergencyCase);
        bst.insert(emergencyCase); // Insert into the BST as well for searching
    }

    //Requirement 3.2 to get the next urgent case (highest priority)
    public EmergencyCase getNextUrgentCase() {
        return priorityQueue.poll(); // Removes and returns the highest priority emergency case
    }

    //Requirement 3.3 update the severity level of a specific case by its caseId
    public void updateCaseSeverity(String caseId, int newLevel) {
        //Find the emergency case in the BST
        EmergencyCase caseToUpdate = findCaseById(caseId);
        if (caseToUpdate == null) {
            System.out.println("Emergency case with ID " + caseId + " not found.");
            return;
        }

        //Update the severity level of the case
        caseToUpdate.updateSeverity(newLevel);

        //Remove the old case from both PriorityQueue and BST
        priorityQueue.remove(caseToUpdate);
        bst.remove(caseToUpdate);  // Implement remove method in BST

        //Reinsert the updated case back into both structures
        priorityQueue.add(caseToUpdate);
        bst.insert(caseToUpdate);
        System.out.println("Emergency case " + caseId + " severity updated to " + newLevel);
    }

    //Requirement 3.4
    private EmergencyCase findCaseById(String caseId) {
        return bst.searchById(caseId);
    }

}
