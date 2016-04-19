/*Data centre class is a cloud resource which manages and call the cpu class.It also initiliazes all the active connective connections.
 * All the Connectivity class are given name and its maximum bandwidth speed.
 * The simulation process starts from here.
 */
package thread1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Paths;;
// @model
public class datacentre {
	String sw;
	int no_of_cpu;//maximum number of cpu that can be there in a data centre
	static double  avg_bandwidth;//every connectivity class has a bandwidth.It calculates the average of all the bandwidth class.
	public static String  state;
	static int n=0;
	public datacentre(){
		
	}
	//constructor to initiliaze the values
	public datacentre(int no_of_Cpu){
		no_of_cpu=no_of_Cpu;
	}
	
	public  void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//function to call the cpu class.
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		double totalsum=0;
		String str;
		int ban,no_of_Connectivity,i;
		//Path currentRelativePath ;
		String sw = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("Current relative path is: " + sw);
		listf(sw);
	/*	System.out.println("Enter number of active connectivity");
		no_of_Connectivity=s.nextInt();
		connectivity [] c=new connectivity[no_of_Connectivity];//create object array of connectivity class
		for ( i=0; i<no_of_Connectivity; i++) {
			c[i]=new connectivity();
			}
		for(i=0;i<no_of_Connectivity;i++){
			System.out.println("Enter the connectivity name and its bandwidth speed");
			str=s.next();
			ban=s.nextInt();
			c[i].name=str;
			c[i].bandwidth=ban;
			totalsum+=c[i].bandwidth;
		}*/
		
		/*avg_bandwidth=totalsum/no_of_Connectivity;
		state="ALIVE";
		if(avg_bandwidth==0)
			state="DEAD";
		System.out.println("The average bandiwdth of the connection in this data centre is:"+avg_bandwidth);*/
		cpu c1=new cpu(4,2,2);
		cpu.main(null);	
		
	}
	 
	  public List<File> listf(String directoryName) {
	        File directory = new File(directoryName);
	        List<File> resultList = new ArrayList<File>();
	        // get all the files from a directory
	        File[] fList = directory.listFiles();
	        resultList.addAll(Arrays.asList(fList));
	        for (File file : fList) {
	        	 System.out.println(file);
	        	 n++;
	            if (file.isDirectory()) {
	                resultList.addAll(listf(file.getAbsolutePath()));
	               
	            }
	        }
	        System.out.println("The no of files are : " +n);
	        return resultList;
	    } 

}
