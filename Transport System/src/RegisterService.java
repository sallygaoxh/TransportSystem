import java.io.*;

public class RegisterService{
	private static final String FILE_PATH = ".//Record//user.txt";
	int valid;
	public int register(User user) {

	    valid = 1;
		int result = 0;
		try {
			BufferedReader br= new BufferedReader(new FileReader(FILE_PATH));
			String s = "";

			while((s = br.readLine())!=null){
				String[] temp = s.split(",");
				if(temp[0].equals(user.getUserName())){
					valid = 0;
					break;
				}
			}
			br.close();
			
			if(valid==1){
				String msg = user.getUserName() + "," + user.getPwd()+"\r\n";
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(FILE_PATH,true));
					bw.write(msg);
					bw.flush();
			    }
			    catch (IOException ex) {
			    	ex.printStackTrace();
			    } finally  {
			    	try{
			    		if(bw != null)
			    			bw.close();	
			    	}catch(IOException e) {
			    		e.printStackTrace();
			    	}				
			    }
				result = 1;
			}
			else 
				result = 0;
		}catch (Exception e) {
	    	e.printStackTrace();
	    }finally{
	    	return result;
	    }
	}
	
	public int getValid (){
		return valid;
	}
}