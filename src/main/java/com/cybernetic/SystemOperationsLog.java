package com.cybernetic;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SystemOperationsLog {
    private ArrayList<SystemOperation> stack;
    private int capacity;

    // Constructor
    public SystemOperationsLog(int capacity) {
        this.stack = new ArrayList<>(); // Initialize the ArrayList
        this.capacity = capacity; // Set the stack's capacity
    }

    //Requirement 2.1 Push Operations onto Stack
    public void pushOperation(SystemOperation operation) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push operation.");
            return;
        }
        stack.add(operation);
        System.out.println("Operation pushed: " + operation.getOperationId());
    }

    //REquirement 2.2 Pop Operations from Stack
    public SystemOperation popLastOperation() {
        if (isEmpty()) {
            System.out.println("Stack is nonexistent. Cannot pop operation.");
            return null;
        }
        SystemOperation operation = stack.remove(stack.size() - 1);
        System.out.println("Operation popped: " + operation.getOperationId());
        return operation;
    }

    //Requirement 2.3 Peek Last Operation form Stack
    public SystemOperation peekLastOperation() {
        if (isEmpty()) {
            System.out.println("Stack is nonexistent. Cannot peak stack");
            return null;
        }
        SystemOperation operation = stack.get(stack.size() - 1);
        System.out.println("Last Operation peeked:  " + operation.getOperationId());
        return operation;
    }

    /*Requirement 2.4 See if the Operation is able to undo? Then push it back on stack?
    Where is this method even called?*/
    public void undoLastOperation() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to undo.");
            return;
        }
        SystemOperation lastOperation = peekLastOperation();
        if (!lastOperation.isReversible()) {
            System.out.println("Operation " + lastOperation.getOperationId() + " is not reversible.");
            return;
        }
        lastOperation.reverse();
        popLastOperation();
        System.out.println("Operation " + lastOperation.getOperationId() + " has been undone.");
    }

    public List<SystemOperation> getRecentOperations(int count) {
        // Check if the stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty. No operations to retrieve.");
            return new ArrayList<>();
        }

        // Calculate how many operations to return (min between stack size and count)
        int recentCount = Math.min(count, stack.size());

        // Get the last 'recentCount' operations from the stack
        List<SystemOperation> recentOperations = stack.subList(stack.size() - recentCount, stack.size());

        // Optionally print the retrieved recent operations
        System.out.println("Recent Operations:");
        for (SystemOperation op : recentOperations) {
            System.out.println(op.getOperationId() + " - " + op.getDescription());
        }

        return recentOperations;  // Return the list of recent operations
    }


    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Check if the stack is full
    public boolean isFull() {
        return stack.size() == capacity;
    }
}

