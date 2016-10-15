package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import po.HotelinfoPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Stub implements HotelinfoBLService{
	
	HotelinfoVO hotelinfovo;
	RoominfoVO roominfovo;
	
	public HotelinfoBLService_Stub(){
		roominfovo = new RoominfoVO("四人间","413-3",666.6,RoomState.Usable);
		
		ArrayList<RoominfoVO> roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfovo);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000000";
		hotelinfovo = new HotelinfoVO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);

	}
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		return hotelinfovo;
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
		ArrayList<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfovo);
		return list;
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return roominfovo;
	}

	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoVO> list = new ArrayList<RoominfoVO>();
		list.add(roominfovo);
		return list;
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		return 666;
	}

	@Override
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		return true;
	}

}
