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

    public EmergencyCase searchById(String caseId) {
        return  searchByIdRec(root, caseId);
    }
    //Requirement 3.4
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


    //To remove nodes, this.
    public void remove(T value) {
        root = removeRec(root, value);
    }

    private Node<T> removeRec(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        //Compare the value to find the node to remove
        int comparison = value.compareTo(root.value);

        if (comparison < 0) {
            //Value is in the left subtree
            root.left = removeRec(root.left, value);
        } else if (comparison > 0) {
            //Value is in the right subtree
            root.right = removeRec(root.right, value);
        } else {
            //Found the node to remove

            //case1: Node is a leaf (no children)
            if (root.left == null && root.right == null) {
                return null;
            }

            //case2: Node has one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case3: Node has two children
            //find smallest value
            T minValue = findMinValue(root.right);
            root.value = minValue; // Replace the node's value with the successor's value
            root.right = removeRec(root.right, minValue); // Remove the successor
        }

        return root;
    }

    //Search for min value
    private T findMinValue(Node<T> root) {
        T minValue = root.value;
        while (root.left != null) {
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }
}

