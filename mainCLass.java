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
		datacentre d=new datacentre(1);
		d.main(null);
		/*File source,dest;
		String loc=	StringContainsExample.main("cloudsim");
		source = new File("/Users/Prranata/Documents/workspace/thread1/cgd.txt");
        dest = new File("/Users/Prranata/Documents/workspace/thread1/cloudsim/cgd.txt");
		FileSearch.main(loc,"cgd.txt");
		//copy.main(loc+"bbb.txt", "/Users/Prranata/Documents/workspace/thread1/cloudsim");
		Files.copy(source.toPath(), dest.toPath());*/
	}

}
