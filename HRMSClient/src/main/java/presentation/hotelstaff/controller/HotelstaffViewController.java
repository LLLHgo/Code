package presentation.hotelstaff.controller;

import java.util.List;

import javax.swing.JPanel;

import Enum.OrderType;
import Enum.ResultMessage;
import Mock.MockHotelinfoManage;
import Mock.MockHotelstaffManager;
import Mock.MockOrderManage;
import Mock.MockStrategyManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelstaffViewController implements HotelstaffViewControllerService{
	
	private String hotelID;
	private JPanel view;
//	HotelinfoBLService hotelinfo;
//	StrategyBLService strategy;
//	OrderBLService order;
//	HotelstaffBLService hotelstaff;
	MockHotelinfoManage hotelinfo;
	MockStrategyManage strategy;
	MockOrderManage order;
	MockHotelstaffManager hotelstaff;
	
	public HotelstaffViewController(){
		new HotelstaffViewController("H00000001");
	}


	public HotelstaffViewController(String hotelID){
		this.hotelID = hotelID;
//		hotelinfo = new HotelinfoManage();
//		strategy = new StrategyManage();
//		order = new OrderManage();
//		hotelstaff = new HotelstaffManage();
		hotelinfo = new MockHotelinfoManage();
		strategy = new MockStrategyManage();
		order = new MockOrderManage();
		hotelstaff = new MockHotelstaffManager();
	}

	public void setView(JPanel view){
		this.view = view;
	}
	
	@Override
	public HotelinfoVO getHotelBasicinfo(String hotelID) {
		return hotelinfo.getBasicinfo(hotelID);
	}

	@Override
	public List<HotelinfoVO> getHotelBasicinfoList(ClientRequirementVO vo) {
		return hotelinfo.getBasicinfoList(vo);
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		return hotelinfo.updateBassicinfo(VO);
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return hotelinfo.getRoominfo(hotelID, roomtype);
	}

	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		return hotelinfo.getRoominfoList(hotelID);
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		return hotelinfo.calculatePrice(hotelStrategylist, marketingStrategyList, vo, originalPrice);
	}

	@Override
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		return hotelinfo.saveSitemanagerAdd(vo);
	}

	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		 if(strategy.updateHotelStrategy(vo)==true){
			 return ResultMessage.SUCCESS;
		 }
		 return ResultMessage.FAIL;
	}

	@Override
	public List<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return strategy.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage deletehotelStrategy(HotelStrategyVO hotelStrategy) {
		boolean result = strategy.deleteHotelStrategy(hotelStrategy);
		if(result == true){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		return hotelinfo.gethotelinfoVO(hotelID);
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		return hotelinfo.getroominfo(hotelID, roomID);
	}

	@Override
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID) {
		if(hotelinfo.updateroominfo(vo,hotelID)==true){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}


	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
		return order.saveOrder(vo);
	}

	@Override
	public List<OrderVO> getALLHotelOrderList(String hotelID, OrderType ALL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUnexecutedHotelOrderList(String hotelID, OrderType NORMALEXEC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getExecutedHotelOrderList(String hotelID, OrderType NORMALNONEXEC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HotelstaffBasicinfoVO getHotelstaffBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	@Override
	public boolean saveSitemanagerUpdate(HotelstaffVO vo) {
		return hotelstaff.saveSitemanagerUpdate(vo);
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		return hotelstaff.returnSitemanagerAccount(hotelID);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}

	
	
}
