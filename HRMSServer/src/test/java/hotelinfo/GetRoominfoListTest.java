package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Enum.RoomState;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import po.RoominfoPO;

public class GetRoominfoListTest {
	HotelinfoDataServiceMySqlImpl mysql;
	ArrayList<RoominfoPO> roominfoList;
	public GetRoominfoListTest(){
		try {
			mysql = new HotelinfoDataServiceMySqlImpl();
			RoominfoPO roominfo1 = new RoominfoPO("H00000001","标准间","8304",200, RoomState.Usable);
			RoominfoPO roominfo2 = new RoominfoPO("H00000001","标准间","8305",200, RoomState.Usable);
			RoominfoPO roominfo3 = new RoominfoPO("H00000001","大床房","8306",200, RoomState.Usable);
			RoominfoPO roominfo4 = new RoominfoPO("H00000001","标准间","8307",200, RoomState.Usable);
			RoominfoPO roominfo5 = new RoominfoPO("H00000001","标准间","8308",200, RoomState.Unusable);
			RoominfoPO roominfo6 = new RoominfoPO("H00000001","大床房","8309",200, RoomState.Unusable);
			roominfoList = new ArrayList<RoominfoPO>();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		//正确
		try {
			assertEquals("H00000001",mysql.getRoominfoList("H00000001").get(0).getHotelID());
			assertEquals("标准间",mysql.getRoominfoList("H00000001").get(0).getType());
			assertEquals("8304",mysql.getRoominfoList("H00000001").get(0).getRoomNum());
			assertEquals(200,mysql.getRoominfoList("H00000001").get(0).getPrice(),1);
			assertEquals(RoomState.Usable,mysql.getRoominfoList("H00000001").get(0).getRoomState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		//查找不到任何信息
		try {
			assertEquals(null,mysql.getRoominfoList("H00000002"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
