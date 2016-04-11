package thread1;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class storageavail {
	/*static int no_read,no_write,total=0;
	public ReadandWrite(int no_read,int no_write) {
		// TODO Auto-generated constructor stub
	
	}*/
	public static void main(double available,double used) throws IOException {
		
	    //Prepare the data set
	    DefaultPieDataset pieDataset = new DefaultPieDataset();
	    pieDataset.setValue("Amount of Storage Available", available);
	    pieDataset.setValue("Amount of Storage Used", used);
	    
	    //Create the chart
	    JFreeChart chart = ChartFactory.createPieChart(
	        "Storage Availability Status of Harddisk", pieDataset, true, true, true);
	    //Save chart as PNG
	      ChartUtilities.saveChartAsPNG(new File("storageavailable.png"), chart, 400, 300);
	  }
    
}
