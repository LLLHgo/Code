package Mock;

import java.io.File;
import java.sql.Date;

import Enum.VIPType;

public class MockClient {
	//用户编号
		 String client_id;
	//用户密码
		 String password;
	//用户姓名
		 String client_name;
	//用户手机号
		 String client_tel;
	//用户会员类型
		 VIPType vip_type;
	//用户会员等级
		 int vip_level;
	//用户生日
		 Date client_birth;
	//用户所属企业
		 String client_firm;
	//用户信用记录
		File creditRecord;
		public MockClient(){

		}
		public MockClient(String id,String password){
			this.client_id=id;
			this.password=password;
		}
		public MockClient(String id,VIPType v,Date client_birth){
			this.client_id=id;
			this.vip_type=v;
			this.client_birth=client_birth;
		}
		public MockClient(String id,VIPType v,String client_firm){
			this.client_id=id;
			this.vip_type=v;
			this.client_firm=client_firm;
		}
		public MockClient(String id,String name,String tel){
			this.client_id=id;
			this.client_name=name;
			this.client_tel=tel;
		}
		public MockClient(String id,File c){
			this.client_id=id;
			this.creditRecord=c;
		}
}
