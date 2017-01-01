package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;

public class GetBasicinfoTest {
	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
//	
//	public GetBasicinfoTest(){
//		hManage = new HotelstaffManage();
//	}
	
	@Test
	public void test1(){
		//获得正确的密码
		assertEquals("000000",hManage.getBasicinfo("H00000001"));
	}
}
