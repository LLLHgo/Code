package businesslogic.clientbl;

import java.sql.Date;
import java.util.ArrayList;

import Enum.VIPType;

public class Client {
	//用户编号
	private String client_id;
//用户密码
	private String password;
//用户姓名
	private String client_name;
//用户手机号
	private String client_tel;
//用户会员类型
	private VIPType vip_type;
//用户会员等级
	private int vip_level;
//用户生日
	private Date client_birth;
//用户所属企业
	private String client_firm;
//用户信用记录
	private ArrayList<String> creditRecord;
	//用户信用值
		private int credit;
	public Client(){
	}

		public Client(String client_id,String password,String client_name,String client_tel,
		 VIPType vip_type,int vip_level,Date client_birth,String client_firm,int credit,ArrayList<String> creditRecord){
		this.client_id=client_id;
		this.password=password;
		this.client_name=client_name;
		this.client_tel=client_tel;
		this.vip_type=vip_type;
		this.client_birth=client_birth;
		this.vip_level=vip_level;
		this.client_firm=client_firm;
		this.credit=credit;
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
		public VIPType getType(){
			return vip_type;
		}
		public Date getBirth(){
			return client_birth;
		}
		public int getLevel(){
			return vip_level;
		}

		public String getFirm(){
			return client_firm;
		}
		public ArrayList<String> getCreditRecord(){
			return creditRecord;
		}
		public int getCredit(){
			return credit;
		}
		public void setID(String id){
			this.client_id=id;
		}
		public void setPassword(String password){
			this.password=password;
		}
		public void setName(String name){
			this.client_name=name;
		}
		public void setTel(String tel){
			this.client_tel=tel;
		}
		public void setType(VIPType vip_type){
			this.vip_type=vip_type;
		}
		public void setBirth(Date birth){
			this.client_birth=birth;
		}
		public void setLevel(int level){
			this.vip_level=level;
		}

		public void setFirm(String firm){
			this.client_firm=firm;
		}
		public void setcredit(int credit){
			this.credit=credit;
		}
		public void setcreditRecord(ArrayList<String> record){
			this.creditRecord=record;
		}
}
