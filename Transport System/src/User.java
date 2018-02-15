
public class User {
	private String userName;
	private String pwd;
	
	public User(){
		
	}
	
	public User(String username){
		this.userName = username;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd() {
		return this.pwd;
	}
}