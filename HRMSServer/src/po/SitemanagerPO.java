package po;

public class SitemanagerPO {
	// 网站
	private String sitemanagerId;
	//
	private String sitemanagerPhoneNumber;
	//
	private String password;

	public SitemanagerPO(){
		
	}
	public SitemanagerPO(String sitemanagerId,String sitemanagerPhoneNumber,String password){
		this.sitemanagerId=sitemanagerId;
		this.sitemanagerPhoneNumber=sitemanagerPhoneNumber;
		this.password=password;
	}
	public String getSitemanagerId() {
		return sitemanagerId;
	}
	public void setSitemanagerId(String sitemanagerId) {
		this.sitemanagerId = sitemanagerId;
	}
	public String getSitemanagerPhoneNumber() {
		return sitemanagerPhoneNumber;
	}
	public void setSitemanagerPhoneNumber(String sitemanagerPhoneNumber) {
		this.sitemanagerPhoneNumber = sitemanagerPhoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
