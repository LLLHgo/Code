package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import vo.areaVO.AreaVO;

public class GetAreaHotels {

	HotelinfoBLService hManage ;
	AreaVO vo;
	
	@Before
	public void init(){
	hManage = new HotelinfoBLService_Stub();
	ArrayList<String> hotels = new ArrayList<String>();
	hotels.add("HanTing");
	vo = new AreaVO("山西路商圈",hotels);
	}
	
	@Test
	public void test1(){
		assertEquals("新街口商圈",hManage.getAreaHotels().get(0).getName());
		assertEquals("HanTing",hManage.getAreaHotels().get(0).getHotels().get(0));
	}
}
