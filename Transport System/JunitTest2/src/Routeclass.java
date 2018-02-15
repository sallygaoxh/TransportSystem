import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Routeclass {
	String routeName;
	ArrayList<String> journey = new ArrayList<String>();
	ArrayList<String> stations = new ArrayList<String>();
	ArrayList<Integer> interval = new ArrayList<Integer>();
	
	public Routeclass(String route, String stations, String journey, String interval){
		this.routeName = route;
		String[] ss = stations.split(" ");
		for(int i = 0;i<ss.length;i++){
			this.stations.add(ss[i]);
		}
		
		String[] ss1 = journey.split(" ");
		for(int i = 0;i<ss1.length;i++){
			this.journey.add(ss1[i]);
		}
		
		String[] ss2 = interval.split(" ");
		for(int i = 0;i<ss2.length;i++){
			this.interval.add(Integer.parseInt(ss2[i]));
		}
	}
	
	public Routeclass(String routeName, ArrayList<String>  stations){
		this.routeName = routeName;
		this.stations = stations;
	}
	
	public Routeclass(int routeNo){
		this.routeName = "Route" + routeNo;
	}
	
	public Routeclass(){
	}
	
	public String toString() {
		StringBuffer resultString = new StringBuffer();
		resultString.append(this.routeName+",");  
		for(int i = 0;i<this.stations.size()-1;i++){
	    	resultString.append(this.stations.get(i)+" ");
	    }
		resultString.append(this.stations.get(this.stations.size()-1)+",");
		
		if(this.journey.size()>1){
			for(int i = 0;i<this.journey.size()-1;i++){
		    	resultString.append(this.journey.get(i)+" ");
		    }
			resultString.append(this.journey.get(this.journey.size()-1)+",");
		}
		else if(this.journey.size()==1){
			resultString.append(this.journey.get(0)+",");
		}
		
		for(int i = 0;i<this.interval.size()-1;i++){
	    	resultString.append(this.interval.get(i)+" ");
	    }
		resultString.append(this.interval.get(this.interval.size()-1));		
		
		return resultString.toString();
	}
	
	public void setJourney(ArrayList<String> journey) {
		this.journey = journey;
	}
	
}

