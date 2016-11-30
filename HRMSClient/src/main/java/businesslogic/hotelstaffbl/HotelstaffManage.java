package businesslogic.hotelstaffbl;

import java.rmi.Naming;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import po.HotelstaffPO;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffManage implements HotelstaffBLService{
	//桩测试
	HotelstaffDataService_Stub data = new HotelstaffDataService_Stub();
	HotelstaffPO po;
	HotelstaffVO vo;
	@Override
	public String getBasicinfo(String hotelID) {
		String password = data.findBasicInfo(hotelID).getPassword();
		return password;
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
