package com.cybernetic;

import lombok.Getter;


//Note to myself, use @getter at the top of the class you want the methods for
//(Requirement 1)
@Getter
public class waitingListNode {

    //So inserting @getter here would only make get methods for the patient and nothing else (Good time spent)
    private Patient patient;
    private int priority;
    private waitingListNode next;


   public waitingListNode(Patient patient, int priority){
        this.patient = patient;
        this.priority = priority;
        this.next = null;

    }

    public void setNext(waitingListNode next) {
       this.next = next;
    }
}
