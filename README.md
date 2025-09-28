# Assignment 1: Divide and Conquer Algorithms

## Learning Goals

This project implements and analyzes classic divide-and-conquer algorithms using safe recursion patterns, theoretical recurrence analysis, and empirical performance metrics. The work is structured around clean Git workflows and documented in this report.

---

## Project Structure

---

## Implemented Algorithms

### MergeSort — Θ(n log n), Master Theorem Case 2

- Recursively splits array and merges using reusable buffer
- Small-array cutoff can be added for cache efficiency
- Recurrence: T(n) = 2T(n/2) + Θ(n) → Θ(n log n)

### QuickSort — Θ(n log n) average, Θ(n²) worst

- Randomized pivot selection
- Recurses into smaller partition, iterates over larger side to bound stack depth
- Recurrence: T(n) = T(k) + T(n−k−1) + Θ(n) → average Θ(n log n)

### Select (Median-of-Medians) — Θ(n)

- Groups of 5, selects median-of-medians as pivot
- Recurses only into necessary side, preferring the smaller one
- Recurrence: T(n) ≤ T(n/5) + T(7n/10) + Θ(n) → Θ(n) via Akra–Bazzi intuition

### Closest Pair of Points (2D) — Θ(n log n)

- Sorts points by x-coordinate, recursively splits
- Checks strip by y-order using classic 7-point scan
- Recurrence: T(n) = 2T(n/2) + Θ(n) → Θ(n log n)

---

## Metrics and Architecture

### Metrics Collected

- Execution time
- Recursion depth
- Number of comparisons
- CSV output for plotting and analysis (optional)

### Architecture Notes

- Recursion depth tracked via `Metrics.trackDepth(int)`
- Comparisons tracked via `Metrics.trackComparison(int)`
- CLI parses arguments and runs selected algorithm with metric collection

### Plots and Observations

- Time vs input size, depth vs input size (to be added)
- MergeSort benefits from cache locality
- QuickSort stack depth remains bounded due to smaller-first recursion
- Select shows linear behavior consistent with Akra–Bazzi analysis

### Summary

- MergeSort and Closest Pair align closely with theoretical expectations
- QuickSort performs well under randomized pivot, with bounded depth
- Select algorithm demonstrates linear performance and robustness across inputs

---

## GitHub Workflow

### Branches

- `main`: stable releases (`v0.1`, `v1.0`)
- Feature branches:  
  `feature/mergesort`, `feature/quicksort`, `feature/select`, `feature/closest`, `feature/metrics`

### Commit Storyline

- `init: maven, junit5, readme`
- `feat(metrics): counters, depth tracker, CSV writer`
- `feat(mergesort): baseline + reuse buffer + cutoff + tests`
- `feat(quicksort): smaller-first recursion, randomized pivot + tests`
- `feat(select): deterministic select (MoM5) + tests`
- `feat(closest): divide-and-conquer implementation + tests`
- `feat(cli): parse args, run algos, emit CSV`
- `docs(report): master cases & AB intuition, initial plots`
- `fix: edge cases (duplicates, tiny arrays)`
- `release: v1.0`

---

## Testing

All algorithms are tested using JUnit5:

### MergeSort and QuickSort

- Tested on random, sorted, reversed, and duplicate arrays
- Edge cases: empty arrays, single-element arrays, negative numbers
- QuickSort depth verified to stay within ~2·log₂n

### Select

- Compared against expected values across multiple trials
- Handles duplicates, negatives, empty arrays, and out-of-bounds `k`
- Exception handling verified via `assertThrows`

### Closest Pair

- Output validated against sorted x-coordinates
- Edge cases: single point, identical points, negative coordinates

---

## How to Run the Project

### Requirements

- Java 17 or higher
- Maven 3.8 or higher
- Git (for cloning the repository)

### Run Tests

```bash
mvn test
mvn clean package
java -cp target/classes org.example.Main

