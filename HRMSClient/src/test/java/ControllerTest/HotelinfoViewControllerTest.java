package ControllerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.HotelStrategy;
import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import Enum.marketingStrategy;
import businesslogic.hoteinfobl.HotelinfoManage;
import javafx.scene.image.Image;
import presentation.hotelinfo.controller.HotelinfoViewController;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelinfoViewControllerTest {
	HotelinfoViewController controller;
	
	HotelinfoManage hotelinfo;
	HotelinfoVO hotelinfoVO1;
	HotelinfoVO hotelinfoVO2;
	HotelinfoVO hotelinfoVO3;
	HotelinfoVO hotelinfoVO4;
	List<HotelinfoVO> hotelList;
	
	RoominfoVO roominfo1 ;
	RoominfoVO roominfo2 ;
	RoominfoVO roominfo3 ;
	RoominfoVO roominfo4 ;
	RoominfoVO roominfo5 ;
	RoominfoVO roominfo6 ;
	List<RoominfoVO> roominfoList;
	
	@Before
	public void setup(){
		hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		
		hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		
		hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		hotelinfoVO4 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000004");
		
		hotelList = new ArrayList<HotelinfoVO>();
		hotelList.add(hotelinfoVO1);
		hotelList.add(hotelinfoVO2);
		hotelList.add(hotelinfoVO3);
		
		roominfo1 = new RoominfoVO("标准间","8304",200, RoomState.Usable);
		roominfo2 = new RoominfoVO("标准间","8305",200, RoomState.Usable);
		roominfo3 = new RoominfoVO("大床房","8306",200, RoomState.Usable);
		roominfo4 = new RoominfoVO("标准间","8307",200, RoomState.Usable);
		roominfo5 = new RoominfoVO("标准间","8308",200, RoomState.Unusable);
		roominfo6 = new RoominfoVO("大床房","8309",200, RoomState.Unusable);
		roominfoList.add(roominfo1);
		roominfoList.add(roominfo2);
		roominfoList.add(roominfo3);
		roominfoList.add(roominfo4);
		roominfoList.add(roominfo5);
		roominfoList.add(roominfo6);
		
		controller = new HotelinfoViewController();
		
		String begin1="2016-11-11 00:00:00";
		String end1="2016-11-11 23:59:59";
		Image image = new Image("Hi");
		ArrayList<HotelinfoVO> hlist=new ArrayList<HotelinfoVO>();
		HotelStrategyVO V1=new HotelStrategyVO("H00000001",HotelStrategy.SPECIALDAY,
	    		begin1,end1,0.75,image,"North");
	}
	
	@Test
	public void testgetBasicInfo(){
		assertEquals(hotelinfoVO1.getAddress(),controller.getBasicinfo("H00000001").getAddress());
		assertEquals(hotelinfoVO1.getArea(),controller.getBasicinfo("H00000001").getArea());
		assertEquals(hotelinfoVO1.getName(),controller.getBasicinfo("H00000001").getName());
		assertEquals(hotelinfoVO1.getStar(),controller.getBasicinfo("H00000001").getStar());
	}
	
	
	@Test
	public void testsaveSitemanagerAdd(HotelinfoVO vo){
		assertEquals(true,controller.saveSitemanagerAdd(hotelinfoVO1));
		assertEquals(true,controller.saveSitemanagerAdd(hotelinfoVO2));
		assertEquals(false,controller.saveSitemanagerAdd(hotelinfoVO4));
	}
	
	@Test
	public 
}
