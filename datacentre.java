/*Data centre class is a cloud resource which manages and call the cpu class.It also initiliazes all the active connective connections.
 * All the Connectivity class are given name and its maximum bandwidth speed.
 * The simulation process starts from here.
 */
package thread1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
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
	static int actual_no_of_Cpu=0;
	private Scanner s;
	public connectivity cs[];
	List<String> nameofcpu = new ArrayList<String>();
	public datacentre(){
		
	}
	//constructor to initiliaze the values
	public datacentre(int no_of_Cpu,cpu c[]){
		no_of_cpu=no_of_Cpu;
		c=new cpu[no_of_Cpu];
	}
	
	public void set () throws Exception {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		//Path currentRelativePath ;
		String sw = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("Current relative path is: " + sw);
		cs = new connectivity[no_of_cpu];
		listf(sw);
		File dir = new File(sw);
		File listDir[] = dir.listFiles();
		for (int i = 0; i < listDir.length; i++) {
		    if (listDir[i].isDirectory()) {
		    	if(actual_no_of_Cpu>0)
		    		nameofcpu.add(listDir[i].toString());
		    	actual_no_of_Cpu++;
		    	
		        }
		}
		actual_no_of_Cpu--;
		String[] arr = nameofcpu.toArray(new String[nameofcpu.size()]);
		cs=new connectivity[actual_no_of_Cpu];
		for(int i=0;i<actual_no_of_Cpu;i++){
			if(cs[i]!=null)
			cs[i].initialize(arr[i],Math.random()*11);
		}
		if(actual_no_of_Cpu<=no_of_cpu){
			cpu c1=new cpu(2,2,2);
			c1.run();
			
		}
		
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
