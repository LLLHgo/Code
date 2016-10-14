package businesslogicservice.sitemanagerblservice;

import po.ResultMessage;
import vo.clientVO.ClientAccountVO;
import vo.clientVO.ClientVO;
import vo.sitemanager.SitemanagerVO;
import vo.MarketingVO;
import vo.HotelinfoVO;
import vo.HotelstaffBasicinfoVO;

public interface SitemanagerBLService {
	// 修改客户账户
	public ResultMessage clientAccountUpdate (ClientAccountVO clientId);
	// 删除客户账户
	public ResultMessage clientAccountDelete (String clientId);
	// 管理界面得到客户账户信息
	public ClientVO clientAccountFind (String findInfo);
	
	// 添加网站营销人员
	public ResultMessage MarketingAccountAdd (MarketingVO marketing);
	// 修改网站营销人员账户
	public ResultMessage MarketingAccountUpdate (String marketingId);
	// 删除网站营销人员账户
	public ResultMessage MarketingAccountDelete (String marketingId);
	// 管理界面得到网站营销人员账户信息
	public MarketingVO MarketingAccountFind (String findInfo);
	
	// 添加酒店
	public ResultMessage MarketingAccountAdd (HotelinfoVO hotelinfo);
	// 管理界面得到酒店工作人员账户信息
	public HotelstaffBasicinfoVO HotelStaffAccountFind(String hotelId);
	// 修改酒店工作人员账户
	public ResultMessage HotelStaffAccountUpdate(String hotelId);
	
	// 检查登录的网站管理人员账户密码是否正确
	public boolean checkAccount (SitemanagerVO account);

}
