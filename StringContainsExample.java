package thread1;

import java.io.File;
import java.io.IOException;

public class StringContainsExample {
	static String r;
    public static String  main(File fil) throws IOException {
       String args=fil.getName();
       String word =fil.getAbsolutePath();
       int c=-1;
       //indexOf return -1 if String does not contain specified word
       if(word.indexOf(args) != -1){
    	   c=word.indexOf(args);
    	   r=word.substring(0, c-1);
    	 
       }
       return r;
    }
}
