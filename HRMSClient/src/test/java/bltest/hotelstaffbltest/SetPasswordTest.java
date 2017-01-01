package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;

public class SetPasswordTest {

	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
	
	@Test
	public void test1(){
		//设置密码正确
		assertEquals(ResultMessage.SUCCESS,hManage.setPassword("H0000001", "0000001"));
	}
	
}
