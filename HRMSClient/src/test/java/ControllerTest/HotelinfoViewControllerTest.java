package ControllerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.Star;
import businesslogic.hoteinfobl.HotelinfoManage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class HotelinfoViewControllerTest {
	HotelinfoManage hotelinfo;
	HotelinfoVO hotelinfoVO1;
	HotelinfoVO hotelinfoVO2;
	HotelinfoVO hotelinfoVO3;
	List<HotelinfoVO> list;
	@Before
	public void setup(){
		hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		
		hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		
		hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfoVO1);
		list.add(hotelinfoVO2);
		list.add(hotelinfoVO3);
	}
	
	@Test
	public void testgetBasicInfo(){
		assertEquals(hotelinfoVO1.getAddress(),hotelinfo.getBasicinfo("H00000001").getAddress());
		assertEquals(hotelinfoVO1.getArea(),hotelinfo.getBasicinfo("H00000001").getArea());
		assertEquals(hotelinfoVO1.getName(),hotelinfo.getBasicinfo("H00000001").getName());
		assertEquals(hotelinfoVO1.getStar(),hotelinfo.getBasicinfo("H00000001").getStar());
	}
	
}
