
public class Process_Control_Block {
	
	//process state
	//program counter
	//cpu register
	//cpu scheduling 
	//memory managment
	//accounting informaiton
	// I/O Status
	
	

	
	
	public Process_State pState;
	public String programName;
	public int processorID;
	public int memoryRequirement;
	public int priority;
	public int startTime;
	public int lastRunTime;
	public int programCounter;
	 
	
	public Process_Control_Block (Process_State pstate, String programName, int processorID, int memoryRequirement, int priority, int startTime, int lastRunTime, int programCounter) { 
		
		
		this.pState = Process_State.NEW;
		this.programName = programName;
		this.processorID = processorID;
		this.memoryRequirement = memoryRequirement;
		this.priority = priority;
		this.startTime = startTime;
		this.lastRunTime = lastRunTime;
		this.programCounter = programCounter;
		
		System.out.println("This is the state of the process");
			
	}
	
	
	
	public Process_Control_Block() {
		// TODO Auto-generated constructor stub
	}

	public Process_State get_ProcessorState () {
		return pState;
	}
	
	public void set_ProcessorState (Process_State pState) {
		this.pState = pState;
	}
	
	public String get_ProgramName() {
		return programName;
	}
	
	public void set_ProcessorName(String name) {
		this.programName = name;
	}
	
	public int get_ProcessorID() {
		return processorID;
		
	}
	
	public int get_MemoryRequirement() {
		return memoryRequirement;
	}
	public void set_MemoryRequirement(int memoryRequirement) {
		this.memoryRequirement = memoryRequirement;
	}
	
	public int get_Priority() {
		return priority;
	}
	
	public void set_Priority(int priority) {
		this.priority = priority;
	}
	
	public int get_startTime() {
		return startTime;
	}
	
	public int get_LastRunTime() {
		return lastRunTime;
	}
	public void set_LastRunTime(int lastRunTime) {
		this.lastRunTime = lastRunTime;
	}
	
	public int get_ProgramCounter() {
		return programCounter;
	}
	
	public void set_ProgramCounter(int programCounter) {
		this.programCounter = programCounter;
	}
	
	public String toString() {
		
		return "ProcessorState: " + pState + "\n " +
		"Program Name: " + programName + "\n" +
		"Processor ID : " + processorID + "\n" +
		"Memory Requirement: " + memoryRequirement + "\n" +
		"Priority : " + priority + "\n" +
		"Start time: " + startTime + "\n" +
		"Last Run time : " + lastRunTime + "\n" +
		"Program Counter : " + programCounter;
		
	}
	
}
