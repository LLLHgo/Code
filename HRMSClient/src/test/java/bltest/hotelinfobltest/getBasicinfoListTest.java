package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Enum.Star;
import businesslogic.hoteinfobl.HotelinfoManage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class getBasicinfoListTest {
	HotelinfoManage hotelinfo = new HotelinfoManage();
	HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000001");
	String area = "山西路商圈";
	@Test
	public void test1(){
		assertEquals(hotelinfoVO1.getAddress(),hotelinfo.getBasicinfoList(area));	
		assertEquals(hotelinfoVO1.getArea(),hotelinfo.getBasicinfoList(area));
		assertEquals(hotelinfoVO1.getFacility(),hotelinfo.getBasicinfoList(area));
		assertEquals(hotelinfoVO1.getIntroduction(),hotelinfo.getBasicinfoList(area));
		assertEquals(hotelinfoVO1.getName(),hotelinfo.getBasicinfoList(area));
		assertEquals(hotelinfoVO1.getTel(),hotelinfo.getBasicinfoList(area));
	}
}
