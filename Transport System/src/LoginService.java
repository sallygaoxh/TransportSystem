import java.io.*;
public class LoginService {
	private static final String FILE_PATH = ".//Record//user.txt";
	public boolean login(User user) {

		int result=0;
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(FILE_PATH));
			String s = "";

			while((s = br.readLine())!=null){
				String[] temp = s.split(",");
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