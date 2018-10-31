import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Process {
	
	File processFile;
	BufferedReader br;
	Scheduler Schedule = new Scheduler();
	
	public int calculateProcess = 0;
	public int calculateTotal = 0;
	public int IO_Outburst = 0;
	public int currentTime = 0;
	public int currentTimeQuantum = Schedule.currentTimeQuantum;
	
	
//public int io
	
	
	
	
	
	
	public Process() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Process (String fileInput) {
		
	}


	public void runProgram(String userInput) throws IOException  {
		
		
		Process_Control_Block pcb = new Process_Control_Block();
		
		
		processFile = new File(userInput);
		br = new BufferedReader(new FileReader(processFile));
		Random rand = new Random();
		int readCounter = 0;
		
		pcb.pState = Process_State.RUNNING;
		pcb.processorID = Scheduler.index;
		
		//String processOutput = br.readLine();
		String processOutput;
		
		//String memoryLimit = br.readLine();
		
		//pcb.programCounter =4;
		
		/*
		if(pcb.pState != Process_State.TERMINATED)
		{
			System.out.println("The pcb state is " + pcb.pState);
			System.out.println("Should print as it is not termintated");
		}
	
		pcb.pState = Process_State.TERMINATED;
		
		if(pcb.pState != Process_State.TERMINATED)
		{
			System.out.println("The pcb state is " + pcb.pState);
			System.out.println("Should print as it is not termintated");
		}
		else
		{
			System.out.println("now it should print as it is terminated");
		}
		*/
	
		while(readCounter <= pcb.programCounter)
		{
			br.readLine();
			readCounter++;
		}
		
		// 
		
		
		while((processOutput = br.readLine()) != null)
		{
			
	
			if(Character.isDigit(processOutput.charAt(0)))
			{
				int memoryLimit = Integer.valueOf(processOutput);
				System.out.println("The memory Limit is : " + memoryLimit);
				pcb.set_MemoryRequirement(memoryLimit);
				//checkQue()
				pcb.programCounter++;
				currentTimeQuantum++;
				
			}
			
			if(processOutput.length() >=8 && processOutput.substring(0,8).equals( "PRIORITY"))
			{
				int priority = Integer.valueOf(processOutput.substring(9));
				//System.out.println(priority);
				pcb.set_Priority(priority);
				pcb.programCounter++;
				currentTimeQuantum++;
			}
			
			if(processOutput.length() >= 3 && processOutput.substring(0,3).equals("OUT"))
			{
				String output = pcb.toString();
				//System.out.println("This is a test out");
				System.out.println(output);
				pcb.programCounter++;
				currentTimeQuantum++;
				
			}
			if(processOutput.length() >= 3 && processOutput.substring(0,3).equals("I/O"))
			{
				IO_Outburst =IO_Outburst +   rand.nextInt(100) + 1;
				//System.out.println("IO burst : " + IO_Outburst);
				pcb.pState = Process_State.READY;
				pcb.programCounter++;
				currentTime =IO_Outburst;
				Schedule.calculateQuantum(currentTime,currentTimeQuantum);
				currentTimeQuantum = currentTimeQuantum + currentTime;
			}
			if(processOutput.length() >= 9 && processOutput.substring(0,9).equals("CALCULATE"))
			{
				calculateProcess = Integer.valueOf(processOutput.substring(10));
				//calculateTotal = calculateTotal = calculateTotal + calculateProcess;
				//System.out.println("Calculate : " + calculateProcess);
				pcb.programCounter++;
				currentTime = calculateProcess;
				
				Schedule.calculateQuantum(currentTime,currentTimeQuantum);
				currentTimeQuantum = currentTimeQuantum + currentTime;
				
			}
			if(processOutput.length() >= 3 && (processOutput.substring(0,3).equals("EXE")))
			{
				
				pcb.programCounter++;
				pcb.pState = Process_State.TERMINATED;
				currentTimeQuantum++;
				//Scheduler.removefromPCB(pcb.processorID);
				//return;
			}
			
			if(processOutput.length() >= 5 && processOutput.substring(0,5).equals("YIELD"))
			{
				pcb.pState = Process_State.READY;
				//pcb.pState = Process_State.WAITING;
				pcb.programCounter++;
				currentTimeQuantum++;
				
			}
			if(processOutput.length() >= 5 && processOutput.substring(0,4).equals("NAME") )
			{
				String ProcessorName = processOutput.substring(5);
				pcb.set_ProcessorName(ProcessorName);
			}
			
			
			
			Schedule.checkForNextProcess(currentTimeQuantum, pcb);
			
			
			
			//System.out.println(processOutput);
			
				
			//pcb.pState = Process_State.TERMINATED;
			
			
		}
	
		
		
		
	/*	if(pcb.pState == Process_State.TERMINATED)
		{
			
		}
	*/	
		//System.out.println(pcb.toString());
		//System.out.println("Calculate is : " + calculateTotal);
		//System.out.println("IO Burst is : " + IO_Outburst);
		br.close();
		
		
		//System.out.println("Memory Limit : " + memoryLimit + "\n");
	
		
		
		
		System.out.println("This worked successfully");
		
		
	}



	
	
	

}
