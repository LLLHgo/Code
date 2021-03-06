package businesslogicservice.hotelstaffblservice;

import java.util.ArrayList;

import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
/**
 *
 * @author liuyu
 *
 */
public class HotelstaffBLService_Stub implements HotelstaffBLService{

	HotelstaffVO hotelstaffvo ;
	OrderVO hotelordervo;
	RoominfoVO roominfovo;
	HotelinfoVO hotelinfovo;

	public HotelstaffBLService_Stub(){
		hotelstaffvo = new HotelstaffVO("H00000001","000000","025-12345678");
		roominfovo = new RoominfoVO("H00000001","四人间","413-3",666.6,RoomState.Usable);
		ArrayList<RoominfoVO> roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfovo);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000001";
		hotelinfovo = new HotelinfoVO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);


	}
	/**
	 * 获得酒店工作人员信息
	 * @param hotelID
	 * @return 获得酒店工作人员信息
	 */
	public String getBasicinfo(String hotelID) {
		return hotelstaffvo.getPassword();
	}

	/**
	 * 将新密码持久化保存
	 * @param password
	 * @return 是否将新密码持久化保存
	 */
	public ResultMessage setPassword(String hotelD,String password) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		if(vo.getHotelID().equals("H00000002"))
		return ResultMessage.SUCCESS;
		return ResultMessage.FAIL;
	}

	/**
	 *  (网站管理人员)请求返回酒店工作人员信息
	 * @param hotelID
	 * @return 酒店工作人员信息
	 */
	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		return hotelstaffvo;
	}
	/**
	 * 登录时检测账号密码
	 * @param hotelID
	 * @param password
	 * @return 账号密码是否匹配
	 */
	@Override
	public boolean checkAccount(String hotelID, String password) {
		if(hotelID.equals("H00000001")&&password.equals("000000")){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public ResultMessage saveSitemanagerAdd(HotelstaffVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNewAddHotelID() {
		// TODO Auto-generated method stub
		return null;
	}
}
