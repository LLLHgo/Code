package businesslogicservice.sitemanagerblservice;

import vo.clientVO.ClientAccountVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.sitemanager.SitemanagerVO;
import vo.MarketingVO;
import Enum.ResultMessage;

public interface SitemanagerBLService {
	/**
	 * 修改客户账户
	 * @param clientId
	 * @return 修改客户账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage clientAccountUpdate (ClientAccountVO clientId);
	
	/**
	 * 删除客户账户
	 * @param clientId
	 * @return 删除客户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage clientAccountDelete (String clientId);
	
    /**
     * 管理界面得到客户账户信息
     * @param findInfo
     * @return 该客户账户
     */
	public ClientVO clientAccountFind (String findInfo);
	
	/**
	 * 添加网站营销人员
	 * @param marketing
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountAdd (MarketingVO marketing);
	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountUpdate (String marketingId);
	
	/**
	 * 删除网站营销人员账户
	 * @param marketingId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountDelete (String marketingId);
	
	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	public MarketingVO MarketingAccountFind (String findInfo);
	
	/**
	 * 添加酒店
	 * @param hotelinfo
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountAdd (HotelinfoVO hotelinfo);
	
	/**
	 * 管理界面得到酒店工作人员账户信息
	 * @param hotelId
	 * @return 酒店工作人员账户
	 */
	public HotelstaffBasicinfoVO HotelStaffAccountFind(String hotelId);
	
	/**
	 * 修改酒店工作人员账户
	 * @param hotelId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage HotelStaffAccountUpdate(String hotelId);
	
	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	public boolean checkAccount (SitemanagerVO account);

}
