package businesslogicservice.loginblservice;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public class LoginBLService_Stub implements  LoginBLService{
	String userID;
	String password;
	public  LoginBLService_Stub	(String userID,String password){
		this.userID=userID;
		this.password=password;
	}
	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否
	 */
		public char login(String user_id,String password) {
		if(user_id!=null)return 'c';
		else return 'e';
	}

	/**
	 * 注册新用户
	 */
	public ResultMessage addclient(ClientVO vo) {
		return ResultMessage.SUCCESS;
	}
}
