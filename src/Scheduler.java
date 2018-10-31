import java.util.LinkedList;
import java.util.PriorityQueue;

public class Scheduler {
	
	public int numberPrograms;
	
	
	public int currentTimeQuantum = 0;
	public int maxTimeQuantum = 20;
	public static int index;
	 //public Process_Control_Block pcb;

	
	
	//public Process_Que readyQueue = new Process_Que (Process_State.READY);
	//public Process_Que waitQueue = new Process_Que (Process_State.WAITING);
	 static LinkedList<Process_Control_Block> pcbList = new LinkedList<Process_Control_Block>();
	

	

	
public void insert_newPCB (Process_Control_Block pcb) {
		
		pcbList.add(pcb);
	}


	public void checkForNextProcess(int currentTimeQuantum, Process_Control_Block pcb ) {
		if(currentTimeQuantum >= maxTimeQuantum)// && pcbList.size() >1)
		{
			//String name = pcb.get_ProgramName();
			//System.out.printf("SwitchProcess to\n", name);'
			nextProcess();
			//pcbList.remove(index);
			
		}
		else//
		{
			//System.out.println("Do not switch process");
		}
	}
	
	public void nextProcess() 
		{
			//System.out.println("This should switch now");
			
		}
		public static  void positionofLL(int PS) {
			 index = PS;
			
			
		}
		
		
	
	
	public void  calculateQuantum(int num, int totalTime) {
		if ( num / 10 > 1) 
		{
			num = num /10;
		}
		else
		{
			totalTime++;
		}
	}


	public static  void removefromPCB(int num) {
		// TODO Auto-generated method stub
		pcbList.remove(num);
	} 
	
	
}
