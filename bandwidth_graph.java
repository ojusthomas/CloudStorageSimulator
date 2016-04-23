package thread1;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class bandwidth_graph{
	
	public static void draw(double congestion,double active) throws IOException {
		
	    //Prepare the data set
	    DefaultPieDataset pieDataset = new DefaultPieDataset();
	    pieDataset.setValue("CONGESTED LINK", congestion);
	    pieDataset.setValue("ALIVE/DEAD LINK", (active-congestion));
	    
	    //Create the chart
	    JFreeChart chart = ChartFactory.createPieChart(
	        "Bandwidth Congestion of CPU", pieDataset, true, true, true);
	    //Save chart as PNG
	      ChartUtilities.saveChartAsPNG(new File(Harddisk.re.concat("bandwidthcongestion.png")), chart, 400, 300);
	  }
    
} 
