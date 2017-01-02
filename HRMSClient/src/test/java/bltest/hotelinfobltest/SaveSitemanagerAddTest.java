package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;


@Ignore("hotelinfomanage已经调用真实dataservice，不需要桩")
public class SaveSitemanagerAddTest {

	HotelinfoBLService hotelinfo = new HotelinfoBLService_Stub();
	SitemanagerAddVO sVO1 = new SitemanagerAddVO("LLLH酒店");
	SitemanagerAddVO sVO2 = new SitemanagerAddVO("新酒店");
	HotelstaffVO hVO = new HotelstaffVO("H00000002","000000","12345678");
	@Test
	public void test1(){
		//成功
		assertEquals(ResultMessage.SUCCESS,hotelinfo.saveSitemanagerAdd(sVO2, hVO));
	}
	
	@Test
	public void test2(){
		//因为酒店名称重复而导致的失败
		assertEquals(ResultMessage.DUPLICATENAME,hotelinfo.saveSitemanagerAdd(sVO1, hVO));
	}
}
