package businesslogic.hoteinfobl;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import Enum.Star;
import businesslogicservice.hotelinfoblservice.Hotelinfoblservice;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Stub implements Hotelinfoblservice{
	
	//酒店名称
	private String name;
	//酒店地址
	private String address;
	//酒店所在商圈
	private String area;
	//酒店电话
	private String tel;
	//酒店所包含的房间类型和数量 arraylist里面每一个元素的表示形式，如“标准双人间2”表示有2个可用的标准双人间
	private ArrayList<String> roomTypeandNum;
	//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
	private Star star;
	//酒店评价
	private ArrayList<String> remark;
	//酒店简介
	private String introduction;
	//酒店ＩＤ
	private String hotelID;
	
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
