import java.util.ArrayList;

public class Main {

    public static ArrayList<Process> copyProcesses(ArrayList<Process> original) {
        ArrayList<Process> copy = new ArrayList<>();
        for (Process p : original) {
            copy.add(new Process(p));
        }
        return copy;
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        processes.add(new Process("P1", 0, 8));
        processes.add(new Process("P2", 0, 4));
        processes.add(new Process("P3", 0, 2));
        processes.add(new Process("P4", 0, 6));
        processes.add(new Process("P5", 0, 3));

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
}
