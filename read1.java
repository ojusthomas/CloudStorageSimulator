package thread1;
//@model
import java.io.*;
/*to perform the read operation.
 * use the readLine method of the BufferedReader to read one line at a time.
 * the readLine method returns null when there is nothing else to read.
 */
public class read1 {
    public void main(String args) {

     
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(args);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                args+ "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + args + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
       
        }
      //  s.close();
    }
}
