import java.io.BufferedReader;
import java.io.FileReader;
public class LogDService {
	private static final String FILE_PATH = ".//Record//driver.txt";
	public boolean login(User user) {

		int result=0;
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(FILE_PATH));
			String s = "";

			while((s = br.readLine())!=null){
				String[] temp = s.split(",");
				System.out.println("Username in file:"+temp[0]+" password in file: "+temp[1]);
				if(temp[0].equals(user.getUserName()) && temp[1].equals(user.getPwd())){
					
					result = 1;
					break;
				}
			}
			br.close();
			
			if(result==1){
				return true;
			}else
				return false;
	    }
	    catch (Exception ex) {
	    	return false;
	    }
		
	}
}