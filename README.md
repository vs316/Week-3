# Week 3: Data Structures & File I/O

Welcome to Week 3 of our Java journey! This week we’ll implement core data structures, explore fundamental algorithms, and learn how to work with files in Java.

## Table of Contents

1. [Overview](#overview)  
2. [Topics Covered](#topics-covered)  
   - [Day 1: Linked Lists](#day-1-linked-lists)  
   - [Day 2: Stacks, Queues & HashMaps](#day-2-stacks-queues--hashmaps)  
   - [Day 3: Sorting Algorithms](#day-3-sorting-algorithms)  
   - [Day 4: File Handling](#day-4-file-handling)  
   - [Day 5: Linear & Binary Search](#day-5-linear--binary-search)  
   - [Day 6: Algorithm Runtime Analysis](#day-6-algorithm-runtime-analysis)  
3. [Prerequisites](#prerequisites)  
4. [Repository Structure](#repository-structure)  
5. [Getting Started](#getting-started)  

---

## Overview

This week focuses on implementing and using classic data structures (linked lists, stacks, queues, hash maps), understanding key sorting and searching algorithms, measuring their performance, and reading from and writing to files. By the end of Week 3, you'll be comfortable choosing the right data structures and evaluating algorithmic efficiency in your Java programs.

## Topics Covered

### Day 1: Linked Lists
- Singly and doubly linked list implementations  
- Insertion, deletion, traversal, and reversal operations

### Day 2: Stacks, Queues & HashMaps
- Stack & queue basics using `java.util` and custom implementations  
- HashMap internal structure, key/value operations, collision handling

### Day 3: Sorting Algorithms
- Bubble sort, selection sort, insertion sort  
- Merge sort and quick sort fundamentals

### Day 4: File Handling
- Reading from and writing to text files (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)  
- Exception-safe I/O with try‑with‑resources

### Day 5: Linear & Binary Search
- Linear search on arrays and lists  
- Binary search on sorted arrays, and its time complexity

### Day 6: Algorithm Runtime Analysis
- Big O notation, Best/Average/Worst cases  
- Empirical measurement of runtime using `System.nanoTime()`

## Prerequisites

- Java Development Kit (JDK 8 or later)  
- Completed Weeks 1 & 2 (Java syntax, OOP, methods, collections basics)  
- An IDE or code editor (IntelliJ IDEA, Eclipse, or VS Code)

## Repository Structure
```
week-3-data-structures-file-io/
├── Day1(DSA-LinkedLists)/
│ └── L1/
│ └── LinkedListDemo.java
├── Day2(Stacks_Queues_HashMaps)/
│ └── L1/
│ └── StacksQueuesHashMapsDemo.java
├── Day3(SortingAlgorithms)/
│ └── L1/
│ └── SortingAlgorithmsDemo.java
├── Day4(FileHandling)/
│ └── L1/
│ └── FileHandlingDemo.java
├── Day5(LinearAndBinarySearch)/
│ └── L1/
│ └── SearchAlgorithmsDemo.java
└── Day6(AlgorithmRunTimeAnalysis)/
└── L1/
└── RuntimeAnalysisDemo.java
```


## Getting Started

1. **Clone the repo**  
   ```bash
   git clone https://github.com/yourusername/week-3-data-structures-file-io.git
   cd week-3-data-structures-file-io
2. **Compile and run a demo**
  ```
   javac Day1(DSA-LinkedLists)/L1/LinkedListDemo.java
   java -cp Day1(DSA-LinkedLists)/L1 LinkedListDemo
  ```
3. **Explore**: Open each day’s L1 folder, review the code, and try your own variations or improvements.
