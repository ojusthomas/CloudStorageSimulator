package thread1;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class displayc extends ApplicationFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static double available,current;
	public displayc(String title) {
		// TODO Auto-generated constructor stub
		  super( title ); 
	      setContentPane(createDemoPanel( ));
	}
	  private static PieDataset createDataset( ) 
	   {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Bytes of Harddisk free",available );  
	      dataset.setValue( "Bytes of Harddisk used" , current);   
	
	      return dataset;         
	   }
	   private static JFreeChart createChart( PieDataset dataset )
	   {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "Storage Availability Status of Harddisk",  // chart title 
	         dataset,        // data    
	         true,           // include legend   
	         true, 
	         false);

	      return chart;
	   }
	   public static JPanel createDemoPanel( )
	   {
	      JFreeChart chart = createChart(createDataset( ) );  
	      return new ChartPanel( chart ); 
	   }
	   public static void main( double avai,double curr )
	   {
		   available=avai;
		   current=curr;
	      display demo = new display( "Storage Availability Status of Harddisk" );  
	      demo.setSize( 560 , 367 );    
	      RefineryUtilities.centerFrameOnScreen( demo );    
	      demo.setVisible( true ); 
	  
	   }
	   



}
