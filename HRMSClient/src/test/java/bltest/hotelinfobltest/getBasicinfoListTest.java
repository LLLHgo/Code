package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import Enum.Star;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;


@Ignore("hotelinfomanage已经调用真实dataservice，不需要桩")

public class getBasicinfoListTest {
	HotelinfoManage hotelinfo = new HotelinfoManage();
	HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000001");
	String area = "山西路商圈";
	@Test
	public void test1(){
		assertEquals(hotelinfoVO1.getAddress(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getAddress());	
		assertEquals(hotelinfoVO1.getArea(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getArea());
		assertEquals(hotelinfoVO1.getFacility(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getFacility());
		assertEquals(hotelinfoVO1.getIntroduction(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getIntroduction());
		assertEquals(hotelinfoVO1.getName(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getName());
		assertEquals(hotelinfoVO1.getTel(),hotelinfo.getBasicinfoList(area, null, 0, null).get(0).getTel());
	}
}
