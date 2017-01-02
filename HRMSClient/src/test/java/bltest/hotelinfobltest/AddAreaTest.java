package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.hoteinfobl.HotelinfoManage;


@Ignore("hotelinfomanage已经调用真实dataservice，不需要桩")

public class AddAreaTest {

	HotelinfoManage hotelinfo = new HotelinfoManage();

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
