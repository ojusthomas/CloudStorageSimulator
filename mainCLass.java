/*mainClass to call the data centre class */
package thread1;
/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;*/
public class mainCLass {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		cpu c[]=new cpu[4];//cpu object cannot be passed without declaring it.
		datacentre d=new datacentre(4,c);//creating data centre and object
		d.set();
	}

}
