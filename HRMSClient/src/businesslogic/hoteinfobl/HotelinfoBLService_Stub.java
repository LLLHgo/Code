package businesslogic.hoteinfobl;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import businesslogicservice.hotelinfoblservice.Hotelinfoblservice;
import vo.clientVO.ClientVO;
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
	
	public HotelinfoBLService_Stub(String name,String address,String area,
			String tel,ArrayList<String> roomTypeandNum,Star star,ArrayList<String> remark,
			String introduciton,String hotelID){
		this.name = name;
		this.address = address;
		this.area = area;
		this.tel = tel;
		this.roomTypeandNum = roomTypeandNum;
		this.star = star;
		this.remark = remark;
		this.introduction = introduciton;
		this.hotelID = hotelID;
	}
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		return new HotelinfoVO(name,address,area,tel,roomTypeandNum,star,remark,
				introduction,hotelID);
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
		//TODO
		List<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
		ArrayList<String> roomTypeandNum = new ArrayList<String>();
		roomTypeandNum.add("标准双人间4");
		roomTypeandNum.add("大床房4");
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("萌萌哒");
		remark.add("好评！");
		list.add(new HotelinfoVO("蜜糖酒店","甜甜街10号","萌萌区",
			"12345678",new ArrayList<String>(),Star.FIVE,new ArrayList<String>(),
		"我也不知道简介是什么","0001"));
		return list;
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		if(vo.getHotelID()=="h00000001")
			return ResultMessage.True;
		else
			return ResultMessage.False;
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		//TODO
		return new RoominfoVO(roomtype,"8301",300,RoomState.Usable);
	}

	
	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		if(hotelID.equals("h00000001")){
			List<RoominfoVO> list = new ArrayList<RoominfoVO>();
			list.add(new RoominfoVO("标准双人间","8301",300,RoomState.Unusable));
			list.add(new RoominfoVO("标准双人间","8302",300,RoomState.Usable));
			list.add(new RoominfoVO("标准双人间","8303",300,RoomState.Usable));
			return list;
		}else{
			return null;
		}
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		return 270;
	}

	@Override
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		if(vo.getHotelID().equals("h00000001")){
			return false;
		}else{
			return true;
		}
	}

}
