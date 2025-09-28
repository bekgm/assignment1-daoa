package org.example.algorithms;
import java.util.Arrays;

public class Select {

    public static int select(int[] array, int k) {
        if (k < 1 || k > array.length) {
            throw new IllegalArgumentException("k must be between 1 and " + array.length);
        }
        int[] copy = Arrays.copyOf(array, array.length);
        return medianOfMedians(copy, 0, copy.length - 1, k - 1);
    }

    private static int medianOfMedians(int[] array, int low, int high, int k) {
        int n = high - low + 1;

        if (n <= 5) {
            Arrays.sort(array, low, high + 1);
            return array[low + k];
        }

        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int groupStart = low + i * 5;
            int groupEnd = Math.min(groupStart + 4, high);
            Arrays.sort(array, groupStart, groupEnd + 1);
            int medianIndex = groupStart + (groupEnd - groupStart) / 2;
            medians[i] = array[medianIndex];
        }

        int medianOfMedians = select(medians, (numGroups + 1) / 2);

        int partitionIndex = partition(array, low, high, medianOfMedians);

        int rank = partitionIndex - low;

        if (k == rank) {
            return array[partitionIndex];
        } else if (k < rank) {
            return medianOfMedians(array, low, partitionIndex - 1, k);
        } else {
            return medianOfMedians(array, partitionIndex + 1, high, k - rank - 1);
        }
    }

    private static int partition(int[] array, int low, int high, int pivot) {
        for (int i = low; i <= high; i++) {
            if (array[i] == pivot) {
                swap(array, i, high);
                break;
            }
        }

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 3, 5, 7, 19, 18};
        System.out.println("Original array: " + Arrays.toString(array));

        for (int k = 1; k <= array.length; k++) {
            int result = select(array, k);
            System.out.println(k + "-th smallest element: " + result);
        }

        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }
}