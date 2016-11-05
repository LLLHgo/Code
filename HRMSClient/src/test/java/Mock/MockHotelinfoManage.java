package Mock;

import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.Star;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.HotelOrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class MockHotelinfoManage {
	
	public MockHotelinfoManage(){
		
	}
	
	public HotelinfoVO getBasicinfo(String hotelID) {
		if(hotelID.equals("H00000001")){
			return new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		}
		else if(hotelID.equals("H00000002")){
			return new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
					new ArrayList<String>(),"Brief Introduction","H00000002");
		}
		else if(hotelID.equals("H00000003")){
			return 	new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
					new ArrayList<String>(),"Brief Introduction","H00000003");
		}
		else {
			return null;
		}
	}


	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
		HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		HotelinfoVO hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		HotelinfoVO hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		List<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfoVO1);
		list.add(hotelinfoVO2);
		list.add(hotelinfoVO3);
		return list;
	}


	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		if(vo.getHotelID().equals("H00000001")||vo.getHotelID().equals("H00000002")
				||vo.getHotelID().equals("H00000003")){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}


	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return null;
	}


	public List<RoominfoVO> getRoominfoList(String hotelID) {
		return null;
	}


	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		
		return 0;
	}

	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		if(vo.getHotelID().equals("H00000001")||vo.getHotelID().equals("H00000002")
				||vo.getHotelID().equals("H00000003")){
			return true;
		}
		return false;
	}


	public ResultMessage updatehotelStrategy(String hotelID, HotelStrategyVO vo) {
		
		return null;
	}


	public HotelStrategyVO gethotelStrategy(String hotelID) {
		
		return null;
	}


	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {
		
		return null;
	}


	public HotelinfoVO gethotelinfoVO(String hotelID) {

		return null;
	}


	public RoominfoVO getroominfo(String hotelID, String roomID) {
	
		return null;
	}


	public ResultMessage updateroominfo(HotelinfoVO vo) {

		return null;
	}


	public List<HotelOrderVO> gethotelOrderList(String hotelID) {

		return null;
	}


	public ResultMessage updateOrderState(String orderID, OrderType orderType) {
	
		return null;
	}
}
