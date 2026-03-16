import java.util.ArrayList;

/**
 * Main class used to run the scheduling simulations.
 *
 * This class defines the test cases used in the assignment and
 * executes the three scheduling algorithms: FCFS, SJF and SRTF.
 * The results for each case are printed to the console.
 */

public class Main {

    /** Creates a copy of the process list so that each scheduling algorithm
     * runs on an identical dataset without modifying the original list.
     */
    public static ArrayList<Process> copyProcesses(ArrayList<Process> original) {
        ArrayList<Process> copy = new ArrayList<>();
        for (Process p : original) {
            copy.add(new Process(p));
        }
        return copy;
    }

    /**
     * Case 1: All processes arrive at time 0
     * Used to compare behaviour when arrival time does not affect scheduling
     * @return processes
     */
    public static ArrayList<Process> getCase1() {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 8));
        processes.add(new Process("P2", 0, 4));
        processes.add(new Process("P3", 0, 2));
        processes.add(new Process("P4", 0, 6));
        processes.add(new Process("P5", 0, 3));
        return processes;
    }

    /**
     * Case 2: One long process arrives first followed by shorter processes
     * Used to demonstrate how preemptive scheduling can interrupt long tasks
     * @return processes
     */
    public static ArrayList<Process> getCase2() {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 20));
        processes.add(new Process("P2", 1, 2));
        processes.add(new Process("P3", 2, 2));
        processes.add(new Process("P4", 3, 1));
        processes.add(new Process("P5", 4, 3));
        return processes;
    }

    /**
     * Case 3: Short processes continuously arrive over time
     * Used to highlight potential starvation issues for long processes
     * @return processes
     */
    public static ArrayList<Process> getCase3() {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 20));
        processes.add(new Process("P2", 1, 2));
        processes.add(new Process("P3", 2, 2));
        processes.add(new Process("P4", 3, 2));
        processes.add(new Process("P5", 4, 2));
        processes.add(new Process("P6", 5, 2));
        return processes;
    }

    /**
     * Runs all three scheduling algorithms on the given dataset and prints the results for comparison.
     * @param caseName
     * @param processes
     */
    public static void runCase(String caseName, ArrayList<Process> processes) {
        System.out.println("\n==============================");
        System.out.println(caseName);
        System.out.println("==============================");

        ArrayList<Process> fcfsList = copyProcesses(processes);
        FCFS.schedule(fcfsList);
        FCFS.printResults(fcfsList);

        ArrayList<Process> sjfList = copyProcesses(processes);
        SJF.schedule(sjfList);
        SJF.printResults(sjfList);

        ArrayList<Process> srtfList = copyProcesses(processes);
        SRTF.schedule(srtfList);
        SRTF.printResults(srtfList);
    }

    public static void main(String[] args) {
        runCase("Case 1 - All Processes Arrive at Time 0", getCase1());
        runCase("Case 2 - One Long Process Followed by Short Processes", getCase2());
        runCase("Case 3 - Continuous Arrival of Short Processes", getCase3());
    }
}
