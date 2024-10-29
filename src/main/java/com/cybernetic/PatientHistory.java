package com.cybernetic;

import java.util.Stack;

public class PatientHistory {

/*Stacks follow LIFO, like a stack of plates, last in first out, it's easier to grab
the top plate, then wrestle the stack to get the bottom plate.
.push is to add to the stack
.pop is remove from the stack
.peek is unique to both stacks and queues, however
using .peek with a stack allows you to look at the top element.
 */
    private Stack<String> medicalHistory;

    /*[Requirement 1.1]*/
    public PatientHistory() {
        medicalHistory = new Stack<String>();
    }

    /**[Requirement 2.1]
     * Add a new medical event to the patient's history.
     * @param event The medical event to be added.
     */
    public void addMedicalEvent(String event) {
        medicalHistory.push(event);
    }

    /**[Requirement 2.2]
     * View the most recent medical event without removing it.
     * @return The most recent medical event.
     */
    public String viewLatestEvent() {
        if (!medicalHistory.isEmpty()) {
            return medicalHistory.peek();  // View the top event
        } else {
            return "No medical events recorded.";
        }
    }

        /**[Requirement 2.3]
         * Remove and return the most recent medical event from the stack.
         * @return The most recent medical event.
         */
        public String removeMostRecentEvent() {
         if (!medicalHistory.isEmpty()) {
        return medicalHistory.pop();  // Remove and return the top event

        } else {
                return "No medical events to remove.";
            }
        }

        /**[Requirement 2.4]
         * Check if the patient's medical history is empty.
         * @return True if the medical history is empty, false otherwise.
         */
        public boolean isEmpty() {
            return medicalHistory.isEmpty();
        }
}