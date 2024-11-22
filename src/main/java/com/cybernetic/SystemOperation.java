package com.cybernetic;

import lombok.Getter;

@Getter
public class SystemOperation {
    private String operationId;
    private String operationType;
    private String description;
    private boolean isReversible;

    // Constructor
    public SystemOperation(String operationId, String operationType, String description, boolean isReversible) {
        this.operationId = operationId;
        this.operationType = operationType;
        this.description = description;
        this.isReversible = isReversible;
    }

    public boolean isReversible() {
        return isReversible;
    }

    @Override
    public String toString() {
        return "SystemOperation{" +
                "operationId='" + operationId + '\'' +
                ", operationType='" + operationType + '\'' +
                ", description='" + description + '\'' +
                ", isReversible=" + isReversible +
                '}';
    }

    // Logic to reverse the operation
    public void reverse() {
        System.out.println("Reversing operation: " + operationId);
    }
}