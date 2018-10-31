/*
 * THis is the main class that runs the program
 * Right now it takes in a file to run directly from the Process Class
 */

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

//import javax.xml.transform.Templates;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		Process Process = new Process();
		Scheduler Schedule = new Scheduler();
		String fileInput;
		//ReadyQue
		
		//test for single file
		System.out.println("Press 1 to choose a file ");
		System.out.println("Press 2 to choose multiple files ");
		int choiceInput = scan.nextInt();
			if(choiceInput == 1)
			{
				System.out.println("What file would you liked to use :");
				fileInput = scan.next();
				Process.runProgram(fileInput);
				
			}
			
			else if(choiceInput == 2)
			{
				System.out.println("How many programs do you want to run");
				int fileNumber = scan.nextInt();
				
				
				for(int PS = 0; PS <= fileNumber; PS ++)
				{
					Scheduler.positionofLL(PS);
					
					if(PS%2 == 0)
					{
						fileInput = "paint.txt";
						
					}
					else
					{
						fileInput = "ide.txt";
					}
					
					Process.runProgram(fileInput);
				}
				
			}
			
			else
			{
				System.out.println("Invalid Choice.\n Please Run program again.");
			}
	
		
		
		scan.close();
		
	
	}

}
