package presentation.hotelstaff.hotelstaffpersonalinfo.controller;

import Enum.ResultMessage;
import Mock.MockHotelstaffManager;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;

public  class HotelstaffPanelController implements presentation.hotelstaff.hotelstaffpersonalinfo.view.HotelstaffPanelControllerService{

	HotelstaffBLService hotelstaff;
	public HotelstaffPanelController(){
		//hotelstaff = new HotelstaffManage();
		hotelstaff = new MockHotelstaffManager();
	}
	
	@Override
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		return hotelstaff.saveSitemanagerUpdate(vo);
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		return hotelstaff.returnSitemanagerAccount(hotelID);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}

}
