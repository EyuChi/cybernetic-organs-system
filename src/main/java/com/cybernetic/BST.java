package com.cybernetic;


//BST stands for BinarySearchTree, Not writing that out each time.
public class BST <T extends Comparable<T>> {// Node class representing each node in the tree
    private Node<T> root;

    private static class Node<T> {
        T value;
        Node<T> left, right;

        public Node(T value) {
            this.value = value;
        }
    }

    //Insert method to insert a new node into the BST
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        int comparison = value.compareTo(root.value);
        if (comparison < 0) {
            root.left = insertRec(root.left, value); // Insert in left subtree
        } else if (comparison > 0) {
            root.right = insertRec(root.right, value); // Insert in right subtree
        }
        return root;
    }

    private Node<T> searchRec(Node<T> root, T value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    private EmergencyCase searchById(String caseId) {
        return  searchByIdRec(root, caseId)
    }
    private EmergencyCase searchByIdRec(Node<T> root, String caseId) {
        if (root == null) {
            return null;
        }
        EmergencyCase current = (EmergencyCase) root.value;
        if (current.getCaseId().equals(caseId)) {
            return current;
        }

        // Search in left or right subtree based on caseId comparison
        int comparison = caseId.compareTo(current.getCaseId());
        if (comparison < 0) {
            return searchByIdRec(root.left, caseId);
        } else {
            return searchByIdRec(root.right, caseId);
        }
    }
}

