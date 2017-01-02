package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
import vo.hotelstaffVO.HotelstaffVO;

@Ignore("hotelstaffmanage已经调用真实dataservice，不需要桩")
public class ReturnSitemanagerAccountTest {
	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
//
//	public GetBasicinfoTest(){
//		hManage = new HotelstaffManage();
//	}

	@Test
	public void test1(){
		HotelstaffVO vo = new HotelstaffVO();
		vo.setHotelID("H00000002");
		vo.setTel("12345678");
		vo.setPassword("111111");
		assertEquals("111111",hManage.returnSitemanagerAccount("H00000002").getPassword());
		
	}
}
