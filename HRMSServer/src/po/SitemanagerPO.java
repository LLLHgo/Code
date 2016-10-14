package po;

public class SitemanagerPO {
	
	//网站管理人员帐号
	private String accountId;
	//网站管理人员电话
	private String phoneNumber;
	//网站管理人员密码
	private String passWord;
	public SitemanagerPO(){
		
	}
	public SitemanagerPO(String accountId,String phoneNumber,String passWord){
		super();
		this.accountId=accountId;
		this.phoneNumber=phoneNumber;
		this.passWord=passWord;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassWord(){
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
