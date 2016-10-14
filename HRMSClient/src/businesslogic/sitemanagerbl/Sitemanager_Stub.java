package businesslogic.sitemanagerbl;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import vo.clientVO.ClientAccountVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class Sitemanager_Stub implements SitemanagerBLService{
	ClientVO clientVO;
	public Sitemanager_Stub(ClientVO clientVO){
		this.clientVO=clientVO;
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
		return new ClientAccountVO();
	}
	/**
	 * 添加网站营销人员
	 * @param marketing
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountUpdate(String marketingId) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 删除网站营销人员账户
	 * @param marketingId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountDelete(String marketingId) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	@Override
	public MarketingVO MarketingAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加酒店
	 * @param hotelinfo
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 管理界面得到酒店工作人员账户信息
	 * @param hotelId
	 * @return 酒店工作人员账户
	 */
	@Override
	public HotelstaffBasicinfoVO HotelStaffAccountFind(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 修改酒店工作人员账户
	 * @param hotelId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage HotelStaffAccountUpdate(String hotelId) {
		// TODO Auto-generated method stub
		return null;
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
