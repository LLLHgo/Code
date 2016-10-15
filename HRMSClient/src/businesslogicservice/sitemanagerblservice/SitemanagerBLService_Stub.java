package businesslogicservice.sitemanagerblservice;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import vo.clientVO.ClientAccountVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;
import Enum.VIPType;

public class SitemanagerBLService_Stub implements SitemanagerBLService{
	MarketingVO marketingVO;
	public SitemanagerBLService_Stub(MarketingVO marketingVO){
		this.marketingVO=marketingVO;
	}
	/**
	 * 修改客户账户
	 * @param clientId
	 * @return 修改客户账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage clientAccountUpdate(ClientAccountVO clientId) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
	 * 删除客户账户
	 * @param clientId
	 * @return 删除客户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage clientAccountDelete(String clientId) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
     * 管理界面得到客户账户信息
     * @param findInfo
     * @return 该客户账户
     */
	@Override
	public ClientAccountVO clientAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return new ClientAccountVO("C00000009","Kerry","17999982876",VIPType.ENTERPRISEVIP,2,null,"SAP");
	}
	/**
	 * 添加网站营销人员
	 * @param marketing
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountUpdate(String marketingId) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
	 * 删除网站营销人员账户
	 * @param marketingId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountDelete(String marketingId) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	@Override
	public MarketingVO MarketingAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return new MarketingVO("Lily","m123456","M000000011","17719239008");
	}
	/**
	 * 添加酒店
	 * @param hotelinfo
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}
	/**
	 * 管理界面得到酒店工作人员账户信息
	 * @param hotelId
	 * @return 酒店工作人员账户
	 */
	@Override
	public HotelstaffVO HotelStaffAccountFind(String hotelId) {
		// TODO Auto-generated method stub
		return new HotelstaffVO("H00000010","123456","025-12345678");
	}
	/**
	 * 修改酒店工作人员账户
	 * @param hotelId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage HotelStaffAccountUpdate(String hotelId) {
		// TODO Auto-generated method stub
		return ResultMessage.False;
	}

	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	@Override
	public boolean checkAccount(SitemanagerVO account) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
