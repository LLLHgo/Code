package bltest.roominfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.RoomState;
import businesslogic.hoteinfobl.RoominfoManage;
import vo.hotelinfoVO.RoominfoVO;
@Ignore("roominfomanage已经调用真实dataservice，不需要桩")
public class UpdateroominfoTest {

	RoominfoManage roominfo= new RoominfoManage();
	RoominfoVO roominfo1 = new RoominfoVO("H00000001","标准间","8304",200, RoomState.Usable);
	
	@Test
	public void test1(){
		assertEquals(true,roominfo.updateroominfo(roominfo1, "H00000001"));
	}
}
