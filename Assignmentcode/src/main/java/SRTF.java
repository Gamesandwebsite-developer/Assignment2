import java.util.ArrayList;

public class SRTF {

  public static void schedule(ArrayList<Process> processes) {
    int completedCount = 0;
    int currentTime = 0;
    int n = processes.size();

    while (completedCount < n) {
      Process shortest = null;

      for (Process p : processes) {
        if (!p.completed && p.arrivalTime <= currentTime) {
          if (shortest == null || p.remainingTime < shortest.remainingTime) {
            shortest = p;
          } else if (p.remainingTime == shortest.remainingTime) {
            if (p.arrivalTime < shortest.arrivalTime) {
              shortest = p;
            }
          }
        }
      }

      if (shortest == null) {
        currentTime++;
        continue;
      }

      shortest.remainingTime--;
      currentTime++;

      if (shortest.remainingTime == 0) {
        shortest.completionTime = currentTime;
        shortest.turnaroundTime = shortest.completionTime - shortest.arrivalTime;
        shortest.waitingTime = shortest.turnaroundTime - shortest.burstTime;
        shortest.completed = true;
        completedCount++;
      }
    }
  }

  public static void printResults(ArrayList<Process> processes) {
    double totalWT = 0;
    double totalTAT = 0;

    System.out.println("\nSRTF Scheduling:");
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