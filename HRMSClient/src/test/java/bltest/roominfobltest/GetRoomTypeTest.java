package bltest.roominfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.hoteinfobl.RoominfoManage;
@Ignore("roominfomanage已经调用真实dataservice，不需要桩")
public class GetRoomTypeTest {

	String[] s = {"标准间","大床房","总统套房"};
	RoominfoManage r = new RoominfoManage();
	
	@Test
	public void test1(){
		assertEquals(s,r.getRoomType());
	}
}
