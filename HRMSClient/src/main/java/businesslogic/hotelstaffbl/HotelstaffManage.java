package businesslogic.hotelstaffbl;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffManage implements HotelstaffBLService{

	
	@Override
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID) {
		
		return null;
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
