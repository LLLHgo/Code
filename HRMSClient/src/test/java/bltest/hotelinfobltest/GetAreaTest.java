package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;

public class GetAreaTest {

	HotelinfoBLService hotelinfo = new HotelinfoBLService_Stub();
	
	String[] areas = {"新街口商圈","山西路商圈","珠江路商圈","江东门商圈","江北商圈","卡子门商圈","栖霞区商圈"};
	@SuppressWarnings("deprecation")
	@Test
	public void test1(){
		assertEquals(areas,hotelinfo.getArea());
	}
}
