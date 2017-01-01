package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;

public class AddAreaTest {

	HotelinfoBLService hotelinfo = new HotelinfoBLService_Stub();

	@Test
	public void test1(){
		//重复，不添加
		assertEquals(false,hotelinfo.addArea("新街口商圈"));
	}
	
	@Test
	public void test2(){
		//无内容，不添加
		assertEquals(false,hotelinfo.addArea(""));
	}

	
	@Test
	public void test3(){
		//无内容，不添加
		assertEquals(false,hotelinfo.addArea(null));
	}
}
