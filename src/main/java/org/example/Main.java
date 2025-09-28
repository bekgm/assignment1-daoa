package org.example;

import org.example.algorithms.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {12, 3, 5, 7, 19, 18};

        // Test MergeSort
        MergeSort.mergeSort(array);
        System.out.println("Sorted with MergeSort: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test QuickSort
        int[] quickArray = {12, 3, 5, 7, 19, 18};
        QuickSort.quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("Sorted with QuickSort: ");
        for (int i : quickArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test Median-of-Medians Select
        int[] selectArray = {12, 3, 5, 7, 19, 18};
        int k = 3; // Select 3rd smallest element
        System.out.println("3rd smallest element using Select: " + Select.select(selectArray, k));

        // Test Closest Pair
        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
        System.out.println("Closest pair of points: ");
        ClosestPair.closestPair(points);
    }
}