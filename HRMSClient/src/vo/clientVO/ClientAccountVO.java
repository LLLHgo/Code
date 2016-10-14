package vo.clientVO;

import Enum.VIPType;

public class ClientAccountVO {
	//用户编号
	private String client_id;
	//用户姓名
	private String client_name;
	//用户手机号
	private String client_tel;
	//用户会员类型
	private VIPType vip_type;
	//用户会员等级
	private int vip_level;
	//用户生日
	private String client_birth;
	//用户所属企业
	private String client_firm;

	public ClientAccountVO(){
	}
	public ClientAccountVO(String client_id,String client_name,String client_tel,
			VIPType vip_type,int vip_level,String client_birth,String client_firm){
		this.client_id=client_id;
		this.client_name=client_name;
		this.client_tel=client_tel;
		this.vip_type=vip_type;
		this.client_birth=client_birth;
		this.vip_level=vip_level;
		this.client_firm=client_firm;
	}
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_tel() {
		return client_tel;
	}
	public void setClient_tel(String client_tel) {
		this.client_tel = client_tel;
	}
	public VIPType getVip_type() {
		return vip_type;
	}
	public void setVip_type(VIPType vip_type) {
		this.vip_type = vip_type;
	}
	public int getVip_level() {
		return vip_level;
	}
	public void setVip_level(int vip_level) {
		this.vip_level = vip_level;
	}
	public String getClient_birth() {
		return client_birth;
	}
	public void setClient_birth(String client_birth) {
		this.client_birth = client_birth;
	}
	public String getClient_firm() {
		return client_firm;
	}
	public void setClient_firm(String client_firm) {
		this.client_firm = client_firm;
	}
}
