package com.cybernetic;

import java.util.Comparator;
import java.util.Random;

public class HeapDemo {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        //start the heap with the integer comparator
        Heap<Integer> heap = new Heap<>(integerComparator);

        Random rand = new Random();

        //add 20 random integers to the heap
        System.out.println("Adding numbers to the heap:");
        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt(100);//Roll 20 d100's
            heap.add(num);
            System.out.print(num + " ");
        }

        System.out.println("\n\nRemoving numbers from the heap (should be in ascending order):");
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }
}

