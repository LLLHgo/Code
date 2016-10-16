package businesslogicservice.hotelstaffblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.HotelOrderVO;
import vo.strategyVO.HotelStrategyVO;
/**
 *
 * @author liuyu
 *
 */
public class HotelstaffBLService_Stub implements HotelstaffBLService{
    //
	HotelstaffVO hotelstaffvo ;
	HotelOrderVO hotelordervo;
	RoominfoVO roominfovo;
	HotelinfoVO hotelinfovo;

	public HotelstaffBLService_Stub(){
		hotelstaffvo = new HotelstaffVO("H00000000","000000","025-12345678");

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

	//得到酒店工作人员基本信息
	@Override
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID) {
		return new HotelstaffBasicinfoVO(hotelstaffvo.getPassword());
	}

	//得到密码
	@Override
	public ResultMessage setPassword(String password) {
		return ResultMessage.SUCCESS;
	}

	//更新酒店促销策略
	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	//查询酒店促销策略
	@Override
	public HotelStrategyVO gethotelStrategy(String hotelID) {
		//TODO
		return new HotelStrategyVO();
	}

	//查询酒店信息
	@Override
	public HotelinfoVO gethotelinfoVO(HotelinfoVO vo) {
		return hotelinfovo;
	}

	//查询房间信息
	@Override
	public RoominfoVO getroominfo(String roomID) {
		RoominfoVO roominfovo = new RoominfoVO("四人间","413-3",666.6,RoomState.Usable);
		return roominfovo;
	}

	//更新房间信息
	@Override
	public ResultMessage updateroominfo(HotelinfoVO vo) {
		return ResultMessage.SUCCESS;
	}

	//得到某酒店的订单列表
	@Override
	public List<HotelOrderVO> gethotelOrderList(String hotelID) {
		//TODO
		ArrayList<HotelOrderVO> list = new ArrayList<HotelOrderVO>();
		return list;
	}

	//更新订单状态
	@Override
	public ResultMessage updateOrderState(String orderID, int state) {
		return ResultMessage.SUCCESS;
	}

	//保存网站管理人员的更新
	@Override
	public boolean saveSitemanagerUpdate(HotelstaffVO vo) {
		return true;
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		return hotelstaffvo;
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return true;
	}



	@Override
	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
