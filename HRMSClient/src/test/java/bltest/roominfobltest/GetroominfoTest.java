package bltest.roominfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.hoteinfobl.RoominfoManage;

@Ignore("roominfomanage已经调用真实dataservice，不需要桩")
public class GetroominfoTest {

	RoominfoManage roominfo = new RoominfoManage();
	
	@Test
	public void test1(){
		//正确
		assertEquals("8304",roominfo.getroominfo("H00000001","8304").getRoomNum());
	}
	
	@Test
	public void test2(){
		//酒店不存在
		assertEquals(null,roominfo.getroominfo("H00000002","8304"));
	}
	
	@Test
	public void test3(){
		//房间不存在
		assertEquals(null,roominfo.getroominfo("H00000001","8310"));
	}
}
