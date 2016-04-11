/**cpu class initialize all the harddisk along with it its maximum speed and speed .The power consumption is simulated in cpu on the basis of
 * total number of read and write operation is performed by the cpu.
 * 
 */
package thread1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Prranata
 * @model
 */
public class cpu {
	Integer RAM,Process,max_Connection;
	public cpu(int ram,int process,int max_connection){
	RAM=ram;
	Process=process;
	max_Connection=max_connection;
	}
	static Queue<Integer> q = new ArrayDeque<>();
	static Queue<Integer> q2 = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		double capacity,speed;
		int choice,readcount=0,writecount=0,currentcount=0;
		String name_hd;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		/*System.out.println("Enter the connectivity name and its bandwidth speed");
		str=scanner.next();
		ban=scanner.nextInt();*/
		System.out.println("Enter the name of harddisk");
		name_hd=scanner.nextLine();
		System.out.println("Enter the maximum capacity of harddisk");
		capacity=scanner.nextDouble();
		System.out.println("Enter the maximum transfer speed of harddisk");
		speed=scanner.nextDouble(); 
		Harddisk h=new Harddisk(name_hd,capacity,speed);
		do{
		System.out.println("Enter 1 to read the resource");
		System.out.println("Enter 2 to write in the resource");
		System.out.println("Enter 3 to know the current status about the resource");
		System.out.println("Enter 4 to exit out of the program");
		choice=scanner.nextInt();
		Integer count=0;
		q.add(count);
		q2.add(choice);
		while (!q.isEmpty()){
		switch(q2.element()){
			case 1:
				readcount++;
			h.readIn();
				break;
			case 2:
				writecount++;
			h.writeIn();
				break;
			case 3:
				currentcount++;
				h.currentstatus();
				break;
			case 4:
				if(count>10){
					h.writeInLog("The power consumption is:"+((currentcount*6.85*0.9)+((writecount*9.38*2.5)/100)+((readcount*8.44*7.5)/100))+" Watts");
				}
				else{
					h.writeInLog("The power consumption is:"+((currentcount*6.85)+(writecount*9.38)+(readcount*8.44*3))/5+" Watts");
				}
			//	ReadandWrite.main(readcount,writecount);
			//	display.main(readcount,writecount);
				LineChart.main(readcount, writecount);
				storageavail.main(h.Available, h.capacity);
				//displayc.main(h.Available,h.capacity);
				System.out.println("Program Execution Completed");
				h.writeInLog("Program Execution Completed");
				//System.exit(0);
				break;
			}
		q2.poll();
		q.poll();
		}
			count++;
		}while(choice!=4);
		
	
		
	
		//d=h.writeIn();
		//System.out.println(" The total time is:"+d+" seconds");
	//	d=h.readIn();
		//System.out.println(" The total time is:"+d+" seconds");
	}

}
