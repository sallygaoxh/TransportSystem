import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class FileService {
	 ArrayList<Driverclass> driverList = new ArrayList<Driverclass>();
	 ArrayList<Journeyclass> journeyList =  new ArrayList<Journeyclass>();
	 ArrayList<String> timetable = new ArrayList<String>();
	 ArrayList<Trainclass> trainList = new ArrayList<Trainclass>();
	 
	 public ArrayList jouneryFile() throws IOException{
		String temp = null; 
		BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//journey.txt")));            		
        temp=br.readLine();
        String[] journeyMsg = null;
        while((temp = br.readLine())!=null){				
            journeyMsg = temp.split(",");
            journeyList.add(new Journeyclass(journeyMsg[0],journeyMsg[1],journeyMsg[2],journeyMsg[3],journeyMsg[4],journeyMsg[5],journeyMsg[6]));
        }
        br.close();
		return journeyList;
	 }
	 
	 public ArrayList driverFile() throws IOException{
			String temp = null; 
			BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//driverInfo.txt")));
			while((temp = br.readLine())!=null){
				String[] temp1 = temp.split(",");
				driverList.add(new Driverclass(temp1[0],temp1[1]));       
			}
			br.close();
			return driverList;
	 }
	 
	 public ArrayList trainFile() throws IOException{
			String temp = null; 
			BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//train.txt")));
			temp = br.readLine();
			String[] temp1;
			while((temp = br.readLine())!=null){
				temp1 = temp.split(",");
				trainList.add(new Trainclass(temp1[0],temp1[1],temp1[2]));        
			}
			br.close();
			return trainList;
	 }
	 
	 public ArrayList<Routeclass> routeFile() throws IOException{
			BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//Route.txt")));
			String temp2;
			ArrayList<Routeclass> routelist = new ArrayList<Routeclass>();
			temp2 = br.readLine();
			while((temp2 = br.readLine())!=null){			
				String[] temp1 = temp2.split(",");
				routelist.add(new Routeclass(temp1[0],temp1[1],temp1[2],temp1[3]));        
			}
			br.close();
			return routelist;
	 }
	 
	 public void rewrite(ArrayList<Trainclass> trainList,ArrayList<Driverclass> driverList,ArrayList<Journeyclass> journeyList,String route) throws IOException{
		 File f=new File(".//Record//train.txt");
		 StringBuffer content = new StringBuffer();
		 content.append("TRAIN,STATE,JOURNEY\r\n");
		 int flag = 0;
		 for(int i = 0;i<trainList.size();i++){
			 flag = 0;
			 for(int j = 0;j<journeyList.size();j++){
				 if(trainList.get(i).trainName.equals(journeyList.get(j).trainName)){
					 content.append(trainList.get(i).trainName+","+journeyList.get(j).route+","+journeyList.get(j).journeyName+"\r\n");					 
					 flag = 1;
					 break;
				 }
			 }			 	
			 if (flag == 0){				 
				     content.append(trainList.get(i).toString()+","+"null"+"\r\n");
			 }
		 }
		 String getContent = content.toString();
		 System.out.println(getContent);
			 FileWriter fw=null;
			 try{  
			     fw=new FileWriter(f); 
			     fw.write(getContent);
			     fw.close(); 
			 }catch(Throwable e){
				 e.printStackTrace();
			 }
			 finally{
			     if(fw!=null)try{
			    	 fw.close();
			    	 } catch(Throwable e){
			     }

			 }

		 
		 File f1=new File(".//Record//driverinfo.txt");
		 StringBuffer content1 = new StringBuffer();
		 int flag1 = 0;
		 for(int i = 0;i<driverList.size();i++){
			 flag1 = 0;
			 for(int j = 0;j<journeyList.size();j++){
				 if(driverList.get(i).driverName.equals(journeyList.get(j).driverName)){
					 content1.append(driverList.get(i).driverName+",work\r\n");
					 flag1 = 1;
					 break;
				 }
			 }	
			 if (flag1 == 0){
				 content1.append(driverList.get(i).driverName+","+"idle"+"\r\n");
			 }
		 }
		 String getContent1 = content1.toString();
		 FileWriter fw1=null;
		 try{  
		     fw1=new FileWriter(f1); 
		     fw1.write(getContent1);
		     fw1.close(); 
		 }catch(Throwable e){
			 e.printStackTrace();
		 }
		 finally{
		     if(fw1!=null)try{
		    	 fw1.close();
		    	 } catch(Throwable e){
		     }

		 }
			BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//Route.txt")));
			String temp2;
			ArrayList<Routeclass> routelist = new ArrayList<Routeclass>();
			temp2 = br.readLine();
			while((temp2 = br.readLine())!=null){			
				String[] temp1 = temp2.split(",");
				routelist.add(new Routeclass(temp1[0],temp1[1],temp1[2],temp1[3]));        
			}
			br.close();
			
		 File f2=new File(".//Record//route.txt");
		 StringBuffer content2 = new StringBuffer();
		 content2.append("ROUTE,STATION,JOURNEY,INTERVAL\r\n");
		 ArrayList<String> occupiedJour = new ArrayList<String>();
		 int flag2 = 0;
		 for(int i = 0;i<routelist.size();i++){
			 if(routelist.get(i).routeName.equals(route)){
				 for(int j = 0;j<journeyList.size();j++){
					 if(routelist.get(i).routeName.equals(journeyList.get(j).route)){
						 for(int m = 0;m<occupiedJour.size();m++){
							 if(occupiedJour.get(m).equals(journeyList.get(j).journeyName)){
								 flag2 = 1;
							 }
						 }
						 if(flag2 == 0){
							 occupiedJour.add(journeyList.get(j).journeyName);
						 }
					 }
				 }
				 routelist.get(i).setJourney(occupiedJour);
				 break;
			 }
		 }
		 
		 for(int i =0;i<routelist.size();i++){
			 content2.append(routelist.get(i).toString()+"\r\n");
		 }
		 
		 String getContent2 = content2.toString();
		 System.out.println(getContent2);
		 
		 FileWriter fw2=null;
		 try{  
		     fw2=new FileWriter(f2); 
		     fw2.write(getContent2);
		     fw2.close(); 
		 }catch(Throwable e){
			 e.printStackTrace();
		 }
		 finally{
		     if(fw2!=null)try{
		    	 fw2.close();
		    	 } catch(Throwable e){
		     }

		 }
	 }
	 }
	 
	
