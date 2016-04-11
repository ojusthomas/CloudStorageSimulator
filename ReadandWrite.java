package thread1;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class ReadandWrite {
	/*static int no_read,no_write,total=0;
	public ReadandWrite(int no_read,int no_write) {
		// TODO Auto-generated constructor stub
	
	}*/
	public static void main(int no_read,int no_write) throws IOException {
		
	    //Prepare the data set
	    DefaultPieDataset pieDataset = new DefaultPieDataset();
	    pieDataset.setValue("Number of Read", no_read);
	    pieDataset.setValue("Number of Write", no_write);
	    
	    //Create the chart
	    JFreeChart chart = ChartFactory.createPieChart3D(
	        "Read and Write Workload Pie Chart", pieDataset, true, true, true);
	    //Save chart as PNG
	      ChartUtilities.saveChartAsPNG(new File("readandwrite.png"), chart, 400, 300);
	  }

}
