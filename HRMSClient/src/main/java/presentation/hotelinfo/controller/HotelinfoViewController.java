package presentation.hotelinfo.controller;

import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogic.orderbl.OrderManage;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import presentation.hotelinfo.view.HotelinfoViewControllerService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.HotelOrderVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoViewController implements HotelinfoViewControllerService{

	HotelinfoBLService hotelinfo;
	StrategyBLService strategy;
	OrderBLService order;

	public HotelinfoViewController(){
		hotelinfo = new HotelinfoManage();
		strategy = new StrategyManage();
		order = new OrderManage();
	}

	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		return hotelinfo.getBasicinfo(hotelID);
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
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
	public ResultMessage updatehotelStrategy(String hotelID, HotelStrategyVO vo) {
		boolean result =  strategy.updateHotelStrategy(hotelID,vo);
		if(result == true){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return strategy.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {
		boolean result = strategy.deletehotelStrategy(hotelStrategy);
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
	public ResultMessage updateroominfo(HotelinfoVO vo) {
		return hotelinfo.updateroominfo(vo);
	}

	@Override
	public List<OrderVO> gethotelOrderList(String hotelID) {
		return order.findUserOrderList(hotelID);
	}

	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
		return order.saveOrder(vo);
	}

}
