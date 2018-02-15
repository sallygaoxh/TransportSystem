import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

public class Journeyclass {
	String journeyName;
	String trainName;
	String driverName;
	String route;
	ArrayList<String> stations = new ArrayList<String>(); 
	Calendar startTime = Calendar.getInstance();
    ArrayList<String> timetable = new ArrayList<String>();
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    
    public Journeyclass(String journeyName,String trainName,String driverName,String route,String startTime) throws IOException {
		this.journeyName = journeyName;
		this.driverName = driverName;
		this.route = route;
		this.trainName = trainName;
    	String temp[] = startTime.split(":");
    	this.startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[0]));
    	this.startTime.set(Calendar.MINUTE, Integer.parseInt(temp[1]));
		BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//Route.txt")));
		String temp2;
		ArrayList<Routeclass> routeList = new ArrayList<Routeclass>();
		temp2 = br.readLine();
		while((temp2 = br.readLine())!=null){			
			String[] temp1 = temp2.split(",");
			routeList.add(new Routeclass(temp1[0],temp1[1],temp1[2],temp1[3]));        
		}
		br.close();
		
		for(int i = 0;i<routeList.size();i++){
			if(routeList.get(i).routeName.equals(this.route)){
				this.stations = routeList.get(i).stations;
				this.timetable.add(df.format(this.startTime.getTime()));
				System.out.println(routeList.get(i).interval.size());
				for(int j = 0;j< routeList.get(i).interval.size();j++){
					this.startTime.add(Calendar.MINUTE,routeList.get(i).interval.get(j));
					this.timetable.add(df.format(this.startTime.getTime()));
				}
				for(int j = routeList.get(i).interval.size()-1;j>=0;j--){
					this.startTime.add(Calendar.MINUTE,routeList.get(i).interval.get(j));
					this.timetable.add(df.format(this.startTime.getTime()));
				}
				for(int j = routeList.get(i).interval.size()-1;j>=0;j--){
					this.startTime.add(Calendar.MINUTE,-2*(routeList.get(i).interval.get(j)));
				}
			}
		}
	}
    
    public Journeyclass(String journey,String train,String driver,String route,String station,
    		String startTime,String timetable){
    	this.journeyName = journey;
    	this.trainName = train;
    	this.driverName = driver;
    	this.route = route;

    	String stationArray[] = station.split(" ");
    	for(int i = 0;i<stationArray.length;i++){
    		stations.add(stationArray[i]);
    	} 
    	String temp[] = startTime.split(":");
    	this.startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[0]));
    	this.startTime.set(Calendar.MINUTE, Integer.parseInt(temp[1]));
        String timetableStrings[] = timetable.split(" ");
        for (int i=0;i<timetableStrings.length;i++){
        	this.timetable.add(timetableStrings[i]);
        }
    }
	
	public String toString() {
		String result =  this.journeyName+","+this.trainName+
				","+this.driverName+","+this.route+",";
		for (int i = 0;i<this.stations.size()-1;i++){
			result += this.stations.get(i)+" ";
		}
		result += this.stations.get(this.stations.size()-1)+","+df.format(this.startTime.getTime())+",";
		for (int i = 0;i<this.timetable.size()-1;i++){
			result += this.timetable.get(i)+" ";
		}
		result += this.timetable.get(this.timetable.size()-1);
		return result;
	}
	
}
