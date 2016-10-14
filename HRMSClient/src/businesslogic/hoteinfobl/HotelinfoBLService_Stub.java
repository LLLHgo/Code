package businesslogic.hoteinfobl;

import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.Hotelinfoblservice;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Stub implements Hotelinfoblservice{

	public HotelinfoBLService_Stub(){
		
	}
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		return null;
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {

		return null;
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, OrderVO vo, double originalPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
