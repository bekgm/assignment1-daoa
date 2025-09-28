package org.example.algorithms;

import java.util.Arrays;

public class ClosestPair {
    public static void closestPair(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
        }
    }
}