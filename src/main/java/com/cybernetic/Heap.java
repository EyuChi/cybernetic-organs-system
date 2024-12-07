package com.cybernetic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
    private List<T> heap;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T item) {
        heap.add(item);  //add the patient to the heap
        siftUp(heap.size() - 1);

    }

    public T poll() {
        if (heap.isEmpty()) {
            return null;  //Return null if the heap is empty
        }

        T topElement = heap.get(0);  //top element
        T lastElement = heap.remove(heap.size() - 1);  //remove the last element

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);  //place the last element at the top
            siftDown(0);
        }
        return topElement;  //return the root
    }

    private void siftUp(int index) {
        //move the element at index up to its proper position in the heap
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap.get(index), heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        int leftChildIndex, rightChildIndex, largestChildIndex;
        int size = heap.size();

        while (index < size) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
            largestChildIndex = index;

            //compare with left child
            if (leftChildIndex < size && comparator.compare(heap.get(leftChildIndex), heap.get(largestChildIndex)) > 0) {
                largestChildIndex = leftChildIndex;
            }

            //compare with right child
            if (rightChildIndex < size && comparator.compare(heap.get(rightChildIndex), heap.get(largestChildIndex)) > 0) {
                largestChildIndex = rightChildIndex;
            }

            if (largestChildIndex == index) {
                break;  //if the largest child is the current element, stop
            }

            //swap the current element with the largest child
            swap(index, largestChildIndex);
            index = largestChildIndex;  //move down the heap
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public T peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }
}

