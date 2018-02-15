public class Trainclass{
	String trainName;
	String state;
	String journey;
	
	public Trainclass(String trainName, String routeName,String journey){
		this.trainName = trainName;
		this.state = routeName;	
		this.journey = journey;
	}
	
	public Trainclass (String trainName){
		this.trainName = trainName;
		this.state = "idle";
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public String toString(){
		String result = ""+this.trainName+","+this.state;
		return result;
	}
}
