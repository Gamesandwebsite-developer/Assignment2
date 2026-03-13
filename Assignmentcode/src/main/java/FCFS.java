import java.util.ArrayList;
import java.util.Comparator;

public class FCFS {

    public static void schedule(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            currentTime += p.burstTime;
            p.completionTime = currentTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
        }
    }

    public static void printResults(ArrayList<Process> processes) {
        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\nFCFS Scheduling:");
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");

        for (Process p : processes) {
            System.out.println(
                    p.pid + "\t" +
                            p.arrivalTime + "\t" +
                            p.burstTime + "\t" +
                            p.completionTime + "\t" +
                            p.turnaroundTime + "\t" +
                            p.waitingTime
            );

            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("Average Waiting Time: %.2f%n", totalWT / processes.size());
        System.out.printf("Average Turnaround Time: %.2f%n", totalTAT / processes.size());
    }
}
