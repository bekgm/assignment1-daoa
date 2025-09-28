package org.example;

import org.example.algorithms.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSort() {
        int[] array = {12, 3, 5, 7, 19, 18};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that the array is sorted in ascending order
        assertArrayEquals(new int[]{3, 5, 7, 12, 18, 19}, array);
    }

    @Test
    void testQuickSortWithEmptyArray() {
        int[] array = {};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that an empty array remains empty
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testQuickSortWithSingleElement() {
        int[] array = {5};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that a single-element array remains the same
        assertArrayEquals(new int[]{5}, array);
    }

    @Test
    void testQuickSortWithNegativeNumbers() {
        int[] array = {-1, -3, -2, -4, 0};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that an array with negative numbers is sorted correctly
        assertArrayEquals(new int[]{-4, -3, -2, -1, 0}, array);
    }

    @Test
    void testQuickSortWithLargeArray() {
        int[] array = {1, 3, 2, 5, 4, 6, 8, 7, 10, 9};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that a larger array is sorted correctly
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    void testQuickSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that an already sorted array remains the same
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testQuickSortWithDuplicates() {
        int[] array = {1, 2, 2, 3, 3, 3};
        QuickSort.quickSort(array, 0, array.length - 1);
        // Test that an array with duplicates is sorted correctly
        assertArrayEquals(new int[]{1, 2, 2, 3, 3, 3}, array);
    }
}