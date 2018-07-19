import java.util.*;
class FistComeFirstServeOperations {
	/**
	 * calculates completion time for all processes
	 * @param  processTimings[][] stores burst time and arrival time of processes
	 * @return  completion[] stores completion time of each process
	*/
    public void completionTime(int processTimings[][], int noOfProcess, int completion[])
    {
        int completionTime = 0;
        int process = 1;
        completion[0] = processTimings[0][1];
        for(int i= 1; i < noOfProcess; i++, process++) {
            if(completion[i-1] > processTimings[i][0]) {
                completionTime = processTimings[i][1] + completion[i - 1];
            }
            else {
                completionTime = processTimings[i][1] + processTimings[i][0];
            }
            completion[process] = completionTime;
        }
    }
    /**
	 * calculates Turnaround time for all processes
	 * @param  processTimings[][] stores burst time and arrival time of processes
	 * @param  completion[] stores completion time of each process
	 * @return  turnaround[] stores turnaround time of each process
	*/
    public void turnaroundTime(int processTimings[][],int noOfProcess, int turnaround[], int completion[])
    {
        int turnAroundTime = 0;
        for(int i = 0; i < noOfProcess; i++) {
            turnaround[i] = completion[i] - processTimings[i][0];
        }
    }
    /**
   	 * calculates waiting time for all processes
   	 * @param  processTimings[][] stores burst time and arrival time of processes
   	 * @param  turnaround[] stores completion time of each process
   	 * @return  waiting[] stores waiting time of each process
   	*/

    public void waitingTime(int processTimings[][],int noOfProcess,int waiting[],int turnaround[])
    {
        int waitingTime = 0;
        int wait = 0;
        for(int i = 0; i < noOfProcess; i++) {
            waiting[i] = turnaround[i] - processTimings[i][1];
        }
    }
    /**
   	 * calculates average waiting time 
   	 * @param  processTimings[][] stores burst time and arrival time of processes
   	 * @param  waiting[] stores waiting time of each process
   	 * @return  average waiting time 
   	*/
    public float averageWaitingTime(int processTimings[][], int noOfProcess, int waiting[])
    {
    	float averageWait = 0;
    	for(int i = 0;i < noOfProcess; i++) {
    		averageWait += waiting[i];
    	}
    	averageWait = averageWait/noOfProcess;
    	return averageWait;
    }
    /**
   	 * calculates maximum waiting time 
   	 * @param  processTimings[][] stores burst time and arrival time of processes
   	 * @param  waiting[] stores waiting time of each process
   	 * @return  maximum waiting time 
   	*/
    public int maximumWaitingTime(int processTimings[][], int noOfProcess, int waiting[])
    {
    	int maximum=0;
    	for(int i = 0; i < noOfProcess; i++) {
    		if(waiting[i] > waiting[maximum]) {
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
        Scanner sc =new Scanner(System.in);
        noOfProcess = sc.nextInt();
        int[] completion = new int[noOfProcess];
        int[] waiting  =new int[noOfProcess];
        int[] turnaround = new int[noOfProcess];
        FirstComeFirstServeOperations fcfsOperation = new FirstComeFirstServeOperations();
        int[][] processTimings = new int[noOfProcess][2];
        for(int i = 0; i < noOfProcess; i++) {
            System.out.println("Enter arrival and burst time for " + i + " process: ");
            for(int j = 0; j < 2; j++) {
                processTimings[i][j] = sc.nextInt();
            }
        }
        fcfsOperation.completionTime(processTimings, noOfProcess, completion);
        fcfsOperation.turnaroundTime(processTimings, noOfProcess, turnaround, completion);
        fcfsOperation.waitingTime(processTimings, noOfProcess, waiting, turnaround);
        System.out.println("Process  Arrival time  Burst time  Completion time  Turnaround time  Waiting time");
        for(int i = 0; i < noOfProcess; i++) {
        	System.out.println(i + "\t \t" + processTimings[i][0]  + "\t \t" + processTimings[i][1] + "\t \t" + completion[i] + "\t \t" + turnaround[i] + "\t \t" + waiting[i]);
        }
        float average = fcfsOperation.averageWaitingTime(processTimings, noOfProcess, waiting);
        System.out.println("The average waiting time is " + average);
        int maximumWait = fcfsOperation.maximumWaitingTime(processTimings, noOfProcess, waiting);
        System.out.println("The maximum waiting time is " + maximumWait);
    }
    
}

