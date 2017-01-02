package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;


import businesslogic.hoteinfobl.HotelinfoManage;


@Ignore("hotelinfomanage已经调用真实dataservice，不需要桩")
public class GetAreaTest {

	HotelinfoManage hotelinfo = new HotelinfoManage();
	
	String[] areas = {"新街口商圈","山西路商圈","珠江路商圈","江东门商圈","江北商圈","卡子门商圈","栖霞区商圈"};
	@SuppressWarnings("deprecation")
	@Test
	public void test1(){
		assertEquals(areas,hotelinfo.getArea());
	}
}
