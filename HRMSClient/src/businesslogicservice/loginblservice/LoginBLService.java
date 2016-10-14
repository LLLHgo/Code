package businesslogicservice.loginblservice;

public interface LoginBLService {
	//验证用户登陆账号
	public boolean login(String user_id,String password);
}
