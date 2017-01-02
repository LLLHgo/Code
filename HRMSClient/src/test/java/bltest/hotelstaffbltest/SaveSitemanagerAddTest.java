package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
import vo.hotelstaffVO.HotelstaffVO;

@Ignore("hotelstaffmanage已经调用真实dataservice，不需要桩")
public class SaveSitemanagerAddTest {
	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
//
//	public GetBasicinfoTest(){
//		hManage = new HotelstaffManage();
//	}

	@Test
	public void test1(){
		//获得正确的密码
		HotelstaffVO vo = new HotelstaffVO();
		vo.setHotelID("H00000002");
		vo.setTel("12345678");
		vo.setPassword("111111");
		assertEquals(ResultMessage.SUCCESS,hManage.saveSitemanagerUpdate(vo));
		vo.setHotelID("H00000001");
		assertEquals(ResultMessage.FAIL,hManage.saveSitemanagerUpdate(vo));
		
	}
}