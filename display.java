package thread1;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class display extends ApplicationFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int read_count1,write_count1;
	public display(String title) {
		// TODO Auto-generated constructor stub
		  super( title ); 
	      setContentPane(createDemoPanel( ));
	}
	  private static PieDataset createDataset( ) 
	   {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Number of Read",read_count1 );  
	      dataset.setValue( "Number of Write" , write_count1);   
	
	      return dataset;         
	   }
	   private static JFreeChart createChart( PieDataset dataset )
	   {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "Read and Write Workload",  // chart title 
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
	   public static void main( int read_count,int write_count )
	   {
		   read_count1=read_count;
		   write_count1=write_count;
	      display demo = new display( "Read and Write Workload" );  
	      demo.setSize( 560 , 367 );    
	      RefineryUtilities.centerFrameOnScreen( demo );    
	      demo.setVisible( true ); 
	  
	   }
	   



}
