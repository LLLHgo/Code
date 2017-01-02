package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
@Ignore("hotelstaffmanage已经调用真实dataservice，不需要桩")
public class SetPasswordTest {

	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
	
	@Test
	public void test1(){
		//设置密码正确
		assertEquals(ResultMessage.SUCCESS,hManage.setPassword("H0000001", "0000001"));
	}
	
}
