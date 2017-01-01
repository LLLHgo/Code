package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import businesslogic.hoteinfobl.SortHotelStar;
import businesslogic.hoteinfobl.SortMinPrice;
import businesslogic.hoteinfobl.SortRemarkStar;
import vo.areaVO.AreaVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelinfoBLService_Stub implements HotelinfoBLService{

	HotelinfoVO hotelinfovo;
	RoominfoVO roominfovo;

	public HotelinfoBLService_Stub(){
		roominfovo = new RoominfoVO("H00000001","四人间","413-3",666.6,RoomState.Usable);

		ArrayList<RoominfoVO> roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfovo);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "Brief Introduction";
		String hotelID = "H00000001";
		hotelinfovo = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);

	}

	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getBasicinfo(String hotelID) {
		return hotelinfovo;
	}


	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 获得某酒店某类型的房间信息
	 * @param hotelID
	 * @param roomtype
	 * @return 房间信息
	 */
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return roominfovo;
	}

	/**
	 * 获得酒店的房间信息列表
	 * @param hotelID
	 * @return 房间信息列表
	 */
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoVO> list = new ArrayList<RoominfoVO>();
		list.add(roominfovo);
		return list;
	}

	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param vo
	 * @return 保存是否成功
	 */
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		return true;
	}
	/**
	 * 将酒店促销策略持久化保存
	 * @param vo
	 * @return 是否将酒店促销策略持久化保存
	 */
	public ResultMessage updatehotelStrategy(String hotelID,HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 获得酒店促销策略信息
	 * @param hotelID
	 * @return 酒店促销策略信息
	 */
	public HotelStrategyVO gethotelStrategy(String hotelID) {
		return new HotelStrategyVO();
	}

	/**
	 * 获得酒店基本信息
	 * @param vo
	 * @return 酒店信息
	 */
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		return hotelinfovo;
	}

	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID) {
		RoominfoVO roominfovo = new RoominfoVO("H00000001","四人间","413-3",666.6,RoomState.Usable);
		return roominfovo;
	}
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	@Override
	public boolean updateroominfo(RoominfoVO vo, String hotelID) {
		return true;
	}

//	/**
//	 * 获得酒店订单列表
//	 * @param hotelID
//	 * @return 酒店订单列表
//	 */
//	public List<OrderVO> gethotelOrderList(String hotelID) {
//		//TODO
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		return list;
//	}

//	/**
//	 * 将订单状态持久化保存
//	 * @param orderID
//	 * @param state
//	 * @return 是否将订单状态持久化保存
//	 */
//	public ResultMessage updateOrderState(String orderID, OrderType orderType) {
//		return ResultMessage.SUCCESS;
//	}

	/**
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		if(sitemanagerAddVO.getName().equals("LLLH酒店")){
			return ResultMessage.DUPLICATENAME;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getArea() {
		//TODO
		String[] areas={"新街口商圈","山西路商圈","珠江路商圈","江东门商圈","江北商圈","卡子门商圈","栖霞区商圈"};
		return areas;
	}

	@Override
	public boolean addArea(String area) {
		if(area==null||area.equals("")){
			return false;
		}
		String[] areas={"新街口商圈","山西路商圈","珠江路商圈","江东门商圈","江北商圈","卡子门商圈","栖霞区商圈"};
		int flag = 0;
		for(int i=0;i<areas.length;i++){
			if(area.equals(areas[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		return true;
	}

	@Override
	public String[] getRoomType() {
		String[] types = {"标准间","大床房","总统套房"};
		return types;
	}

	@Override
	public boolean addRoomType(String type) {
		if(type.equals("标准间")||type.equals("大床房")||type.equals("总统套房"))
		return false;
		return true;
	}

	@Override
	public List<AreaVO> getAreaHotels() {

		ArrayList<AreaVO> areas = new ArrayList<AreaVO>();

		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("HanTing");
		list1.add("RuJia");
		list1.add("LvZhou");
		AreaVO vo1 = new AreaVO("新街口商圈",list1);

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("LLLH酒店");
		list2.add("王二狗酒店");
		AreaVO vo2 = new AreaVO("山西路商圈",list1);

		areas.add(vo1);
		areas.add(vo2);
		return areas;
	}

	@Override
	public ArrayList<String> getAvailableRooms(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setEvaluate(int star, String remark, String clientID,String hotelID) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addroominfo(RoominfoVO vo) {
		return false;
	}

	@Override
	public boolean deleteroom(String hotelID, String roomID) {
		return false;
	}

	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoHotelStar(ArrayList<HotelinfoVO> list) {
		
		Collections.sort(list,new SortHotelStar());
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getHotelID());
			
		}
		return list;
	}

	@Override
	public ArrayList<HotelinfoVO> getBasicinfoList(String area, String hotelname, int hotelstar, String roomType) {
		if(!area.equals("山西路商圈")){
			return null;
		}else{
			if(hotelname == null&&hotelstar==0&&roomType == null){
				HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
						new ArrayList<String>(),"Brief Introduction","H00000001");
				ArrayList<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
				list.add(hotelinfoVO1);
				return list;
			}
		}
		return null;
	}

	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoRemarkStar(ArrayList<HotelinfoVO> list) {
		// TODO Auto-generated method stub
		Collections.sort(list,new SortRemarkStar());

		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getHotelID());
			
		}
		return list;
	}

	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoMinPrice(ArrayList<HotelinfoVO> list) {
		Collections.sort(list,new SortMinPrice());
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getHotelID());
			
		}
		return list;
	}



//	/**
//	 * 删除酒店策略
//	 * @param hotelID
//	 * @param StrategyID
//	 * @return 是否删除酒店策略
//	 */
//	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {
//		return ResultMessage.SUCCESS;
//	}
}
