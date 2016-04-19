package thread1;

import java.io.*;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart
{
	
   public static void main( int read_count,int write_count ) throws Exception
   {
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      line_chart_dataset.addValue( read_count , "Workload on Hard disk" , "Number of Read" );
      line_chart_dataset.addValue( write_count, "Workload on Hard disk" , "Number ofWrite" );
      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "WorkLoad on HARD DISK","Operation Performed",
         "Count",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,false);
      int width = 640; /* Width of the image */
      int height = 480; /* Height of the image */    
      String linechart=Harddisk.re.concat("LineChart.JPEG");
      File lineChart = new File(linechart); 
      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
   }
}
