
public class Driverclass {
	String driverName;
	int driverNo;
	String state;
	String journey;
	String train;
	String route;
	
	
	public Driverclass(){
		
	}
	
	public Driverclass (String name,String state){
		this.driverName = name;
		this.state = state;
	}
	public int getDriverNo(){
		return this.driverNo;
	}
	
	public String getDriverName(){
		return this.driverName;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public String toString() {

			return this.driverName +"  "+ this.state;
	}
}
