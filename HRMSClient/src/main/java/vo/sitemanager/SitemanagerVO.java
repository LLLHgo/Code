package vo.sitemanager;

import javax.swing.ImageIcon;

public class SitemanagerVO {
	    // 网站管理人员帐号
		private String sitemanagerId;
		// 网站管理人员手机号
		private String servicePhoneNumber;
		// 网站管理人员密码
		private String password;
		// 网站管理人员头像
		private ImageIcon userImage;

		public SitemanagerVO(String sitemanagerId,String servicePhoneNumber,String password,ImageIcon image){
			this.sitemanagerId=sitemanagerId;
			this.servicePhoneNumber=servicePhoneNumber;
			this.password=password;
			this.userImage=image;
		}
		public String getSitemanagerId() {
			return sitemanagerId;
		}
		public void setSitemanagerId(String sitemanagerId) {
			this.sitemanagerId = sitemanagerId;
		}
		public String getSitemanagerPhoneNumber() {
			return servicePhoneNumber;
		}
		public void setSitemanagerPhoneNumber(String sitemanagerPhoneNumber) {
			this.servicePhoneNumber = sitemanagerPhoneNumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public ImageIcon getUserImage() {
			return userImage;
		}
		public void setUserImage(ImageIcon userImage) {
			this.userImage = userImage;
		}
}
