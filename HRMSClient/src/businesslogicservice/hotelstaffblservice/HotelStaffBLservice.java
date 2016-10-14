package businesslogicservice.hotelstaffblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.HotelOrderVO;
import vo.HotelStrategyVO;
import vo.HotelinfoVO;
import vo.HotelstaffBasicinfoVO;
import vo.HotelstaffVO;
import vo.RoominfoVO;

public interface HotelStaffBLservice {
	
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID);
	public ResultMessage setPassword(String password);
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo);
	public HotelStrategyVO gethotelStrategy(String hotelID);
	public HotelinfoVO gethotelinfoVO(HotelinfoVO vo);
	public RoominfoVO getroominfo(String roomID);
	public ResultMessage updateroominfo(HotelinfoVO vo);
	public List<HotelOrderVO> gethotelOrderList(String hotelID);
	public ResultMessage updateOrderState(String orderID,int state);
	public boolean saveSitemanagerUpdate(HotelstaffVO vo);
	public HotelstaffVO returnSitemanagerAccount(String hotelID);
	public boolean checkAccount(String hotelID,String password);
}
