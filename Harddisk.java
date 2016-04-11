/**the program to simulate the behaviour of typical harddisk.The program simulate the time taken to read and write a file when erasure coding is being performed.
 * @author Prranata
 */
package thread1;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//@model
public class Harddisk  {
	String name;//name of the harddisk;
	public double capacity; //total capacity of harddisk
	private double maxTransferRate; //maximum transfer rate 
	private double latency; //latency of harddrive in seconds
	private double avgSeekTime; // average seek time
	public double Available;//total space currently available
	int n=0;//total number of files in the harddrive
	public double currentSize; // current size of harddisk
	String re;//store the absolute address of the directory
	static int count =1;
	static Queue<Integer> q2 = new ArrayDeque<>();
	public int sector,track;//number of sector and track
	int max_track;//maximum number of sector in a track
	Thread t; //thread initialization
	long res;//to store the sleep time.When an Operation is being performed.
	int trackallot [];
	String sectorallot [];
	String track_allot [] [];
	int head_movement=0;//to find head movement in sector;
	int prev=0;//to find where head was previously;
	int track_movement=0;//to find head movement in track
	int prev_Track=0;//to find previous track;
	//Constructor to initialize the harddisk name,its maximum capacity and maximum transfer rate
	int count2=0;
	public Harddisk(String name,double capacity,double maxTransferRate1){
		File f=new File(name);
		re=f.getAbsolutePath();
		re+="/";
	
		if (f.isDirectory()){
			listf(name);
		if (name == null || name.length() == 0) {
			System.out.println("HarddriveStorage(): Error - invalid storage name.");
			System.exit(0);
		}
		
		if (capacity <= 0) {
			System.out.println("HarddriveStorage(): Error - capacity <= 0.");
			System.exit(0);
		}
		this.capacity = capacity;
		// fileList=listf(name);
		currentSize = 0;
		maxTransferRate = maxTransferRate1; // in MB/sec
		sector=(int) (capacity/512); //a sector can store 512bytes of data.Finding number of sector in a hard disk
		for(int i=10;i<=sector;i++){
			if((sector%i)==0){
				track=sector/i;
				max_track=i;
				System.out.println("The track is:"+track);
				break;
			}
		}
	}
		else{
			System.out.println("Directory not found");
			System.exit(0);
		}
		
		trackallot =new int[track];
		sectorallot =new String [sector];
		track_allot =new String [n][2];
		Arrays.fill (sectorallot,"null");
		Arrays.fill(trackallot,0);
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
	 //code to  call read,write,update and delete file
	  public double writeIn() {
		  System.out.println("Enter the name of file in which you want to write");
		  File file;
		  double result=0.0;
		  @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
          String strContent =scanner.nextLine();
          writeInLog("PRCOESS: "+count+" PERFORMED WRITE OPERATION \n");
          writeInLog("The file name is :"+strContent);
          
          strContent=re.concat(strContent);
		  file = new File(strContent);
		  if ((file.length() + currentSize) > capacity) {
				System.out.println(name + ".addFile(): Warning - not enough space" + " to store " + file.getName());
				//System.exit(0);
		  }
		  else{
		
		  result += getSeekTime(file.length());
		  currentSize+=file.length();
		
		  Available=capacity-(file.length() + currentSize);
		//  System.out.println("Available space"+Available+" The total time is:"+result+" seconds");
		  writeInLog("The current capacity of hard disk is:"+currentSize);
		  writeInLog("\nThe available space in hard disk is:"+Available);
		  writeInLog("\nProcess Number "+count+" took total "+ result+ "miliseconds to complete its job\n");
		  res=(long)result;
		  new NewThread("Write",(res+3000));
		 if((file.length()/1048576)> datacentre.avg_bandwidth){
			 datacentre.state="CONGESTED";
			 System.out.println("The bandwidth is congested due to large file size.The speed of transfer has been reduced");
		 }
		 secandtrac(file.length(),strContent);
		  count++;
		  }
		return result;
	  }
	  @SuppressWarnings("resource")
	public double readIn() {
		    Scanner s;
			s = new Scanner(System.in);
			System.out.println("Enter name of file which you wish to read");
	        String fileName =  s.nextLine();
	        writeInLog("PRCOESS: "+count+" PERFORMED READ OPERATION \n");
	        writeInLog("The file name is :"+fileName);
	       fileName=re.concat(fileName);
	        File file;
	  //   System.out.println(fileName+" location");
			double result=0.0;
			//long res;
			//read1 r=new read1();
			//r.main(fileName);
			file=new File(fileName);
			result += getSeekTime(file.length());
			//System.out.println(" The total time is:"+result+" seconds");
			finsec(fileName,file.length());
			fintrack(fileName);
			 writeInLog("Process Number "+count+" took total "+ result+ "miliseconds to complete its job \n");
			 res=(long)result;
			 new NewThread("Read",(res+1000));
			 if((file.length()/1048576)> datacentre.avg_bandwidth){
				 datacentre.state="CONGESTED";
				 System.out.println("The bandwidth is congested due to large file size.The speed of transfer has been reduced");
			 }
			 count++;
			 
			return result;
	        
	  }
	
	  /**to find the seek time,latency time and total  time.
	  *@param:latency find the latency time using random function.It is between 0 to 10 divided by 100.
	  *@param:avgSeekTime find the average seek time using rando function.The range is between 0 to 10 divided by 1000.
	  *@param:result It found the actual total time taken to perform the operation.Result is sum of latency,avgSeekTime and time taken to actual
	  *perform the operation(file length divided by maxTransfer Rate)
	  */
	
	private double getSeekTime(double l) {
				double result = 0;
				latency =(ThreadLocalRandom.current().nextDouble(0,10))/100;
				avgSeekTime =(ThreadLocalRandom.current().nextDouble(0,10))/100;
				//System.out.println("The lantency is"+latency+"sec .The seek time is: "+avgSeekTime);
				writeInLog("The lantency  for the process "+count+" is"+latency+" milisec.\nThe seek time for the process "+count+" is"+avgSeekTime+ " miliseconds");
				result=latency+avgSeekTime;
				if (l > 0 &&  Available!= 0) {
					result += (l / maxTransferRate);
				}
				return result;
		}
	/** to view what is the current status.How many process has been completed.What process did what operation.
	 * a file is created log.txt that write all the operations done.Time each took to complete the job.Latency and Seek time for
	 * each process.
	 */
	public void currentstatus() {
		read1 r=new read1();
		String loc="log.txt";
		loc=re.concat(loc);
		r.main(loc);
		}
	public  void writeInLog(String ar){
		Logfile l = new Logfile();
		l.writeAtPath(re,ar);
	}
	//function to allocate track and sector for every file
	public void secandtrac(double size,String name){
		int no_of_Sector=(int) Math.floor(size/512);
		int max=sector;
		int min=0,ran = 0;
		int allot_track=0;
		boolean allot=false,all=false;
		 track_allot[count2][0]=name;
		System.out.println("The no_of_Sector is :"+no_of_Sector+" the max no of sectors "+ max);
		while(allot!=true){
			   int randomNum = ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
			   ran=randomNum;
			 //  System.out.println("The random value: "+randomNum );
			   //System.out.println("The random value place: "+sectorallot[randomNum]);
			   
			   if(sectorallot[randomNum].equals("null") && sectorallot[randomNum+no_of_Sector-1].equals("null") ){
				   for(int i=randomNum;i<=randomNum+no_of_Sector-1;i++)
					   sectorallot[randomNum]=name;
				   allot=true;
			   }
		}
		System.out.println("the track value here"+track);
		allot_track=ThreadLocalRandom.current().nextInt(track);
	//	System.out.println("the track value  randomly is here"+allot_track);
		while(all!=true){
			allot_track=ThreadLocalRandom.current().nextInt(track);
			if(trackallot[allot_track]!=max_track){
				trackallot[allot_track]++; 
				  track_allot[count2][1]=Integer.toString(allot_track);
				  count2++;
				all=true;
			}
		}
		
		writeInLog("The sector alloted for the file "+ name +"  is from "+ ran +" till "+(ran+no_of_Sector));
		writeInLog("The track in which the file "+name+"is located is "+ allot_track);
	}
	public void finsec(String name,double size){
	
		int no_of_Sector=(int) Math.floor(size/512);
		int max=sector;
			for(int randomNum=0;randomNum<max-no_of_Sector;randomNum++){
			 if(sectorallot[randomNum].equals(name)){
				  head_movement=Math.abs(randomNum-prev);
				  prev=randomNum;
				  writeInLog("The head movement for sector to reach the file "+name+ " is "+ head_movement);
				  break;
			   }
		}
	}
	
	public void fintrack(String name){
			int value;
			for(int i=0;i<n;i++){
				if(track_allot[i][0]!=null){
				int x=track_allot[i][0].compareTo(name);
			if(x==0){
				value=Integer.parseInt(track_allot[i][1]);
				track_movement=Math.abs(value-prev_Track);
				prev_Track=value;
				 writeInLog("The head movement for track to reach the file "+name+ " is "+ track_movement);
			}}
		}
	}
}
