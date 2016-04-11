package thread1;

//@model
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*to write the content in the file at the speicified harddisk.
 * A log file is created in every harddisk to store all the operation which has been performed by various process.
 */
public class Logfile {
		// TODO Auto-generated method stub
	
		public void writeAtPath(String path,String arg){
			   BufferedWriter bw = null;
			try {
					File myFile = new File(path + "/log.txt");
		            // check if file exist, otherwise create the file before writing
		            if (!myFile.exists()) {
		                myFile.createNewFile();
		            }
		            bw = new BufferedWriter(new FileWriter(myFile, true));
		            bw.write(arg);
		            bw.newLine();
		            bw.flush();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally{
		            try{
		                if(bw != null) bw.close();
		            } catch(Exception ex){
		            }
		        }
		}
		
	
}
