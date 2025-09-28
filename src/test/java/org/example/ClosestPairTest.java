package org.example;

import org.example.algorithms.ClosestPair;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void testClosestPair() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int[][] points = {{0, 0}, {3, 3}, {2, 2}, {1, 1}};
        ClosestPair.closestPair(points);

        String expected = "[0, 0]\n[1, 1]\n[2, 2]\n[3, 3]\n";

        assertEquals(expected, output.toString());
    }

    @Test
    void testClosestPairWithSinglePoint() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int[][] points = {{1, 1}};
        ClosestPair.closestPair(points);

        String expected = "[1, 1]\n";

        assertEquals(expected, output.toString());
    }

    @Test
    void testClosestPairWithMultipleIdenticalPoints() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int[][] points = {{1, 1}, {1, 1}, {1, 1}};
        ClosestPair.closestPair(points);

        String expected = "[1, 1]\n[1, 1]\n[1, 1]\n";

        assertEquals(expected, output.toString());
    }

    @Test
    void testClosestPairWithNegativeCoordinates() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int[][] points = {{-1, -1}, {3, 3}, {2, 2}, {-2, -2}};
        ClosestPair.closestPair(points);

        String expected = "[-2, -2]\n[-1, -1]\n[2, 2]\n[3, 3]\n";

        assertEquals(expected, output.toString());
    }
}