package businesslogicservice.loginblservice;

import businesslogicservice.clientblservice.ClientBLService;

public class LoginBLService_Driver {
	public void drive(LoginBLService loginBLService){
		boolean login=loginBLService.login("000001", "000000");
		if(login)System.out.println("Login Successfully!");
	}
}
