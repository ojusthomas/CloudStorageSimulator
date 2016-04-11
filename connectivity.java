//connectivity class is simply for the purpose to intialize all the active connections with their name and bandwidth speed.
package thread1;

public class connectivity {

	String name;//name of the connection
	int bandwidth;//maximum speed of connection
	String state;//state of the connection.Three states-active,dead and congested.
	public connectivity(){
		
	}
	public connectivity(String name,int bandwidth) {
		// TODO Auto-generated constructor stub
		name=this.name;
		bandwidth=this.bandwidth;
		if(bandwidth>0)
		state="ALIVE"; //All the connectivity is initially assume to be ALive
		else
			state="DEAD";//If bandwidth is 0 then it means that the connectivity is broken
	}

}
