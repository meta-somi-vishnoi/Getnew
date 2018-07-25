import java.util.*;

class FirstComeFirstServeOperations {
    /**
     * calculates completion time for all processes
     * 
     * @param processTimings[][] stores burst time and arrival time of processes
     * @return completionList[] stores completion time of each process
     */
    public void completionTime(int processTimings[][], int noOfProcess, int completionList[]) {
        int completionTime = 0;
        int process = 1;
        completionList[0] = processTimings[0][1] + processTimings[0][0];
        for (int i = 1; i < noOfProcess; i++, process++) {
            if (completionList[i - 1] > processTimings[i][0]) {
                completionTime = processTimings[i][1] + completionList[i - 1];
            } else {
                completionTime = processTimings[i][1] + processTimings[i][0];
            }
            completionList[process] = completionTime;
        }
    }

    /**
     * calculates Turnaround time for all processes
     * 
     * @param processTimings[][] stores burst time and arrival time of processes
     * @param completionList[] stores completion time of each process
     * @return turnaroundList[] stores turnaround time of each process
     */
    public void turnaroundTime(int processTimings[][], int noOfProcess, int turnaroundList[], int completionList[]) {
        int turnAroundTime = 0;
        for (int i = 0; i < noOfProcess; i++) {
            turnaroundList[i] = completionList[i] - processTimings[i][0];
        }
    }

    /**
     * calculates waiting time for all processes
     * 
     * @param processTimings[][] stores burst time and arrival time of processes
     * @param turnaroundList[] stores completion time of each process
     * @return waitingList[] stores waiting time of each process
     */

    public void waitingTime(int processTimings[][], int noOfProcess, int waitingList[], int turnaroundList[]) {
        int waitingTime = 0;
        int wait = 0;
        for (int i = 0; i < noOfProcess; i++) {
            waitingList[i] = turnaroundList[i] - processTimings[i][1];
        }
    }

    /**
     * calculates average waiting time
     * 
     * @param processTimings[][] stores burst time and arrival time of processes
     * @param waitingList[] stores waiting time of each process
     * @return average waiting time
     */
    public float averageWaitingTime(int processTimings[][], int noOfProcess, int waitingList[]) {
        float averageWait = 0;
        for (int i = 0; i < noOfProcess; i++) {
            averageWait += waitingList[i];
        }
        averageWait = averageWait / noOfProcess;
        return averageWait;
    }

    /**
     * calculates maximum waiting time
     * 
     * @param processTimings[][] stores burst time and arrival time of processes
     * @param waitingList[] stores waiting time of each process
     * @return maximum waiting time
     */
    public int maxWaitingTime(int processTimings[][], int noOfProcess, int waitingList[]) {
        int maximum = 0;
        for (int i = 0; i < noOfProcess; i++) {
            if (waitingList[i] > waitingList[maximum]) {
                maximum = i;
            }
        }
        return maximum;
    }

}

public class SchedulingAlgorithm {
    public static void main(String[] args) {

        int noOfProcess;
        System.out.println("Enter no of process");
        Scanner sc = new Scanner(System.in);
        noOfProcess = sc.nextInt();
        int[] completionList = new int[noOfProcess];
        int[] waitingList = new int[noOfProcess];
        int[] turnaroundList = new int[noOfProcess];
        FirstComeFirstServeOperations fcfsOperation = new FirstComeFirstServeOperations();
        int[][] processTimings = new int[noOfProcess][2];
        for (int i = 0; i < noOfProcess; i++) {
            System.out.println("Enter arrival and burst time for " + i + " process: ");
            for (int j = 0; j < 2; j++) {
                processTimings[i][j] = sc.nextInt();
            }
        }
        fcfsOperation.completionTime(processTimings, noOfProcess, completionList);
        fcfsOperation.turnaroundTime(processTimings, noOfProcess, turnaroundList, completionList);
        fcfsOperation.waitingTime(processTimings, noOfProcess, waitingList, turnaroundList);
        System.out.println("Process  Arrival time  Burst time  Completion time  Turnaround time  Waiting time");
        for (int i = 0; i < noOfProcess; i++) {
            System.out.println(i + "\t \t" + processTimings[i][0] + "\t \t" + processTimings[i][1] + "\t \t" + completionList[i]
                + "\t \t" + turnaroundList[i] + "\t \t" + waitingList[i]);
        }
        float averageWait = fcfsOperation.averageWaitingTime(processTimings, noOfProcess, waitingList);
        System.out.println("The average waiting time is " + averageWait);
        int maximumWait = fcfsOperation.maxWaitingTime(processTimings, noOfProcess, waitingList);
        System.out.println("The maximum waiting time is " + maximumWait);
    }
}
