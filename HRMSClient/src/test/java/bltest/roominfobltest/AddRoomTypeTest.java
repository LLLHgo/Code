package bltest.roominfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogic.hoteinfobl.RoominfoManage;

@Ignore("roominfomanage已经调用真实dataservice，不需要桩")
public class AddRoomTypeTest {

	RoominfoManage roominfo = new RoominfoManage();

	@Test
	public void test1(){
		//重复，不添加
		assertEquals(false,roominfo.addRoomType("标准间"));
	}
	
	@Test
	public void test2(){
		//无内容，不添加
		assertEquals(false,roominfo.addRoomType(""));
	}

	
	@Test
	public void test3(){
		//无内容，不添加
		assertEquals(false,roominfo.addRoomType(null));
	}
}
