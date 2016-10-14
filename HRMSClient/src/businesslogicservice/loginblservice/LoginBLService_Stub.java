package businesslogicservice.loginblservice;

public class LoginBLService_Stub implements  LoginBLService{
	String userID;
	String password;
	public  LoginBLService_Stub	(String userID,String password){
		this.userID=userID;
		this.password=password;
	}
	//验证用户登陆账号
		public boolean login(String user_id,String password) {
		return true;
	}
}
