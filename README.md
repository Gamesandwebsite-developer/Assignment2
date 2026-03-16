# Assignment 2 CPU Scheduling Algorithms Simulation

## Overview
This project implements and compares three CPU scheduling algorithms:

- First Come First Serve (FCFS) – Non-preemptive
- Shortest Job First (SJF) – Non-preemptive
- Shortest Remaining Time First (SRTF) – Preemptive

The program calculates scheduling metrics such as:

- Completion Time (CT)
- Waiting Time (WT)
- Turnaround Time (TAT)
- Average Waiting Time
- Average Turnaround Time

The goal of the project is to analyze how different scheduling strategies affect CPU scheduling performance.

---

## Requirements

- Java JDK 17 or newer
- Any Java IDE (IntelliJ, Eclipse, VS Code) or command line

---

## Project Structure

src/  
 ├── Main.java  
 ├── Process.java  
 ├── FCFS.java  
 ├── SJF.java  
 └── SRTF.java  

File descriptions:

- Process.java – Represents a process with ID, arrival time, and burst time.
- FCFS.java – Implementation of the First Come First Serve scheduling algorithm.
- SJF.java – Implementation of the Shortest Job First scheduling algorithm.
- SRTF.java – Implementation of the Shortest Remaining Time First scheduling algorithm.
- Main.java – Runs the test cases and prints the results.

---

## How to Run the Program

### Option 1 – Using an IDE

1. Open the project in your Java IDE.
2. Locate `Main.java`.
3. Run the `Main` class.

The program will automatically execute the predefined test cases and print the results for all three scheduling algorithms.

---

### Option 2 – Using the Command Line

Navigate to the project folder and run the following commands.

Compile the program:

javac src/*.java

Run the program:

java -cp src Main

---

## Test Cases

The program runs three predefined scenarios:

1. All processes arrive at time 0  
   Demonstrates behavior based purely on burst time.

2. One long process followed by short processes  
   Shows the benefit of preemptive scheduling.

3. Continuous arrival of short processes  
   Demonstrates potential starvation problems.

Each case is executed using:
- FCFS
- SJF
- SRTF

The results from the algorithms can then be compared.

---

## Output

For each scheduling algorithm the program prints:

- Completion Time (CT)
- Waiting Time (WT)
- Turnaround Time (TAT)
- Average Waiting Time
- Average Turnaround Time
