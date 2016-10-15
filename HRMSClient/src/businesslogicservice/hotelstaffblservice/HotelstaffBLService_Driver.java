package businesslogicservice.hotelstaffblservice;

import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelstaffBLService_Driver {

	public void drive(HotelstaffBLService hotelstaffBLService){
		hotelstaffBLService.checkAccount("H00000000", "000000");
		hotelstaffBLService.getBasicinfo("H00000000");
		hotelstaffBLService.gethotelinfoVO(new HotelinfoVO());
		hotelstaffBLService.gethotelOrderList("H00000000");
		hotelstaffBLService.gethotelStrategy("H00000000");
		hotelstaffBLService.getroominfo("413-2");
		hotelstaffBLService.returnSitemanagerAccount("H00000000");
		hotelstaffBLService.saveSitemanagerUpdate(new HotelstaffVO());
		hotelstaffBLService.setPassword("000000");
		hotelstaffBLService.updatehotelStrategy(new HotelStrategyVO());
		//OrderState可以变成一个enum
		hotelstaffBLService.updateOrderState("H00000000", 0);
		hotelstaffBLService.updateroominfo(new HotelinfoVO());
	}
}
