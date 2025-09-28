package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {

    @Test
    void testSelect() {
        int[] array = {12, 3, 5, 7, 19, 18};
        int k = 3;
        int result = Select.select(array, k);
        // The 3rd smallest element in the array is 7
        assertEquals(7, result);
    }

    @Test
    void testSelectWithEmptyArray() {
        int[] array = {};
        int k = 1;
        // Selecting from an empty array should throw an exception
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Select.select(array, k));
    }

    @Test
    void testSelectWithSingleElement() {
        int[] array = {5};
        int k = 1; // The only element in the array is 5
        int result = Select.select(array, k);
        // The 1st smallest element is 5
        assertEquals(5, result);
    }

    @Test
    void testSelectWithLargeArray() {
        int[] array = {12, 3, 5, 7, 19, 18, 1, 8, 11, 4};
        int k = 5; // The 5th smallest element
        int result = Select.select(array, k);
        // After sorting the array, the 5th smallest element is 8
        assertEquals(8, result);
    }

    @Test
    void testSelectWithDuplicates() {
        int[] array = {3, 1, 2, 1, 4, 5, 1};
        int k = 2; // Find the 2nd smallest element
        int result = Select.select(array, k);
        // The 2nd smallest element is 1 (as there are duplicates of 1)
        assertEquals(1, result);
    }

    @Test
    void testSelectWithNegativeNumbers() {
        int[] array = {-1, -3, -2, -4, 0};
        int k = 3; // Find the 3rd smallest element
        int result = Select.select(array, k);
        // After sorting the array, the 3rd smallest element is -2
        assertEquals(-2, result);
    }

    @Test
    void testSelectWithKGreaterThanArrayLength() {
        int[] array = {5, 1, 9};
        int k = 4; // k is out of bounds (array length is 3)
        // Should throw ArrayIndexOutOfBoundsException because the 4th smallest doesn't exist
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Select.select(array, k));
    }
}