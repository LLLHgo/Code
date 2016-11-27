package presentation.hotelstaff.controller;

import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public interface HotelstaffViewControllerService {
	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getHotelBasicinfo(String hotelID);
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public List<HotelinfoVO> getHotelBasicinfoList(ClientRequirementVO vo);
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO);
	/**
	 * 获得某酒店某类型的房间信息
	 * @param hotelID
	 * @param roomtype
	 * @return 房间信息
	 */
	public RoominfoVO getRoominfo(String hotelID,String roomtype);
	/**
	 * 获得酒店的房间信息列表
	 * @param hotelID
	 * @return 房间信息列表
	 */
	public List<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 计算打折后的价格
	 * @return 最终价格
	 */
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList,ClientVO vo,double originalPrice);
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param vo
	 * @return 保存是否成功
	 */
	public boolean saveSitemanagerAdd(HotelinfoVO vo);
	
	/**
	 * 将酒店促销策略持久化保存
	 * @param vo
	 * @return 是否将酒店促销策略持久化保存
	 */
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo);
	/**
	 * 获得酒店促销策略信息
	 * @param hotelID
	 * @return 酒店促销策略信息
	 */
	public List<HotelStrategyVO> gethotelStrategy(String hotelID);
	/**
	 * 删除酒店策略
	 * @param hotelID
	 * @param StrategyID
	 * @return 是否删除酒店策略
	 */
	public ResultMessage deletehotelStrategy(HotelStrategyVO hotelStrategy);
	/**
	 * 获得酒店基本信息
	 * @param vo
	 * @return 酒店信息
	 */
	public HotelinfoVO gethotelinfoVO(String hotelID);
	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID);
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID);
	/**
	 * 获得酒店所有订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public List<OrderVO> getALLHotelOrderList(String hotelID,OrderType ALL);
	
	/**
	 * 获得酒店已入住订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public List<OrderVO> getUnexecutedHotelOrderList(String hotelID,OrderType NORMALEXEC);
	
	/**
	 * 获得酒店未入住订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public List<OrderVO> getExecutedHotelOrderList(String hotelID,OrderType NORMALNONEXEC);
	
	/**
	 * 获得酒店异常订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public List<OrderVO> getAbnormalHotelOrderList(String hotelID,OrderType ABNORMALCANCEL);
	
	/**
	 * 将订单状态持久化保存
	 * @param OrderVO
	 * @param state
	 * @return 是否将订单状态持久化保存
	 */
	public ResultMessage updateOrderState(OrderVO vo);
	
	/**
	 * 获得酒店工作人员信息
	 * @param hotelID
	 * @return 获得酒店工作人员信息
	 */
	public HotelstaffBasicinfoVO getHotelstaffBasicinfo(String hotelID);
	/**
	 * 将新密码持久化保存
	 * @param password
	 * @return 是否将新密码持久化保存
	 */
	public ResultMessage setPassword(String hotelID,String password);
	/**
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo);
	/**
	 *  (网站管理人员)请求返回酒店工作人员信息
	 * @param hotelID
	 * @return 酒店工作人员信息
	 */
	public HotelstaffVO returnSitemanagerAccount(String hotelID);
	/**
	 * 登录时检测账号密码
	 * @param hotelID
	 * @param password
	 * @return 账号密码是否匹配
	 */
	public boolean checkAccount(String hotelID,String password);
}