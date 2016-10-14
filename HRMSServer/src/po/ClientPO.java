package src.po;

import java.io.File;
import java.io.Serializable;

public class ClientPO implements Serializable{
	//用户编号
		private String client_id;
	//用户密码
		private String password;
	//用户姓名
		private String client_name;
	//用户手机号
		private String client_tel;
	//用户会员类型
		private String vip_type;
	//用户会员等级
		private int vip_level;
	//用户生日
		private String client_birth;
	//用户所属企业
		private String client_firm;
	//用户信用记录
		private File creditRecord;
		
		public ClientPO(){
	}

		public ClientPO(String client_id,String password,String client_name,String client_tel,
		 String vip_type,int vip_level,String client_birth,String client_firm,File creditRecord){
		this.client_id=client_id;
		this.password=password;
		this.client_name=client_name;
		this.client_tel=client_tel;
		this.vip_type=vip_type;
		this.client_birth=client_birth;
		this.vip_level=vip_level;
		this.client_firm=client_firm;
		this.creditRecord=creditRecord;
	}
		public String getID(){
			return client_id;
		}
		public String getPassword(){
			return password;
		}
		public String getName(){
			return client_name;
		}
		public String getTel(){
			return client_tel;
		}
		public String getType(){
			return vip_type;
		}
		public String getBirth(){
			return client_birth;
		}
		public int getLevel(){
			return vip_level;
		}
		public String getFirm(){
			return client_firm;
		}
		public File getCreditRecord(){
			return creditRecord;
		}
}
