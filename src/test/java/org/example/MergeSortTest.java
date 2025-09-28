package org.example;

import org.example.algorithms.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testMergeSort() {
        int[] array = {12, 3, 5, 7, 19, 18};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{3, 5, 7, 12, 18, 19}, array);
    }

    @Test
    void testMergeSortWithEmptyArray() {
        int[] array = {};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testMergeSortWithSingleElement() {
        int[] array = {5};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{5}, array);
    }

    @Test
    void testMergeSortWithNegativeNumbers() {
        int[] array = {-1, -3, -2, -4, 0};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{-4, -3, -2, -1, 0}, array);
    }

    @Test
    void testMergeSortWithLargeArray() {
        int[] array = {1, 3, 2, 5, 4, 6, 8, 7, 10, 9};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    void testMergeSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testMergeSortWithDuplicates() {
        int[] array = {1, 2, 2, 3, 3, 3};
        MergeSort.mergeSort(array);

        assertArrayEquals(new int[]{1, 2, 2, 3, 3, 3}, array);
    }
}